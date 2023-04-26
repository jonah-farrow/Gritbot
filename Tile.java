import java.util.ArrayList;

public class Tile {
    /*
     * Class to handle events and tasks that can be completed on a tile-by-tile
     * basis
     */

    public static void whatCanDo() {
        ArrayList<String> tileInformation = new ArrayList<String>();
        tileInformation.add("Colonist is currently in tile: " + World.getColonistLocation());
        tileInformation.add("Their available directions are: " + World.getPossibleDirections());

    }
}
