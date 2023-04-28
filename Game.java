import java.io.IOException;
import java.time.*;

public class Game {

    public static void runGame() throws InterruptedException {
        boolean gameOver = false;
        long start = System.currentTimeMillis();
        String[] arr = { "North", "East", "South", "West" };

        // Start reading
        try {
            SensorInterface.test();
            System.out.println("Sensors Activated: True");
        } catch (IOException e) {
            System.out.println("Sensors Activated: False");
            e.printStackTrace();
        }
        Thread.sleep(1000); // helps the sensor code to get a first reading

        System.out.println("Giving Colonist Work to Complete...\n");
        Task.generateTaskList();

        System.out.println("Creating World Map...\n");
        World.generateStartingWorldMap();

        System.out.println("Creating Colonist...\n");
        Colonist me = new Colonist();

        System.out.println("Creating possible directions...\n");
        World.updatePossibleDirections();

        while (!gameOver) { // Begin game
            // Tile.printTrace();

            // take sensor input
            Environment.setEnvironmentLevels(SensorInterface.getLux(), SensorInterface.getTemp(),
                    SensorInterface.getHumidity());

            // output tile information
            System.out.println(Tile.getTileInformation());

            // output colonist stats
            System.out.println(Colonist.getTraitStatus());

            // world event trigger (temporary or permanent event in current tile)
            System.out.println("Current Event: " + Event.getEvent());

            // what task to complete
            System.out.println("\nTask to complete: " + Task.decideWhatTaskToComplete());

            // carrys out task (success or fail in that tile)
            if (Tile.doesTileContainCurrentTask() && Task.currentTask != "No Task") { // change to getcurrenttask()
                System.out.println("Can complete task here: " + Task.getCurrentTask());
                System.out.println("Attempting to " + Task.getCurrentTask());
                System.out.println("..");
                Thread.sleep(5000, 0);
                System.out.println("...");
                Thread.sleep(3000, 0);
                System.out.println("....");
                Thread.sleep(1000, 0);
                if (Tile.carryOutTask()) {
                    System.out.println("Success!");
                    me.moveTile();
                } else {
                    System.out.println("Failure... trying again");
                }
                System.out.println();
            } else {
                // colonist moves (in a direction)
                System.out.println("\nNew Directions: " + me.moveTile() + "\n");
            }

            Thread.sleep(2000);
            // adjust colonist traits depending on outcome

            // process (delay for game output)

            // colonist died/unexpected end to game
            // gameOver = true; // Game over, stop game.

            System.out.println("\n----------------------------------\n");
        }
        long end = System.currentTimeMillis();
    }
}
