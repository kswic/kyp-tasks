package ai.kyp.islands.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandsAreaServiceTests {

    @Test
    void shouldCountIslands1() {
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

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(4, count);
    }

    @Test
    void shouldCountIslands2() {
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

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(2, count);
    }

    @Test
    void shouldCountIslands3() {
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

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(10, count);
    }

    @Test
    void shouldCountIslands4() {
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

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(4, count);
    }

    @Test
    void shouldHandleHigherByteValuesThanOne() {
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

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(2, count);
    }

    @Test
    void shouldHandleGeneratedMap() {
        MapGenerator generator = new MapGenerator(10, 10);
        byte[][] map = generator.generateMap(5);

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(5, count);
    }

    @Test
    void shouldHandleMapOfMaxSize() {
        MapGenerator generator = new MapGenerator(10_000, 10_000);
        byte[][] map = generator.generateMap(50);

        IslandsAreaService islandsAreaService = new IslandsAreaService(map);
        int count = islandsAreaService.countIslands();

        Assertions.assertEquals(50, count);
    }

    @Test
    void shouldThrowExceptionWhenMapIsTooLarge() {
        byte[][] map = new byte[10_000][10_001];

        Assertions.assertThrows(IllegalArgumentException.class, () -> new IslandsAreaService(map));
    }

}
