package ai.kyp.taskqueue.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ai.kyp.taskqueue.service.DefaultExpressionGenerator.OPERATIONS;

class DefaultExpressionGeneratorTests {

    private final ExpressionGenerator expressionGenerator = new DefaultExpressionGenerator();

    @Test
    void shouldNotStartExpressionWithOperationSign() {
        String expression = expressionGenerator.generate();
        Assertions.assertTrue(Arrays.stream(OPERATIONS).noneMatch(expression::startsWith));
        Assertions.assertTrue(Arrays.stream(OPERATIONS).noneMatch(expression::endsWith));
    }

    @Test
    void shouldContainAtLeastOneOperation() {
        String expression = expressionGenerator.generate();
        Assertions.assertTrue(Arrays.stream(OPERATIONS).anyMatch(expression::contains));
    }

}
