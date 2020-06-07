package model;

public class RainDrop {
    private Position position;
    private int speed;

    public RainDrop(Position position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSpeed() {
        return speed;
    }
}
