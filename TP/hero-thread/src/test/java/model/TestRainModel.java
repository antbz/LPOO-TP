package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRainModel {
    @Test
    public void testRainDrop() {
        RainDrop drop = new RainDrop(new Position(5, 10), 15);

        assertEquals(5, drop.getPosition().getX());
        assertEquals(10, drop.getPosition().getY());
        assertEquals(15, drop.getSpeed());
    }

    @Test
    public void testSetPosition() {
        RainDrop drop = new RainDrop(new Position(5, 10), 15);

        drop.setPosition(new Position(20, 25));

        assertEquals(20, drop.getPosition().getX());
        assertEquals(25, drop.getPosition().getY());
    }

    @Test
    public void testAddDrop() {
        RainModel rain = new RainModel();

        rain.addDrop(10, 3);

        assertEquals(1, rain.getDrops().size());

        assertEquals(10, rain.getDrops().get(0).getPosition().getX());
        assertEquals(0, rain.getDrops().get(0).getPosition().getY());
    }
}
