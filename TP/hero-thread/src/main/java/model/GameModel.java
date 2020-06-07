package model;

public class GameModel {
    private int width;
    private int height;

    private HeroModel heroModel;
    private RainModel rainModel;

    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;

        this.heroModel = new HeroModel(new Position(width / 2, height - 1));
        this.rainModel = new RainModel();
    }

    public HeroModel getHeroModel() {
        return heroModel;
    }
    public RainModel getRainModel() {
        return rainModel;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
