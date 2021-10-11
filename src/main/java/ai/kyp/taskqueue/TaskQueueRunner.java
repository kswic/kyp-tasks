package ai.kyp.taskqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskQueueRunner {

    public static final int QUEUE_CAPACITY = 10;

    private static final ExpressionGenerator expressionGenerator = new DefaultExpressionGenerator();
    private static final ExpressionSolver expressionSolver = new DefaultExpressionSolver();

    public static void main(String[] args) {
        BlockingQueue<String> computationQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
        new TaskConsumer(computationQueue, expressionSolver).start();
        new TaskConsumer(computationQueue, expressionSolver).start();
        new TaskConsumer(computationQueue, expressionSolver).start();
        new TaskConsumer(computationQueue, expressionSolver).start();
        new TaskProducer(computationQueue, expressionGenerator).start();
        new TaskProducer(computationQueue, expressionGenerator).start();
    }
}
