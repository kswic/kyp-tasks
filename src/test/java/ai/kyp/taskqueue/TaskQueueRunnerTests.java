package ai.kyp.taskqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskQueueRunnerTests {

    @Test
    void shouldExecuteTaskQueueRunnerWithArgs() {
        TaskQueueRunner.main(new String[]{"4", "6", "20"});
        Assertions.assertTrue(true);
    }

    @Test
    void shouldExecuteTaskQueueRunnerWithWrongNumberOfArgs() {
        TaskQueueRunner.main(new String[]{"4", "6"});
        Assertions.assertTrue(true);
    }

    @Test
    void shouldExecuteTaskQueueRunnerWithoutArgs() {
        TaskQueueRunner.main(new String[]{});
        Assertions.assertTrue(true);
    }

}
