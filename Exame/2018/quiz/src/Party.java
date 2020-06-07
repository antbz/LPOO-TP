import java.util.HashSet;
import java.util.Set;

public class Party extends Event {
    Set<Event> events = new HashSet<>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public Party(Event event) {
        super(event);
    }

    public void addEvent(Event e) {
        if (events.add(e)) {
            super.audience.addAll(e.audience);
        }
    }
}
