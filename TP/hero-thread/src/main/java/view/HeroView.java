package view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import model.HeroModel;

public class HeroView {
    public void draw(TerminalScreen screen, HeroModel hero) {
        screen.setCharacter(hero.getPosition().getX(), hero.getPosition().getY(), new TextCharacter('H'));
    }
}
