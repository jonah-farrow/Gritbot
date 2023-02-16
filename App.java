public class App {
    public static void main(String[] args) throws Exception {
        World.generateStartingWorldMap();
        System.out.println(World.generateStartingWorldView());
        Task.generateTaskList();
        System.out.println("Task: " + Task.generateTask());
        System.out.println("Possible directions: " + World.getPossibleDirections());
        Colonist me = new Colonist();
        System.out.println(me.getColonistStats());
    }
}
