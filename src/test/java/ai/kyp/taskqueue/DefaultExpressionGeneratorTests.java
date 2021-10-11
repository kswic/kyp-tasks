package ai.kyp.taskqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ai.kyp.taskqueue.DefaultExpressionGenerator.OPERATIONS;

public class DefaultExpressionGeneratorTests {

    private final ExpressionGenerator expressionGenerator = new DefaultExpressionGenerator();

    @Test
    public void shouldNotStartExpressionWithOperationSign() {
        String expression = expressionGenerator.generate();
        Assertions.assertTrue(Arrays.stream(OPERATIONS).noneMatch(expression::startsWith));
        Assertions.assertTrue(Arrays.stream(OPERATIONS).noneMatch(expression::endsWith));
    }

    @Test
    public void shouldContainAtLeastOneOperation() {
        String expression = expressionGenerator.generate();
        Assertions.assertTrue(Arrays.stream(OPERATIONS).anyMatch(expression::contains));
    }

}
