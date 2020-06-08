public abstract class Transaction {
    protected ATM atm;
    private Session session;
    private Card card;
    private int pin;
    protected double amount = 0;

    public Transaction(ATM atm, Session session, Card card, int pin) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public abstract String toString();
}
