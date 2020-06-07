import java.util.ArrayList;
import java.util.List;

public class Concert {
    private String city, country, date;
    private List<Act> acts;
    private int ticketID;

    public Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.acts = new ArrayList<>();
        this.ticketID = 1;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    public boolean isValid(Ticket ticket) {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist) {
        for (Act act : acts) {
            if (act.equals(artist)) return true;
            if (act instanceof Band && ((Band) act).containsArtist(artist)) return true;
        }
        return false;
    }

    public Ticket getTicket() throws InvalidTicket {
        return new Ticket(ticketID++, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Concert c = (Concert) obj;
        return city.equals(c.city) && country.equals(c.country) && date.equals(c.date);
    }

    @Override
    public int hashCode() {
        return city.length() * 13 + country.length();
    }
}
