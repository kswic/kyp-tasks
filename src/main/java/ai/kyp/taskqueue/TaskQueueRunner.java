package ai.kyp.taskqueue;

import ai.kyp.taskqueue.task.factory.TaskConsumersFactory;
import ai.kyp.taskqueue.task.factory.TaskProducersFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Example app implementing producer-consumer pattern.
 */
@Slf4j
public class TaskQueueRunner {

    public static final int QUEUE_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<String> computationQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        if (args.length == 3) {
            int producersCount = Integer.parseInt(args[0]);
            int consumersCount = Integer.parseInt(args[1]);
            int expressionsCount = Integer.parseInt(args[2]);

            TaskConsumersFactory.createConsumers(consumersCount, computationQueue).forEach(Thread::start);
            TaskProducersFactory.createProducers(producersCount, expressionsCount, consumersCount, computationQueue).forEach(Thread::start);
        } else {
            log.warn("Wrong number of arguments, running for defaults (2 producers, 4 consumers, 10 math expressions per producer)");
            TaskConsumersFactory.createDefaultConsumers(computationQueue).forEach(Thread::start);
            TaskProducersFactory.createDefaultProducers(computationQueue).forEach(Thread::start);
        }
    }
}
