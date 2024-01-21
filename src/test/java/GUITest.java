import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class GUITest {
    private GUI gui;

    @BeforeEach
    void setUp() {
        // Utwórz instancję GUI przed każdym testem
        gui = new GUI(800, 600);
    }

    @Test
    void testWielkosciOkna() {
        // Sprawdź, czy szerokość i wysokość okna są poprawne
        assertEquals(800, gui.window.getWidth());
        assertEquals(600, gui.window.getHeight());
    }

    @Test
    void testKoloruTla() {
        // Sprawdź, czy kolor tła głównego panelu okna jest ustawiony na LIGHT_GRAY
        assertEquals(Color.LIGHT_GRAY, gui.window.getContentPane().getBackground());
    }

    @Test
    void testKoloruTekstuOkna() {
        // Sprawdź, czy kolor tekstu okna jest ustawiony na gray
        assertEquals(Color.gray, gui.window.getForeground());
    }

    @Test
    void testTytuluOkna() {
        // Sprawdź, czy tytuł okna jest ustawiony na "Saper"
        assertEquals("Saper", gui.window.getTitle());
    }

    @Test
    void testSklowaniaOkna() {
        // Sprawdź, czy okno nie jest skalowalne (czyli resizable jest ustawione na false)
        assertFalse(gui.window.isResizable());
    }

    @Test
    void testUkladuOkna() {
        // Sprawdź, czy układ okna jest domyślnym BorderLayout
        assertEquals(BorderLayout.class, gui.window.getLayout().getClass());
    }

    @Test
    void testWidocznosciOkna() {
        // Sprawdź, czy okno jest widoczne
        assertTrue(gui.window.isVisible());
    }
}
