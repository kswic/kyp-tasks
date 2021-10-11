package ai.kyp.islands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapGeneratorTests {

    @Test
    public void shouldGenerateMapOfGivenSize() {
        MapGenerator generator = new MapGenerator(500, 1000);
        byte[][] map = generator.generateMap(4);

        Assertions.assertEquals(500, map.length);
        Assertions.assertEquals(1000, map[0].length);
    }

    @Test
    public void shouldThrowExceptionWhenMapSizeToBig() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MapGenerator(1_000_000, 1_000_000));
    }

}
