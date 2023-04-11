import java.util.ArrayList;
import java.util.HashMap;

public class Colonist {
    // When the game starts the three Colinist traits are set to 70%
    public int howHungry, howTired, howHappy = 70;
    // Set by the player at the start of the game
    public String colonistName;

    /**
     * 
     * @return HashMap called colonist containing all properties that are colonist
     *         can have such as:
     *         current tile [0], how hungry [1], how tired [2], how happy [3],
     *         possible directions[4][5][6][7]
     *         (north, east, south west)
     */
    public HashMap<String, Integer> getColonistStats() {
        HashMap<String, Integer> colonist = new HashMap<String, Integer>();

        colonist.put("Colonist Location:", getTile());
        colonist.put("Colonist Hunger", getHowHungry());
        colonist.put("Colonist Tiredness", getHowTired());
        colonist.put("Colonist Happiness", getHowHappy());
        colonist.put("North Tile", World.getPossibleDirections().get(0));
        colonist.put("East Tile", World.getPossibleDirections().get(1));
        colonist.put("South Tile", World.getPossibleDirections().get(2));
        colonist.put("West Tile", World.getPossibleDirections().get(3));

        return colonist;

    }

    /**
     * Over time these traits naturally decrease,
     * Or as the Colonist completes tasks successfuly such as eating; sleeping,
     * playing a game, their stats are replenished
     */

    public void modifyHowHungry(Boolean flag) {
        if (flag)
            howHungry++;
        else
            howHungry--;
    }

    public void setHowHungry(int set) {
        howHungry = set;
    }

    // To-do, if howHappy >= 100% have special benefit occur to AI
    public void modifyHowHappy(Boolean flag) {
        if (flag)
            howHappy++;
        else
            howHappy--;
    }

    public void setHowHappy(int set) {
        howHappy = set;
    }

    public void modifyHowTired(Boolean flag) {
        if (flag)
            howTired++;
        else
            howTired--;

    }

    public void setHowTired(int set) {
        howTired = set;
    }

    /**
     * Method to take index over possibleDirections, update currentPosition, then
     * update possibleDirections
     * 
     * @param direction can be the value 1,2,3, and 4 representing in order: North,
     *                  East,
     *                  South, and West
     * 
     * @return current map-view of where colonist is now
     */
    public String moveTile(int direction) {
        int destination = World.possibleDirections.get(direction); // If direction is not in the set of
                                                                   // possibleDirections then the destination is invalid
        World.updateColonistLocation(destination);
        return "";
    }

    /**
     * Getter-methods
     */

    public String getColonistName() {
        return colonistName;
    }

    public int getHowHungry() {
        return howHungry;
    }

    public int getHowTired() {
        return howTired;
    }

    public int getHowHappy() {
        return howHappy;
    }

    public Boolean isExhauted() {
        return true;
    }

    public Boolean isStarving() {
        return true;
    }

    public Boolean isDepressed() {
        return true;
    }

    public int getTile() { // is bad practice?
        return World.getColonistLocation();
    }

    public ArrayList<Integer> getDirections() {
        return World.getPossibleDirections(); // TODO: create a flow on how all this going to work
    }
}
