package ai.kyp.taskqueue.task.factory;

import ai.kyp.taskqueue.service.DefaultExpressionSolver;
import ai.kyp.taskqueue.service.ExpressionSolver;
import ai.kyp.taskqueue.task.TaskConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import static ai.kyp.taskqueue.task.factory.TaskProducersFactory.DEFAULT_CONSUMERS_COUNT;

/**
 * Create a list of consumer task threads.
 */
public class TaskConsumersFactory {

    private static final ExpressionSolver expressionSolver = new DefaultExpressionSolver();

    private TaskConsumersFactory() {
        throw new AssertionError();
    }

    public static List<TaskConsumer> createDefaultConsumers(BlockingQueue<String> computationQueue) {
        return createConsumers(DEFAULT_CONSUMERS_COUNT, computationQueue);
    }

    public static List<TaskConsumer> createConsumers(int numberOfConsumers, BlockingQueue<String> computationQueue) {
        List<TaskConsumer> consumers = new ArrayList<>();
        for (int i = 1; i <= numberOfConsumers; i++) {
            consumers.add(new TaskConsumer(computationQueue, expressionSolver));
        }

        return consumers;
    }

}
