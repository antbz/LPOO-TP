import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider {
    List<House> houses = new ArrayList<>();

    public City(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public double sum() {
        double result = 0;

        for (House house : houses) {
            result += house.getArea();
        }

        return result;
    }
}
