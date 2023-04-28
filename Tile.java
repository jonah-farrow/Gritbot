import java.util.ArrayList;

public class Tile {
    /*
     * Class to handle events and tasks that can be completed on a tile-by-tile
     * basis
     */
    static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();

    // Need to generate information about the current tile.
    // Generate a task per tile that can be compleated, always 25% chance that
    // current task is available in current tile
    public static ArrayList<String> getTileInformation() {
        int colonistLocation = World.getColonistLocation();
        return arr.get(colonistLocation); // causes issue when colonist is on a world edge, world edge reserved numbers
                                          // are incompatible with this call
    }

    public static ArrayList<String> generateTile() {
        double r = Math.random() * (19 - 0);
        ArrayList<String> tileInfo = new ArrayList<String>();
        tileInfo.add("Colonist is currently in tile: " + World.getColonistLocation());
        tileInfo.add("Task available in this tile: " + Task.getTask((int) (r)));
        tileInfo.add("Available directions are: " + World.getPossibleDirections()); // returns empty array at this point
        arr.add(tileInfo);
        return tileInfo;
    }

    public static String getTileTask() {
        String[] task = arr.get(World.getColonistLocation()).get(1).split(": ");
        System.out.println(task[1]);
        return task[1];
    }

    public static Boolean carryOutTask() {
        if (doesTileContainCurrentTask()) {
            if (Task.taskSwitchTable()) { // change to carry out task
                Task.setTask("No Task");
                // change task
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static Boolean doesTileContainCurrentTask() {
        if (getTileTask().contains(Task.getCurrentTask())) {
            return true;
        } else {
            return false;
        }
    }
}
