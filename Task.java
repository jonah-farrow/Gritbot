import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static String decideWhatTaskToComplete() {
        HashMap<Integer, Integer> traitToPrioritise = new HashMap<Integer, Integer>(); // trait then value
        int[] arr = Colonist.getColonistTraits();
        int min = arr[0];
        int whichTraitIsLeast = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i]; // value colonist is most desperate to fufill
                whichTraitIsLeast = i; // is either 0, 1 , or 2. each represents hunger, tiredness, or happiness
            }
        }
        System.out.println(
                "Min Value: " + min + "\nBelongs to trait: " + arr[whichTraitIsLeast] + " (" + whichTraitIsLeast + ")");
        traitTaskCorrespondence(whichTraitIsLeast);
    }

    public static String traitTaskCorrespondence(int prioritisedTrait) { // -1 reserved for special tasks, 0 hungry, 1
        // tiredness,
        // 2 happiness
        HashMap<Integer, String> traitTaskList = new HashMap<Integer, String>(); // List containing all types of task. A
                                                                                 // task type can be: hungry,
                                                                                 // tiredness, happiness,
                                                                                 // or none
        traitTaskList.put(-1, "Firefight");
        traitTaskList.put(-1, "Patient");
        traitTaskList.put(-1, "Doctor");
        traitTaskList.put(1, "Bed rest");
        traitTaskList.put(1, "Basic");
        traitTaskList.put(-1, "Warden");
        traitTaskList.put(2, "Handle");
        traitTaskList.put(0, "Cook");
        traitTaskList.put(0, "Hunt");
        traitTaskList.put(2, "Construct");
        traitTaskList.put(2, "Grow");
        traitTaskList.put(2, "Mine");
        traitTaskList.put(2, "Planting");
        traitTaskList.put(2, "Smithing");
        traitTaskList.put(2, "Tailor");
        traitTaskList.put(2, "Art");
        traitTaskList.put(2, "Craft");
        traitTaskList.put(-1, "Haul");
        traitTaskList.put(2, "Clean");
        traitTaskList.put(-1, "Research");

        ArrayList<String> t = new ArrayList<String>();
        // now take the input and choose a task to prioritise
        for (Map.Entry<Integer, String> x : traitTaskList.entrySet()) {
            if (x.getKey() == prioritisedTrait) {
                t.add(x.getValue());
            }
        }

        // shoot off task to complete by randomly choosing from t
        double r = Math.random() * (19 - 0 + 1) + 0;
        return t.get((int) r);
    }
}
