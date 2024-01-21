import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

// Klasa potomna dla MouseAdapter do użycia w testach
class TestowyAdapterMyszy extends MouseAdapter {
}

class PrzyciskResetTest {

    private PrzyciskReset przyciskReset;

    @BeforeEach
    void setUp() {
        // Utworzenie nowego obiektu PrzyciskReset przed każdym testem
        przyciskReset = new PrzyciskReset(10, 20, 30, 40, new Container(), new TestowyAdapterMyszy());
    }

    @Test
    void testKonstruktora() {
        // Sprawdzenie, czy konstruktor poprawnie ustawia pola obiektu PrzyciskReset
        assertEquals(10, przyciskReset.x);
        assertEquals(20, przyciskReset.y);
        assertEquals(30, przyciskReset.width);
        assertEquals(40, przyciskReset.height);
        assertNotNull(PrzyciskReset.IconReset);
        assertNotNull(PrzyciskReset.IconResetPressed);
        assertNotNull(PrzyciskReset.IconResetLose);
        assertNotNull(PrzyciskReset.IconResetWygrana);
        assertNotNull(PrzyciskReset.reset);
    }

    @Test
    void testPrzyciskGdyTrzymamy() {
        // Sprawdzenie, czy metoda przyciskGdyTrzymamy zmienia ikonę na IconResetPressed
        PrzyciskReset.przyciskGdyTrzymamy();
        assertEquals(PrzyciskReset.IconResetPressed, PrzyciskReset.reset.getIcon());
    }

    @Test
    void testPrzyciskGdyPuszczamy() {
        // Sprawdzenie, czy metoda przyciskGdyPuszczamy zmienia ikonę na IconReset
        PrzyciskReset.przyciskGdyPuszczamy();
        assertEquals(PrzyciskReset.IconReset, PrzyciskReset.reset.getIcon());
    }

    @Test
    void testPrzyciskPrzegrana() {
        // Sprawdzenie, czy metoda przyciskPrzegrana zmienia ikonę na IconResetLose
        PrzyciskReset.przyciskPrzegrana();
        assertEquals(PrzyciskReset.IconResetLose, PrzyciskReset.reset.getIcon());
    }

    @Test
    void testPrzyciskWygrana() {
        // Sprawdzenie, czy metoda przyciskWygrana zmienia ikonę na IconResetWygrana
        PrzyciskReset.przyciskWygrana();
        assertEquals(PrzyciskReset.IconResetWygrana, PrzyciskReset.reset.getIcon());
    }
}
