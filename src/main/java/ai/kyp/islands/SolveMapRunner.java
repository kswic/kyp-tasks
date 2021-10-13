package ai.kyp.islands;

import ai.kyp.islands.service.IslandsAreaService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Example of application counting islands on map.
 */
public class SolveMapRunner {

    public static final String VALUE_DELIMITER = " ";

    public static void main(String... args) {
        String fileName = args[0];
        byte[][] map = initializeMap(fileName);
        fillMapWithValues(map, fileName);

        IslandsAreaService islandsArea = new IslandsAreaService(map);
        int count = islandsArea.countIslands();

        System.out.printf("Given map contains %d islands.", count);
    }

    private static byte[][] initializeMap(String fileName) {
        int mapHeight = 0;
        int mapWidth = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                mapHeight++;
                mapWidth = line.trim().split(VALUE_DELIMITER).length;
            }
            while (reader.readLine() != null) {
                mapHeight++;
            }
        } catch (IOException e) {
            System.err.println("Couldn't determine the map size!");
            e.printStackTrace();
            return new byte[][]{};
        }

        return new byte[mapHeight][mapWidth];
    }

    private static void fillMapWithValues(byte[][] map, String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                for (int y = 0; y < map.length; y++) {
                    String[] line = scanner.nextLine().trim().split(VALUE_DELIMITER);
                    for (int x = 0; x < map[0].length; x++) {
                        map[y][x] = Byte.parseByte(line[x]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File couldn't be found!");
            e.printStackTrace();
        }
    }

}
