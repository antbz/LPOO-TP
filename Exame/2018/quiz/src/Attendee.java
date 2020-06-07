public class Attendee extends Person{
    boolean hasPaid = false;

    public Attendee(String name) {
        super(name);
    }

    public Attendee(String name, int age) {
        super(name, age);
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    @Override
    public String toString() {
        return "Attendee " + name + (hasPaid ? " has" : " hasn't") + " paid its registration.";
    }
}
