package controller;

import model.GameModel;
import model.HeroModel;
import view.GameView;

import java.io.IOException;

public class HeroController {
    private GameModel model;
    private GameView view;

    public HeroController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void executeAction(GameView.ACTION action) {
        HeroModel hero = model.getHeroModel();

        if (action == GameView.ACTION.LEFT)
            hero.setPosition(hero.getPosition().left());
        if (action == GameView.ACTION.RIGHT)
            hero.setPosition(hero.getPosition().right());
    }

    public void start() throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        GameView.ACTION action = view.getAction();
                        executeAction(action);
                        view.draw();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
