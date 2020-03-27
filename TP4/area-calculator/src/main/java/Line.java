public class Line implements Shape {
    double length;

    public Line(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
