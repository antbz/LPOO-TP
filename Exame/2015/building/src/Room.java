import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Room implements Facility {
    private Building building;
    private String number;
    private int floor;
    private int capacity;
    private Set<User> users = new HashSet<>();

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        if (floor < building.getMinFloor() || floor > building.getMaxFloor()) {
            throw new IllegalArgumentException();
        }
        this.building = building;
        this.number = number;
        this.floor = floor;
        if (!building.addRoom(this)) {
            throw new DuplicateRoomException();
        }
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        if (floor < building.getMinFloor() || floor > building.getMaxFloor() || capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        if (!building.addRoom(this)) {
            throw new DuplicateRoomException();
        }
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return building.getName() + number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void authorize(User user) {
        users.add(user);
    }

    @Override
    public boolean canEnter(User user) {
        return users.contains(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return floor == room.floor &&
                building.equals(room.building) &&
                number.equals(room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Room(" +
                building.getName() +
                "," + number +
                ')';
    }
}
