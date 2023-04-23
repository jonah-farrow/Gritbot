import java.util.ArrayList;
import java.util.HashMap;

public class World {
    /**
     * This file generates the world that the AI will live in
     * The world is currently a 10 x 10 matrix
     * Each plot in the matrix represents 1 tile of the world
     * Plots that are uninhabited by the AI can have world-events occur
     * These events can affect how the AI chooses to survive
     */

    /**
     * Key purpose in worldMap:
     * Stores coordinates of map
     * Coordinates of map represent a 10x10 tile map, using numbers between 0-9 over
     * [x][y]
     * The colonist starts in tile [5][5]
     */
    /**
     * Value purpose in worldMap:
     * Stores properties of tile
     * Properties are represented by numbers in the range 0-9
     * The more digits in a value, the more properties that tile possesses
     * The first digit in the value is wether the colonist is present in that tile,
     * 0 for false, 1 for true
     */
    static HashMap<Integer, Integer> worldMap = new HashMap<Integer, Integer>();
    static ArrayList<Integer> possibleDirections = new ArrayList<Integer>(); // North, East, South, West
    static int colonistLocation = 50;
    static Boolean worldSetup; // is needed?

    // runs once at the beginning of the game
    public static void generateStartingWorldMap() {
        for (int f = 0; f < 100; f++) {
            worldMap.put(f, 0);

            System.out.print(f + " "); // DEBUG: is iterating 100 times
        }
        worldMap.put(colonistLocation, 1); // value = 1, represent colonist starting space

        System.out.println("\n");

        /*
         * Initialises possible directions array at start of game
         */
        possibleDirections.add(0);
        possibleDirections.add(0);
        possibleDirections.add(0);
        possibleDirections.add(0);
    }

    /**
     * Method to update the set of available directions for use by the colonist
     * numbers 100, 101, 102, and 103 are reserved to represent world edges in
     * certain directions, e.g., if the set of possibleDirections is [100,101, x, y]
     * then the colonist is in the north east most corner of the map
     * 
     * 
     * @return An ArrayList of Integers representing the current directions the
     *         colonist could take
     */
    public static ArrayList<Integer> updatePossibleDirections() { // investigate if 100, 101, 102, 103 are appropriate
                                                                  // boundry numbers, should they be just if >= 100?

        if (colonistLocation - 10 < 0) {
            possibleDirections.set(0, 100); // 100 = Reached most northern tiles of world
        } else {
            possibleDirections.set(0, (colonistLocation - 10)); // New North tile
        }
        if (colonistLocation + 1 > 99) {
            possibleDirections.set(1, 101); // 101 = Reached most eastern tiles of world
        } else {
            possibleDirections.set(1, (colonistLocation + 1)); // New East tile
        }
        if (colonistLocation + 10 > 99) {
            possibleDirections.set(2, 102); // 102 = Reached most southern tiles of world
        } else {
            possibleDirections.set(2, (colonistLocation + 10)); // New South tile
        }
        if (colonistLocation - 1 < 0) {
            possibleDirections.set(3, 103); // 103 = Reached most western tiles fo the world
        } else {
            possibleDirections.set(3, (colonistLocation - 1)); // New West tile
        }
        return possibleDirections;
    }

    /**
     * Updates colonist location to be the new destination tile
     * 
     * @param destination is destination tile
     * @return updated world-view
     */
    public static ArrayList<Integer> updateColonistLocation(int destination) {
        colonistLocation = destination; // New colonistLocation is destination (has now moved)
        return updatePossibleDirections(); // Update possible destinations given colonist is on new tile
    }

    /**
     * Getter-methods
     */

    public static int getColonistLocation() {
        return colonistLocation;
    }

    public static ArrayList<Integer> getPossibleDirections() {
        return possibleDirections;
    }
}
