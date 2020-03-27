import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


import static com.googlecode.lanterna.input.KeyType.*;

public class Game {
    private Screen screen;

    private Arena arena = new Arena(70,20);

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }


    private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == Character && key.getCharacter() == 'q') {
            screen.close();
            return;
        }
        arena.processKey(key);
    }

    public void run() {
        try {
            while (true) {
                draw();
                KeyStroke key = screen.readInput();
                if (key.getKeyType() == EOF) {
                    break;
                }
                processKey(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
