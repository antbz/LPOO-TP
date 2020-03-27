public class House implements HasArea {
    double floor_area;

    public House(double floor_area) {
        this.floor_area = floor_area;
    }

    public double getFloor_area() {
        return floor_area;
    }

    public void setFloor_area(double floor_area) {
        this.floor_area = floor_area;
    }

    @Override
    public double getArea() { return floor_area; }
}
