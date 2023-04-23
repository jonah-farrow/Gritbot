import java.util.HashMap;
import java.math.*;

public class Event {
    // Stores list of events that could occur when Colonist moves location
    // Picks event from list
    HashMap<Integer, String> events = new HashMap<Integer, String>();
    static String currentEvent = "";

    // Initialises events set with each event that could occur in the game
    // public void setEvents() {
    // events.put(0, "Tropical Storm");
    // events.put(1, "Extreme Heat");
    // events.put(2, "Extreme Cold");
    // events.put(3, "Meteor Shower");
    // }

    public static void generateEvent() {
        double generateRandomEvent = Math.random() * 4;

        switch ((int) generateRandomEvent) {
            case 0:
                eventTropicalStorm();
                break;
            case 1:
                eventExtremeHeat();
                break;
            case 2:
                eventExtremeCold();
                break;
            case 3:
                eventMeteorShower();
                break;
            case 4:
                System.out.println("The sky is clear today (no event this move)");
                break;
            default:
                System.out.println("ERR: No event found");
                break;

        }
    }

    public void addCustomEvent(String eventName, boolean isBuff, String toTrait) {
        events.put(4, eventName);

    }

    // high temperature and humidity, low light
    public static void eventTropicalStorm() {
        Environment.setEventEnvironmentLevels(-500, 500, 500);
        currentEvent = "Tropical Storm";
    }

    // high temperature and humidity, high light
    public static void eventExtremeHeat() {
        Environment.setEventEnvironmentLevels(500, 500, 500);
        currentEvent = "Extreme Heat";
    }

    // low temperature and humidity, low light
    public static void eventExtremeCold() {
        Environment.setEventEnvironmentLevels(-500, -500, -500);
        currentEvent = "Extreme Cold";

    }

    // high temperature and light, low humidity
    public static void eventMeteorShower() {
        Environment.setEventEnvironmentLevels(500, 500, -500);
        currentEvent = "Meteor Shower";
    }

    public void eventCustom() {

    }

    /**
     * Getter methods
     */

    public static String getEvent() {
        if (currentEvent != "") {
            return currentEvent;
        } else {
            generateEvent();
            getEvent();
            return currentEvent;
        }
    }
}
