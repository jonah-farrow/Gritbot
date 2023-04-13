import java.util.HashMap;
import java.math.*;

public class Event {
    // Stores list of events that could occur when Colonist moves location
    // Picks event from list
    HashMap<Integer, String> events = new HashMap<Integer, String>();

    // Initialises events set with each event that could occur in the game
    public void setEvents() {
        events.put(0, "Tropical Storm");
        events.put(1, "Extreme Heat");
        events.put(2, "Extreme Cold");
        events.put(3, "Meteor Shower");
    }

    public void generateEvent() {
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
                eventCustom();
                break;
            case 5:
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

    public void eventTropicalStorm() {

    }

    public void eventExtremeHeat() {

    }

    public void eventExtremeCold() {

    }

    public void eventMeteorShower() {

    }

    public void eventCustom() {

    }
}
