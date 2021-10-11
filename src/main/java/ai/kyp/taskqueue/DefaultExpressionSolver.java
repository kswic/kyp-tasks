package ai.kyp.taskqueue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultExpressionSolver implements ExpressionSolver {

    public static final String HIGH_PRIORITY_OPERATIONS_REGEX = "(\\d+\\.?\\d*(E-?\\d+\\.?\\d*)?|Infinity)([\\\\*/]+)(\\d+\\.?\\d*(E-?\\d+\\.?\\d*)?|Infinity)";
    public static final String LOW_PRIORITY_OPERATIONS_REGEX = "([+-]?\\d+\\.?\\d*(E-?\\d+\\.?\\d*)?|Infinity)([+-]+)(\\d+\\.?\\d*(E-?\\d+\\.?\\d*)?|Infinity)";

    public static final Pattern highPriorityOperationsPattern = Pattern.compile(HIGH_PRIORITY_OPERATIONS_REGEX);
    public static final Pattern lowPriorityOperationsPattern = Pattern.compile(LOW_PRIORITY_OPERATIONS_REGEX);

    @Override
    public Double solve(String expression) {
        String halfResult = makeHighPriorityOperations(expression);
        String result = makeLowPriorityOperations(halfResult);

        return Double.parseDouble(result);
    }

    private String makeHighPriorityOperations(String expression) {
        Matcher highPriorityMatcher = highPriorityOperationsPattern.matcher(expression);
        if(!highPriorityMatcher.find()) {
            return expression;
        }

        String result = highPriorityMatcher.replaceFirst(matched -> {
            double comp1 = Double.parseDouble(matched.group(1));
            double comp2 = Double.parseDouble(matched.group(4));
            String operation = matched.group(3);
            switch (operation) {
                case "*":
                    return String.valueOf(comp1 * comp2);
                case "/":
                    return String.valueOf(comp1 / comp2);
                default:
                    return "";
            }
        });

        if (highPriorityOperationsPattern.asPredicate().test(result)) {
            return makeHighPriorityOperations(result);
        }

        return result;
    }

    private String makeLowPriorityOperations(String halfResult) {
        Matcher lowPriorityMatcher = lowPriorityOperationsPattern.matcher(halfResult);
        if(!lowPriorityMatcher.find()) {
            return halfResult;
        }

        String result = lowPriorityMatcher.replaceFirst(matched -> {
            double comp1 = Double.parseDouble(matched.group(1));
            double comp2 = Double.parseDouble(matched.group(4));
            String operation = matched.group(3);
            switch (operation) {
                case "+":
                    return String.valueOf(comp1 + comp2);
                case "-":
                    return String.valueOf(comp1 - comp2);
                default:
                    return "";
            }
        });

        if (lowPriorityOperationsPattern.asPredicate().test(result)) {
            return makeLowPriorityOperations(result);
        }

        return result;
    }
}
