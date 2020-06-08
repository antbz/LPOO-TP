import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Session implements Countable {
    ATM atm;
    List<Transaction> transactions = new ArrayList<>();

    public Session(ATM atm) {
        this.atm = atm;
    }

    public ATM getATM() {
        return atm;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public int count() {
        return transactions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(atm, session.atm);
    }
}
