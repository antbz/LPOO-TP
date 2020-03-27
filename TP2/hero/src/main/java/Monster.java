import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) { super(x, y); }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
    }

    public Position move() {
        int x, y;
        Random rand = new Random();

        x = rand.nextInt(3) - 1;
        y = rand.nextInt(3) - 1;

        return new Position(this.getPosition().getX() + x, this.getPosition().getY() + y);
    }
}
