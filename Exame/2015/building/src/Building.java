import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Building implements Facility {
    private String name;
    private int minFloor, maxFloor;
    private Set<Room> rooms = new HashSet<>();

    public Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
        if (maxFloor < minFloor) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public String getName() {
        return name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCapacity() {
        int cap = 0;
        for (Room room : rooms) {
            cap += room.getCapacity();
        }
        return cap;
    }

    public boolean addRoom(Room room) {
        return rooms.add(room);
    }

    @Override
    public boolean canEnter(User user) {
        for (Room room : rooms) {
            if (room.canEnter(user)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Building(" +
                name + ')';
    }
}
