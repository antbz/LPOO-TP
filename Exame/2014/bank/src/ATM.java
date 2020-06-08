import java.util.Objects;

public class ATM {
    private int id;
    private String location, bank;

    public ATM(int id, String location, String bank) {
        this.id = id;
        this.location = location;
        this.bank = bank;
    }

    public int getID() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public String toString() {
        return id + " (" + location + ", " + bank + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return id == atm.id &&
                Objects.equals(location, atm.location) &&
                Objects.equals(bank, atm.bank);
    }
}
