package ai.kyp.taskqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ai.kyp.taskqueue.DefaultExpressionGenerator.MAX_COMPONENT_VALUE;

public class DefaultExpressionSolverTests {

    private final ExpressionSolver expressionSolver = new DefaultExpressionSolver();

    @Test
    public void shouldSolveRandomExpression1() {
        Double result = expressionSolver.solve("34699/15343+38810/58957-13488");
        Assertions.assertEquals(-13485.080171129575, result);
    }

    @Test
    public void shouldSolveRandomExpression2() {
        Double result = expressionSolver.solve("43596-0.45508875476398797");
        Assertions.assertEquals(43595.54491124523, result);
    }

    @Test
    public void shouldSolveRandomExpression3() {
        Double result = expressionSolver.solve("40499-67033-97420-3.792572994E9");
        Assertions.assertEquals(-3.792696948E9, result);
    }

    @Test
    public void shouldSolveRandomExpression4() {
        Double result = expressionSolver.solve("-26534.0-97420-3.792572994E9");
        Assertions.assertEquals(-3.792696948E9, result);
    }


    @Test
    public void shouldSolveRandomExpression5() {
        Double result = expressionSolver.solve("89253/10909");
        Assertions.assertEquals(8.181593179943166, result);
    }

    @Test
    public void shouldSolveRandomExpression6() {
        Double result = expressionSolver.solve("1451/34816+99226/50177/81262");
        Assertions.assertEquals(0.04170057591724671, result);
    }

    @Test
    public void shouldSolveRandomExpression7() {
        Double result = expressionSolver.solve("61972/16709/8137*32027");
        Assertions.assertEquals(14.598122273664783, result);
    }

    @Test
    public void shouldSolveExpressionWithAllLowPrioOperations(){
        Double result = expressionSolver.solve("69922+8.143432416E9+8238+4.673389024E9");
        Assertions.assertEquals(1.28168996E10, result);
    }

    @Test
    public void shouldSolveExpressionWithAllHighPrioOperations(){
        Double result = expressionSolver.solve("42858/87922/74732/9573/85117/1717");
        Assertions.assertEquals(4.662223342533319E-18, result);
    }

    @Test
    public void shouldSolveRandomExpressionWithAllTypeOfOperations() {
        Double result = expressionSolver.solve("34699*15343+38810/58957-13488");
        Assertions.assertEquals(5.323732696582764E8, result);
    }

    @Test
    public void shouldNotFailWhenDivisionByZero() {
        Double result = expressionSolver.solve("34699/0+38810/58957-13488");
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void shouldSolveExpressionWithMaxValues() {
        Object[] componentValues = new Integer[5];
        Arrays.fill(componentValues, MAX_COMPONENT_VALUE);
        Double result = expressionSolver.solve(String.format("%d*%d*%d*%d*%d", componentValues));
        Assertions.assertEquals(1.0E25, result);
    }

}
