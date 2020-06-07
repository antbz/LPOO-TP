package view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import model.RainDrop;
import model.RainModel;

import java.util.List;

public class RainView {
    public void draw(TerminalScreen screen, RainModel rainModel) {
        List<RainDrop> drops = rainModel.getDrops();

        for (RainDrop drop : drops) {
            screen.setCharacter(drop.getPosition().getX(), drop.getPosition().getY(), new TextCharacter('*'));
        }

    }
}
