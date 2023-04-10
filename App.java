public class App {
    public static void main(String[] args) throws Exception {
        World.generateStartingWorldMap();
        Task.generateTaskList();
        System.out.println("Task: " + Task.generateTask());
        World.updatePossibleDirections();
        System.out.println("Possible directions: " + World.getPossibleDirections());
        Colonist me = new Colonist();
        System.out.println(me.getColonistStats());
        Output out = new Output();
        Output.outputFirefight();

        /**
         * The aim is to have the program running in the background of ones daily life
         * we need Gritbot to loop over a long period of time, say 24 hours.
         * To achieve this, Gritbot needs to safely execute its functions without drift.
         * The Java Library ScheduledExecutorService may help to achieve this, see
         * below.
         */

        // final ScheduledExecutorService executorService =
        // Executors.newSingleThreadScheduledExecutor();
        // executorService.scheduleAtFixedRate(App::runGame, 0, 1, TimeUnit.SECONDS);
    }
}
