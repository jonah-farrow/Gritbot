import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task {
    /**
     * List of tasks generated (order does not imply priority to complete)
     * Firefight, Patient, Doctor, Bed rest, Basic, Warden, Handle, Cook, Hunt,
     * Construct, Grow, Mine, Plant cut, Smith, Tailor, Art, Craft, Haul, Clean,
     * Research
     */

    public static void generateTaskList() { // Runs once at the start of the game to generate task list
        List<Integer> tasks = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            tasks.add(i);
        }
    }

    public static int generateTask() {
        double generateRandomTask = Math.random() * 19;
        return (int) generateRandomTask;
    }
}
