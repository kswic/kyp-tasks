package ai.kyp.islands;

import java.util.Random;

public class MapGenerator {

    private final int height;
    private final int width;

    public MapGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        if ((long) this.height * this.width > 10_000_000_000L) {
            throw new IllegalArgumentException("Given size is too big!");
        }
    }

    byte[][] generateMap(int numOfIslands) {

        byte[][] map = new byte[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = 0;
            }
        }

        Random random = new Random();

        while (numOfIslands > 0) {
            int y = random.nextInt(height);
            int x = random.nextInt(width);
            if (map[y][x] == 0 && !hasNeighbours(map, y, x)) {
                map[y][x] = 1;
                --numOfIslands;
            }
        }

        return map;
    }

    private boolean hasNeighbours(byte[][] map, int currentY, int currentX) {
        int minY = Math.max(currentY - 1, 0);
        int maxY = Math.min(currentY + 1, this.height - 1);

        int minX = Math.max(currentX - 1, 0);
        int maxX = Math.min(currentX + 1, this.width - 1);

        for (int ny = minY; ny <= maxY; ny++) {
            for (int nx = minX; nx <= maxX; nx++) {
                if (map[ny][nx] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
