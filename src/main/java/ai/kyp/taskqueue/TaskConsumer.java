package ai.kyp.taskqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

import static ai.kyp.taskqueue.TaskProducer.STOP_PRODUCING_MESSAGE;

@Slf4j
public class TaskConsumer extends Thread {

    private final BlockingQueue<String> computationQueue;
    private final ExpressionSolver expressionSolver;

    public TaskConsumer(BlockingQueue<String> computationQueue, ExpressionSolver expressionSolver) {
        this.computationQueue = computationQueue;
        this.expressionSolver = expressionSolver;
    }

    public void run() {
        while (true) {
            try {
                String computationExpression = computationQueue.take();
                if (computationExpression.equals(STOP_PRODUCING_MESSAGE)) {
                    log.info("STOP: Received stop message '{}'", computationExpression);
                    break;
                }
                Double result = expressionSolver.solve(computationExpression);
                log.info("Expression '{}' result is: {}", computationExpression, result);
            } catch (Exception e) {
                log.error("TaskConsumer exception", e);
            }
        }
    }

}
