public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        World.generateStartingWorldMap();
        System.out.println(World.generateStartingWorldView());
        Task.generateTaskList();
        System.out.println("Task: " + Task.generateTask());
        System.out.println("Possible directions: " + World.getPossibleDirections());
    }
}
