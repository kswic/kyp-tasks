package ai.kyp.taskqueue.task.factory;

import ai.kyp.taskqueue.service.DefaultExpressionGenerator;
import ai.kyp.taskqueue.service.ExpressionGenerator;
import ai.kyp.taskqueue.task.TaskProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Create a list of producer task threads.
 */
public class TaskProducersFactory {

    public static final int DEFAULT_PRODUCERS_COUNT = 2;
    public static final int DEFAULT_PRODUCED_EXPRESSIONS_COUNT = 10;
    public static final int DEFAULT_CONSUMERS_COUNT = 4;

    private static final ExpressionGenerator expressionGenerator = new DefaultExpressionGenerator();

    private TaskProducersFactory() {
        throw new AssertionError();
    }

    public static List<TaskProducer> createDefaultProducers(BlockingQueue<String> computationQueue) {
        return createProducers(DEFAULT_PRODUCERS_COUNT, DEFAULT_PRODUCED_EXPRESSIONS_COUNT, DEFAULT_CONSUMERS_COUNT, computationQueue);
    }

    public static List<TaskProducer> createProducers(int numberOfProducers, int numberOfProducedExpressions, int numberOfConsumers, BlockingQueue<String> computationQueue) {
        List<TaskProducer> producers = new ArrayList<>();
        for (int i = 1; i <= numberOfProducers; i++) {
            producers.add(new TaskProducer(computationQueue, expressionGenerator, numberOfProducedExpressions, numberOfConsumers));
        }

        return producers;
    }

}
