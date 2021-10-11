package ai.kyp.islands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IslandsAreaTests {

    @Test
    public void shouldCountIslands1() {
        byte[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0}
        };

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(4, count);
    }

    @Test
    public void shouldCountIslands2() {
        byte[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(2, count);
    }

    @Test
    public void shouldCountIslands3() {
        byte[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(10, count);
    }

    @Test
    public void shouldCountIslands4() {
        byte[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
        };

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(4, count);
    }

    @Test
    public void shouldHandleHigherByteValuesThanOne() {
        byte[][] map = {
                {0, 0, 0, 2, 5, 6, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 6, 7, 0, 0, 0, 0, 0, 0}
        };

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(2, count);
    }

    @Test
    public void shouldHandleGeneratedMap() {
        MapGenerator generator = new MapGenerator(10, 10);
        byte[][] map = generator.generateMap(5);

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(5, count);
    }

    @Test
    public void shouldHandleMapOfMaxSize() {
        MapGenerator generator = new MapGenerator(100_000, 100_000);
        byte[][] map = generator.generateMap(50);

        IslandsArea islandsArea = new IslandsArea(map);
        int count = islandsArea.countIslands();

        Assertions.assertEquals(50, count);
    }

    @Test
    public void shouldThrowExceptionWhenMapIsTooLarge() {
        byte[][] map = new byte[100_000][100_001];

        Assertions.assertThrows(IllegalArgumentException.class, () -> new IslandsArea(map));
    }

}
