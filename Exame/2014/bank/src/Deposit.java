import java.util.Locale;

public class Deposit extends Transaction {
    public Deposit(ATM atm, Session session, Card card, int pin) {
        super(atm, session, card, pin);
    }

    @Override
    public String toString() {
        return "Deposit at ATM " + atm + " of " + String.format(Locale.US, "%.2f", amount);
    }
}
