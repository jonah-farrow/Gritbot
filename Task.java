import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
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
    static String currentTask = "No Task";
    static Boolean needNewTask = false;
    static ArrayList<String> tasks = new ArrayList<String>();

    public static ArrayList<String> generateTaskList() { // Runs once at the start of the game to generate task list
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
        if (getCurrentTask() == "No Task") {
            int[] arr = Colonist.getColonistTraits();
            int min = arr[0];
            int whichTraitIsLeast = 0;

            for (int i = 0; i < arr.length; i++) {
                if (min >= arr[i]) {
                    min = arr[i]; // value colonist is most desperate to fufill
                    whichTraitIsLeast = i; // is either 0, 1 , or 2. each represents hunger, tiredness, or happiness
                }
            }
            System.out.println(
                    "Min Value: " + min + "\nBelongs to trait: " + "(" + whichTraitIsLeast + ")");

            return currentTask = traitTaskCorrespondence(whichTraitIsLeast);
        } else {
            return getCurrentTask();
        }
    }

    public static String traitTaskCorrespondence(int prioritisedTrait) { // -1 reserved for special tasks, 0 hungry, 1
        // tiredness,
        // 2 happiness
        HashMap<String, Integer> traitTaskList = new HashMap<String, Integer>(); // List containing all types of task. A
                                                                                 // task type can be: hungry,
                                                                                 // tiredness, happiness,
                                                                                 // or none
        traitTaskList.put("Firefight", -1);
        traitTaskList.put("Patient", -1);
        traitTaskList.put("Doctor", -1);
        traitTaskList.put("Bed rest", 1);
        traitTaskList.put("Basic", 1);
        traitTaskList.put("Warden", -1);
        traitTaskList.put("Handle", 2);
        traitTaskList.put("Cook", 0);
        traitTaskList.put("Hunt", 0);
        traitTaskList.put("Construct", 2);
        traitTaskList.put("Grow", 2);
        traitTaskList.put("Mine", 2);
        traitTaskList.put("Planting", 2);
        traitTaskList.put("Smithing", 2);
        traitTaskList.put("Tailor", 2);
        traitTaskList.put("Art", 2);
        traitTaskList.put("Craft", 2);
        traitTaskList.put("Haul", -1);
        traitTaskList.put("Clean", 2);
        traitTaskList.put("Research", -1);

        ArrayList<String> t = new ArrayList<String>();
        // now take the input and choose a task to prioritise
        for (Map.Entry<String, Integer> x : traitTaskList.entrySet()) { // entry set returns one unique value for each
                                                                        // key value
            if (x.getValue() == prioritisedTrait) {
                t.add(x.getKey());
            }
        }
        System.out.println(t);
        // shoot off task to complete by randomly choosing from t
        double r = Math.random() * (t.size() - 0);
        return t.get(((int) r));
    }

    public static String getCurrentTask() {
        if (currentTask == "No Task") {
            return "No Task";
        } else {
            return currentTask;
        }
    }

    public static String getTask(int taskToGet) {
        return tasks.get(taskToGet);
    }

    public static void setTask(String task) {
        currentTask = task;
    }

    public static Boolean taskSwitchTable() {
        switch (currentTask) {
            case "Firefight":
                return firefight();

            case "Patient":
                return patient();

            case "Doctor":
                return doctor();

            case "Bed rest":
                return bedRest();

            case "Basic":
                return basic();

            case "Warden":
                return warden();

            case "Handle":
                return handle();

            case "Cook":
                return cook();

            case "Hunt":
                return hunt();

            case "Construct":
                return construct();

            case "Grow":
                return grow();

            case "Mine":
                return mine();

            case "Planting":
                return plantCut();

            case "Smithing":
                return smith();

            case "Tailor":
                return tailor();

            case "Art":
                return art();

            case "Craft":
                return craft();

            case "Haul":
                return haul();

            case "Clean":
                return clean();

            case "Research":
                return research();

            default:
                return false;
        }
    }

    public static Boolean firefight() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                return true;
            default:
                return false;
        }
    }

    public static Boolean patient() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean doctor() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean bedRest() {
        Colonist.modifyHowHappy(true);
        Colonist.modifyHowHungry(false);
        Colonist.modifyHowTired(true);
        return true;
    }

    public static Boolean basic() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean warden() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean handle() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean cook() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHungry(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean hunt() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(true);
                Colonist.modifyHowHungry(false);
                return true;
            default:
                return false;
        }
    }

    public static Boolean construct() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHungry(false);
                return true;
            default:
                return false;
        }
    }

    public static Boolean grow() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHungry(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean mine() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                return true;
            default:
                return false;
        }
    }

    public static Boolean plantCut() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean smith() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean tailor() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean art() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean craft() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean haul() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowTired(false);
                return true;
            default:
                return false;
        }
    }

    public static Boolean clean() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }

    public static Boolean research() {
        double chance = Math.random() * (4 - 1);
        switch ((int) chance) {
            case 1:
                Colonist.modifyHowHappy(true);
                return true;
            default:
                return false;
        }
    }
}
