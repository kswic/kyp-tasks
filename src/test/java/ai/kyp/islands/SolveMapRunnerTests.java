package ai.kyp.islands;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;

class SolveMapRunnerTests {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void shouldSolveMap() {
        URL resource = SolveMapRunnerTests.class.getResource("/map.txt");
        Assertions.assertNotNull(resource);

        SolveMapRunner.main(resource.getPath());

        Assertions.assertEquals("Given map contains 4 islands.", outContent.toString());
    }

    @Test
    void shouldFailWhenFileNotFound() {
        SolveMapRunner.main("file:/notExistingFile.txt");

        Assertions.assertTrue(errContent.toString().startsWith("Couldn't determine the map size!"));
    }

    @Test
    void shouldFailWhenFileIsBroken() {
        URL resource = SolveMapRunnerTests.class.getResource("/brokenMap.txt");
        Assertions.assertNotNull(resource);

        String path = resource.getPath();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> SolveMapRunner.main(path));
    }

}
