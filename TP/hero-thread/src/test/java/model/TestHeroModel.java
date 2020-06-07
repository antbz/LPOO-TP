package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHeroModel {
    @Test
    public void testConstructor() {
        HeroModel hero = new HeroModel(new Position(5, 10));

        assertEquals(5, hero.getPosition().getX());
        assertEquals(10, hero.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        HeroModel hero = new HeroModel(new Position(5, 10));

        hero.setPosition(new Position(15, 20));

        assertEquals(15, hero.getPosition().getX());
        assertEquals(20, hero.getPosition().getY());
    }

}
