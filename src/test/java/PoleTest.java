import javax.swing.JButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PoleTest {

    private Pole pole;

    @BeforeEach
    void setUp() {
        // Inicjalizacja obiektu Pole przed każdym testem
        pole = new Pole();
    }

    @Test
    void testDomyslnychWartosci() {
        // Sprawdzanie, czy domyślne wartości są ustawione poprawnie
        assertEquals(0, pole.bombyobok);
        assertFalse(pole.wcisniety);
        assertFalse(pole.bomba);
        assertFalse(pole.flaga);
        assertNull(pole.button);
    }

    @Test
    void testSetWcisniety() {
        // Sprawdzanie, czy można prawidłowo ustawić wartość pola wcisniety
        pole.wcisniety = true;
        assertTrue(pole.wcisniety);
    }

    @Test
    void testSetBomba() {
        // Sprawdzanie, czy można prawidłowo ustawić wartość pola bomba
        pole.bomba = true;
        assertTrue(pole.bomba);
    }

    @Test
    void testSetFlaga() {
        // Sprawdzanie, czy można prawidłowo ustawić wartość pola flaga
        pole.flaga = true;
        assertTrue(pole.flaga);
    }

    @Test
    void testButtonNotNull() {
        // Sprawdzanie, czy pole button nie jest nullem po ustawieniu go
        pole.button = new JButton();
        assertNotNull(pole.button);
    }
}
