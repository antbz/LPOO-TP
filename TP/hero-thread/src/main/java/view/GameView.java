package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.GameModel;

import java.io.IOException;

public class GameView {
    public enum ACTION {LEFT, RIGHT};

    private final TerminalScreen screen;

    private final GameModel model;

    private final HeroView heroView;
    private final RainView rainView;

    public GameView(GameModel model) throws IOException {
        Terminal terminal =
                new DefaultTerminalFactory().setInitialTerminalSize(
                        new TerminalSize(model.getWidth(), model.getHeight())
                ).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        this.model = model;

        this.heroView = new HeroView();
        this.rainView = new RainView();
    }

    public void draw() throws IOException {
        screen.clear();

        heroView.draw(screen, model.getHeroModel());
        rainView.draw(screen, model.getRainModel());

        screen.refresh();
    }

    public ACTION getAction() throws IOException {
        KeyStroke key = screen.readInput();

        while (true) {
            if (key.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
            if (key.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        }
    }
}
