import java.util.Locale;

public class Withdrawal extends Transaction {
    public Withdrawal(ATM atm, Session session, Card card, int pin) {
        super(atm, session, card, pin);
    }

    @Override
    public String toString() {
        return "Withdrawal at ATM " + atm + " of " + String.format(Locale.US, "%.2f", amount);
    }
}
