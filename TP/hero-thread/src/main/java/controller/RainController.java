package controller;

import model.GameModel;
import model.RainDrop;
import model.RainModel;
import view.GameView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RainController{
    private GameModel model;
    private GameView view;

    private int rainAmount;
    private int maxSpeed;

    public RainController(GameModel model, GameView view, int rainAmount, int maxSpeed) {
        this.model = model;
        this.view = view;

        this.rainAmount = rainAmount;
        this.maxSpeed = maxSpeed;
    }

    private void rain() {
        makeDropsFall();
        removeFallenDrops();
        makeNewRain();
    }

    private void makeNewRain() {
        RainModel rain = model.getRainModel();

        if (rain.getDrops().size() < rainAmount) {
            Random random = new Random();
            rain.addDrop(random.nextInt(model.getWidth()), random.nextInt(maxSpeed) + 1);
        }
    }

    private void makeDropsFall() {
        RainModel rain = model.getRainModel();

        List<RainDrop> drops = rain.getDrops();
        for (RainDrop drop : drops)
            drop.setPosition(drop.getPosition().down(drop.getSpeed()));
    }

    private void removeFallenDrops() {
        RainModel rain = model.getRainModel();

        List<RainDrop> drops = rain.getDrops();
        List<RainDrop> toRemove = new ArrayList<>();

        for (RainDrop drop : drops)
            if (drop.getPosition().getY() == model.getHeight())
                toRemove.add(drop);

        drops.removeAll(toRemove);
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    rain();

                    try {
                        view.draw();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
