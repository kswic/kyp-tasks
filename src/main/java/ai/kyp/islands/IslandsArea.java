package ai.kyp.islands;

public class IslandsArea {

    private final byte[][] map;
    private final int height;
    private final int width;

    public IslandsArea(byte[][] map) {
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;
        if ((long) this.height * this.width > 10_000_000_000L) {
            throw new IllegalArgumentException("Given map is too large!");
        }
    }

    public int countIslands() {
        int islandsCount = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[y][x] == -1) {
                    continue;
                }

                if (map[y][x] == 1) {
                    islandsCount++;
                    findNeighbours(y, x);
                }

                map[y][x] = -1;
            }
        }

        return islandsCount;
    }

    private void findNeighbours(int currentY, int currentX) {
        int minY = Math.max(currentY - 1, 0);
        int maxY = Math.min(currentY + 1, this.height -1);

        int minX = Math.max(currentX - 1, 0);
        int maxX = Math.min(currentX + 1, this.width -1);

        for (int ny = minY; ny <= maxY; ny++) {
            for (int nx = minX; nx <= maxX; nx++) {
                if (map[ny][nx] == -1) {
                    continue;
                }

                if(map[ny][nx] == 1) {
                    map[ny][nx] = -1;
                    findNeighbours(ny, nx);
                }
            }
        }
    }
}
