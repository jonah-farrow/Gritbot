import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Task {
    /**
     * List of tasks generated (order does not imply priority to complete)
     * Firefight, Patient, Doctor, Bed rest, Basic, Warden, Handle, Cook, Hunt,
     * Construct, Grow, Mine, Plant cut, Smith, Tailor, Art, Craft, Haul, Clean,
     * Research
     */

    /*
     * Priority of task to complete needs to be designed.
     * One way might be through designing a simple schedule with orders:
     * work/sleep/anything/recreation that increase the weighting of certain ta
     */

    public static ArrayList<String> generateTaskList() { // Runs once at the start of the game to generate task list
        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add("Firefight");
        tasks.add("Patient");
        tasks.add("Doctor");
        tasks.add("Bed rest");
        tasks.add("Basic");
        tasks.add("Warden");
        tasks.add("Handle");
        tasks.add("Cook");
        tasks.add("Hunt");
        tasks.add("Construct");
        tasks.add("Grow");
        tasks.add("Mine");
        tasks.add("Planting");
        tasks.add("Smithing");
        tasks.add("Tailor");
        tasks.add("Art");
        tasks.add("Craft");
        tasks.add("Haul");
        tasks.add("Clean");
        tasks.add("Research");
        return tasks;
    }

    /**
     * The lower the trait the higher the weighting it has to occur
     */
    public void decideWhatTaskToComplete() {
        HashMap<Integer, Integer> traitToPrioritise = new HashMap<Integer, Integer>(); // trait then value
        int[] arr = Colonist.getColonistTraits();
        int min = arr[0];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        System.out.println(arr);
        // int min = Arrays.stream(arr)
        // .min()
        // .getAsInt();

        // System.out.println(min);

    }
}
