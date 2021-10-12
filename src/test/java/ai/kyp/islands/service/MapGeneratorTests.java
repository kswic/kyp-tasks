package ai.kyp.islands.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapGeneratorTests {

    @Test
    void shouldGenerateMapOfGivenSize() {
        int height = 500, width = 1000;
        MapGenerator generator = new MapGenerator(height, width);

        byte[][] map = generator.generateMap(4);

        Assertions.assertEquals(height, map.length);
        Assertions.assertEquals(width, map[0].length);
    }

    @Test
    void shouldThrowExceptionWhenMapSizeToBig() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MapGenerator(1_000_000, 1_000_000));
    }

}
