import java.util.ArrayList;

public class Colonist {
    // When the game starts the three Colinist traits are set to 70%
    public int howHungry, howTired, howHappy = 70;
    // Set by the player at the start of the game
    public String colonistName;

    /**
     * 
     * @return ArrayList called colonist containing all properties that are colonist
     *         can have such as:
     *         current tile, how hungry, how tired, how happy, possible directions
     *         (north, east, south west)
     */
    public ArrayList<Integer> getColonistStats() {
        ArrayList<Integer> colonist = new ArrayList<Integer>();

        colonist.set(0, getTile());
        colonist.set(1, getHowHungry());
        colonist.set(2, getHowTired());
        colonist.set(3, getHowHappy());
        for (int i = 4; i < 8; i++) {
            colonist.set(i, World.getPossibleDirections().get(i - 4));
        }

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

    public Boolean getExhauted() {
        return true;
    }

    public Boolean getStarving() {
        return true;
    }

    public Boolean getDepressed() {
        return true;
    }

    public int getTile() {
        return World.getColonistLocation();
    }

    public int getDirections() {
        return World.getPossibleDirections();
    }
}
