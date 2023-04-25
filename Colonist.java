import java.util.ArrayList;
import java.util.HashMap;
import java.math.*;

public class Colonist {
    // When the game starts the three Colinist traits are set to 70%
    public static int howHungry, howTired, howHappy = 70;
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
    public static HashMap<String, Integer> getColonistStats() {
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
     * 1 less hungry, 2, less tired, 3, happier
     * 
     * @param whatDone
     */
    public static void traitIncrease(int whatDone) {
        switch (whatDone) {
            case 1:
                modifyHowHungry(true);
                break;
            case 2:
                modifyHowTired(true);
                break;
            case 3:
                modifyHowHappy(true);
                break;
            default:
                break;
        }
    }

    /**
     * 1, more hungry, 2, more tired, 3, sadder
     * 
     * @param whatDone
     */
    public static void traitDecrease(int whatDone) {
        switch (whatDone) {
            case 1:
                modifyHowHungry(false);
                break;
            case 2:
                modifyHowTired(false);
                break;
            case 3:
                modifyHowHappy(false);
                break;
            default:
                break;
        }
    }

    /**
     * Over time these traits naturally decrease,
     * Or as the Colonist completes tasks successfuly such as eating; sleeping,
     * playing a game, their stats are replenished
     */

    public static void modifyHowHungry(Boolean flag) {
        if (flag)
            howHungry++;
        else
            howHungry--;
    }

    public void setHowHungry(int set) {
        howHungry = set;
    }

    // To-do, if howHappy >= 100% have special benefit occur to AI
    public static void modifyHowHappy(Boolean flag) {
        if (flag)
            howHappy++;
        else
            howHappy--;
    }

    public void setHowHappy(int set) {
        howHappy = set;
    }

    public static void modifyHowTired(Boolean flag) {
        if (flag)
            howTired++;
        else
            howTired--;

    }

    public void setHowTired(int set) {
        howTired = set;
    }

    /**
     * Method to move the colonist to a random, valid, destinition from the set of
     * directions
     * 
     * @return
     * 
     * @return current map-view of where colonist is now
     */
    public ArrayList<Integer> moveTile() {
        double random = Math.random() * 4;
        int destination = World.possibleDirections.get((int) random); // change this to use the getPossibleDirections
                                                                      // method
        World.updateColonistLocation(destination);
        return World.getPossibleDirections();
    }

    /**
     * Getter-methods
     */

    public String getColonistName() {
        return colonistName;
    }

    public static int getHowHungry() {
        return howHungry;
    }

    public static int getHowTired() {
        return howTired;
    }

    public static int getHowHappy() {
        return howHappy;
    }

    public Boolean isExhauted() {
        return true;
    }

    public static int[] getColonistTraits() {
        int[] arr = { getHowHungry(), getHowTired(), getHowHappy() };
        return arr;
    }

    public Boolean isStarving() {
        return true;
    }

    public Boolean isDepressed() {
        return true;
    }

    public static int getTile() { // is bad practice?
        return World.getColonistLocation();
    }

    public ArrayList<Integer> getDirections() {
        return World.getPossibleDirections(); // TODO: create a flow on how all this going to work
    }
}
