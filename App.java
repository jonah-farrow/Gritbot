public class App {

    public static void main(String[] args) throws Exception {
        Game.runGame();
        SensorInterface.test();
        Thread.sleep(10000);
        /**
         * The aim is to have the program running in the background of ones daily life
         * we need Gritbot to loop over a long period of time, say 24 hours.
         * To achieve this, Gritbot needs to safely execute its functions without drift.
         * The Java Library ScheduledExecutorService may help to achieve this, see
         * below.
         */

    }
}
