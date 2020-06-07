package model;

public class HeroModel {
    private int score;
    private int lifes;

    private Position position;

    public HeroModel(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
