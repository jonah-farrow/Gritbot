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

        System.out.println("Creating World Map...\n");
        World.generateStartingWorldMap();

        System.out.println("Creating Colonist...\n");
        Colonist me = new Colonist();

        System.out.println("Giving Colonist Work to Complete...\n");
        Task.generateTaskList();

        System.out.println("Creating possible directions...\n");
        World.updatePossibleDirections();

        while (!gameOver) { // Begin game
            // take sensor input

            Environment.setEnvironmentLevels(SensorInterface.getLux(), SensorInterface.getTemp(),
                    SensorInterface.getHumidity());

            // output possible colonist directions
            System.out.println("Possible directions: " + World.getPossibleDirections());

            // world event trigger (temporary or permanent event in current tile)
            System.out.println("Current Event: " + Event.getEvent());

            // colonist moves (in a direction)
            System.out.println("New Directions: " + me.moveTile());

            // memorise event
            // carrys out task (success or fail in that tile)
            System.out.println(Task.decideWhatTaskToComplete());
            // adjust colonist traits depending on outcome

            // process (delay for game output)

            // output colonist stats
            System.out.println(me.getColonistStats());

            // colonist died/unexpected end to game
            gameOver = true; // Game over, stop game.

        }
        long end = System.currentTimeMillis();
    }
}
