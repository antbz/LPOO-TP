package controller;

import model.GameModel;
import view.GameView;

import java.io.IOException;

public class GameController {
    private final HeroController heroController;
    private final RainController rainController;

    private final GameView view;
    private final GameModel model;

    public GameController(GameModel model, GameView view) throws IOException {
        this.view = view;
        this.model = model;

        this.heroController = new HeroController(model, view);
        this.rainController = new RainController(model, view,30, 3);
    }

    public void start() throws IOException {
        heroController.start();
        rainController.start();
    }
}
