import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

class OknoPrzegranejTest {
    private OknoPrzegranej oknoPrzegranej;

    @BeforeEach
    void setUp() {
        oknoPrzegranej = new OknoPrzegranej();
    }

    @Test
    void zamknijOkno() {
        // Testuje, czy wywołanie metody zamknijOkno() nie powoduje żadnych wyjątków.
        assertDoesNotThrow(() -> oknoPrzegranej.zamknijOkno(), "Nie powoduje wyjątków");
    }

    @Test
    void testTytuluOkna() {
        // Sprawdza, czy tytuł okna jest ustawiony na "PRZEGRANA"
        assertEquals("PRZEGRANA", oknoPrzegranej.getWindow().getTitle());
    }

    @Test
    void testWielkosciOkna() {
        // Sprawdza, czy szerokość i wysokość okna są poprawne
        assertEquals(300, oknoPrzegranej.getWindow().getWidth());
        assertEquals(189, oknoPrzegranej.getWindow().getHeight());
    }

    @Test
    void testKoloruTla() {
        // Sprawdza, czy kolor tła głównego panelu okna jest ustawiony na LIGHT_GRAY
        assertEquals(Color.LIGHT_GRAY, oknoPrzegranej.getWindow().getContentPane().getBackground());
    }

    @Test
    void testIkony() {
        // Sprawdza, czy ikona obrazu została ustawiona
        assertNotNull(oknoPrzegranej.imageLabel.getIcon());
    }
}
