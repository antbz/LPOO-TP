package model;

import java.util.ArrayList;
import java.util.List;

public class RainModel {
    private List<RainDrop> drops;

    public RainModel() {
        drops = new ArrayList<>();
    }

    public List<RainDrop> getDrops() {
        return drops;
    }

    public void addDrop(int x, int speed) {
        drops.add(new RainDrop(new Position(x, 0), speed));
    }
}
