import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

class OknoWygranejTest {
    private OknoWygranej oknoWygranej;

    @BeforeEach
    void setUp() {

        oknoWygranej = new OknoWygranej();
    }

    @Test
    void zamknijOkno() {
        // Testuje, czy wywołanie metody zamknijOkno() nie powoduje żadnych wyjątków.
        assertDoesNotThrow(() -> oknoWygranej.zamknijOkno(), "Nie powoduje wyjątków");
    }

    @Test
    void testTytuluOkna() {
        // Sprawdza, czy tytuł okna jest ustawiony na "WYGRANA"
        assertEquals("WYGRANA", oknoWygranej.getWindow().getTitle());
    }

    @Test
    void testKoloruTla() {
        // Sprawdza, czy szerokość i wysokość okna są poprawne
        assertEquals(300, oknoWygranej.getWindow().getWidth());
        assertEquals(189, oknoWygranej.getWindow().getHeight());
    }

    @Test
    void testBackgroundColor() {
        // Sprawdza, czy kolor tła głównego panelu okna jest ustawiony na LIGHT_GRAY
        assertEquals(Color.LIGHT_GRAY, oknoWygranej.getWindow().getContentPane().getBackground());
    }

    @Test
    void testIkony() {
        // Sprawdza, czy ikona obrazu została ustawiona
        assertNotNull(oknoWygranej.imageLabel.getIcon());
    }


}
