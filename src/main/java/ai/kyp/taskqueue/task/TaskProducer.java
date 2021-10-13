package ai.kyp.taskqueue.task;

import ai.kyp.taskqueue.service.ExpressionGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static ai.kyp.taskqueue.TaskQueueRunner.QUEUE_CAPACITY;

/**
 * Produces tasks and put them in the queue.
 */
@Slf4j
public class TaskProducer extends Thread {

    public static final String STOP_PRODUCING_MESSAGE = "no more expressions";
    private static final String CONSUMER_EXCEPTION_MSG = "TaskConsumer exception";
    private static final int HALF_OF_QUEUE_CAPACITY = QUEUE_CAPACITY / 2;
    private static final int QUEUE_CAPACITY_WAIT_MILLIS = 100;
    private static final Lock STOP_CONSUMERS_LOCK = new ReentrantLock();
    private static final AtomicBoolean CONSUMERS_STOPPED = new AtomicBoolean(false);

    private final BlockingQueue<String> computationQueue;
    private final ExpressionGenerator expressionGenerator;
    private final int numberOfProducedExpressions;
    private final int numberOfConsumers;

    public TaskProducer(BlockingQueue<String> computationQueue, ExpressionGenerator expressionGenerator,
                        int numberOfProducedExpressions, int numberOfConsumers) {
        this.computationQueue = computationQueue;
        this.expressionGenerator = expressionGenerator;
        this.numberOfProducedExpressions = numberOfProducedExpressions;
        this.numberOfConsumers = numberOfConsumers;
    }

    @Override
    public void run() {
        for (int i = 1; i <= numberOfProducedExpressions; i++) {
            try {
                String expression = expressionGenerator.generate();
                addToQueue(expression);

                log.info("Sent expression #{}: {} - remaining capacity: {}", i, expression, computationQueue.remainingCapacity());
            } catch (Exception e) {
                log.error(CONSUMER_EXCEPTION_MSG, e);
            }
        }

        stopConsumers();
    }

    private void stopConsumers() {
        STOP_CONSUMERS_LOCK.lock();
        if (!CONSUMERS_STOPPED.get()) {
            log.info("Queue is empty, send stop message to the consumers");
            IntStream.rangeClosed(1, numberOfConsumers).forEach(i -> {
                log.info("Stopping consumer nr {} ...", i);
                addToQueue(STOP_PRODUCING_MESSAGE);
            });

            CONSUMERS_STOPPED.set(true);
        }
        STOP_CONSUMERS_LOCK.unlock();
    }

    private void addToQueue(String expression) {
        boolean added = computationQueue.offer(expression);
        if (!added) {
            while (computationQueue.remainingCapacity() <= HALF_OF_QUEUE_CAPACITY) {
                try {
                    log.warn("Sleeping...");
                    sleep(QUEUE_CAPACITY_WAIT_MILLIS);
                    log.warn("Awake...");
                } catch (InterruptedException e) {
                    log.error(CONSUMER_EXCEPTION_MSG, e);
                    Thread.currentThread().interrupt();
                }
            }
            log.warn("Awake and try add to queue...");
            addToQueue(expression);
        }
    }

}
