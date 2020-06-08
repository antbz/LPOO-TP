public class Rectangulo implements Figura {
    private int x1, y1, x2, y2;

    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double getArea() {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    @Override
    public double getPerimetro() {
        return 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }
}
