package view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import model.HeroModel;
import model.Position;
import org.junit.Test;
import org.mockito.Mockito;

public class TestHeroView {
    @Test
    public void testDraw() {
        // A Hero Stub
        HeroModel heroModel = Mockito.mock(HeroModel.class);
        Mockito.when(heroModel.getPosition()).thenReturn(new Position(10, 20));

        // A TerminalScreen Mock
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);

        // Execute
        HeroView view = new HeroView();
        view.draw(screen, heroModel);

        // Verify
        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(10, 20, new TextCharacter('H'));
    }
}
