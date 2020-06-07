import java.util.*;

public class Event {
    String title, date, description;
    Set<Person> audience = new HashSet<>();

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(Event event) {
        this.title = event.title;
        this.date = event.date;
        this.description = event.description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAudienceCount() {
        return audience.size();
    }

    public void addPerson(Person person) {
        audience.add(person);
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event e = (Event) obj;
        return title.equals(e.title) && date.equals(e.date) && description.equals(e.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }
}
