import java.time.*;

public class Game {

    public static void runGame() {
        boolean gameOver = false;
        long start = System.currentTimeMillis();

        System.out.println("Creating World Map...\n");
        World.generateStartingWorldMap();

        System.out.println("Creating Colonist...\n");
        Colonist me = new Colonist();

        System.out.println("Giving Colonist Work to Complete...\n");
        Task.generateTaskList();

        System.out.println("Creating possible directions...\n");
        World.updatePossibleDirections();

        while (!gameOver) { // Begin game

            System.out.println("Possible directions: " + World.getPossibleDirections());

            // take gInput (god input)

            // colonist moves (in a direction)
            // me.moveTile(0);

            // world event trigger (temporary or permanent event in current tile)

            // memorise event

            // carrys out task (success or fail in that tile)

            // process (delay for game output)

            // adjust colonist traits depending on outcome

            // output colonist stats
            System.out.println(me.getColonistStats());

            // colonist died/unexpected end to game
            gameOver = true; // Game over, stop game.

        }
        long end = System.currentTimeMillis();
    }
}
