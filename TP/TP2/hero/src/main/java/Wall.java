import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics graphics) {
        TextColor color = graphics.getBackgroundColor();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), " ");
        graphics.setBackgroundColor(color);
    }
}
