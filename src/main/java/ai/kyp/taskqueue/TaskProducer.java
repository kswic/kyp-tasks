package ai.kyp.taskqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

import static ai.kyp.taskqueue.TaskQueueRunner.QUEUE_CAPACITY;

@Slf4j
public class TaskProducer extends Thread {

    public static final String STOP_PRODUCING_MESSAGE = "no more expressions";
    private static final int WAIT_MILLIS = 100;
    public static final int NUMBER_OF_EXPRESSIONS_TO_COMPUTE = 10;

    private final BlockingQueue<String> computationQueue;
    private final ExpressionGenerator expressionGenerator;

    public TaskProducer(BlockingQueue<String> computationQueue, ExpressionGenerator expressionGenerator) {
        this.computationQueue = computationQueue;
        this.expressionGenerator = expressionGenerator;
    }

    public void run() {
        for (int i = 0; i < NUMBER_OF_EXPRESSIONS_TO_COMPUTE; i++) {
            try {
                String expression = expressionGenerator.generate();
                addToQueue(expression);

                log.info("Sent expression #{}: {} - remaining capacity: {}", i, expression, computationQueue.remainingCapacity());
            } catch (Exception e) {
                log.error("TaskConsumer exception", e);
            }
        }

        while (!computationQueue.isEmpty()) {
            try {
                log.info("Wait to finish processing by consumers...");
                Thread.sleep(WAIT_MILLIS);
            } catch (InterruptedException e) {
                log.error("TaskConsumer exception", e);
            }
        }
        log.info("Queue is empty, send stop message to the consumers");
        addToQueue(STOP_PRODUCING_MESSAGE);
        addToQueue(STOP_PRODUCING_MESSAGE);
    }

    private void addToQueue(String expression) {
        boolean added = computationQueue.offer(expression);
        if (!added) {
            while (computationQueue.remainingCapacity() < QUEUE_CAPACITY / 2) {
                try {
                    log.warn("Sleeping...");
                    Thread.sleep(WAIT_MILLIS);
                    log.warn("Awake...");
                } catch (InterruptedException e) {
                    log.error("TaskConsumer exception", e);
                }
            }
            log.warn("Awake and try add to queue...");
            addToQueue(expression);
        }
    }

}
