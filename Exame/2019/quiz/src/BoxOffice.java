import java.util.ArrayList;
import java.util.List;

public class BoxOffice {
    public static List<Ticket> buy(Concert concert, int num) throws InvalidTicket {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            tickets.add(concert.getTicket());
        }
        return tickets;
    }
}
