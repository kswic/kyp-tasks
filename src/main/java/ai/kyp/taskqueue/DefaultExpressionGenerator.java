package ai.kyp.taskqueue;

import java.util.Random;

public class DefaultExpressionGenerator implements ExpressionGenerator {

    public static final int MIN_COMPONENT_VALUE = 0;
    public static final int MAX_COMPONENT_VALUE = 100_000;
    public static final String[] OPERATIONS = new String[]{"+", "-", "*", "/"};
    public static final int MAX_NUMBER_OF_OPERATIONS = 5;
    public static final int MIN_NUMBER_OF_OPERATIONS = 1;
    private final Random random = new Random();

    @Override
    public String generate() {
        int numberOfOperations = random.nextInt(MAX_NUMBER_OF_OPERATIONS) + MIN_NUMBER_OF_OPERATIONS; // from 1 to 5 operations in expression
        int numberOfComponents = numberOfOperations + 1;
        return random.ints(MIN_COMPONENT_VALUE, MAX_COMPONENT_VALUE)
                .limit(numberOfComponents)
                .mapToObj(String::valueOf)
                .reduce("", (s1, s2) -> s1 + (s1.length() != 0 ? drawOperation() : "") + s2);
    }

    private String drawOperation() {
        int i = random.nextInt(OPERATIONS.length);
        return OPERATIONS[i];
    }
}
