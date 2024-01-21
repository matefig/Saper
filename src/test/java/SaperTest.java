import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

class SaperTest {

    private Saper saper;

    @BeforeEach
    void setUp() {
        // Inicjalizacja obiektu Saper przed każdym testem
        saper = new Saper(400, 300, 10, new JFrame());

        // Inicjalizacja przycisku reset
        PrzyciskReset.reset = new JButton();
    }

    @Test
    void czytajPrzyciski() {
        // Sprawdzenie, czy obiekt buttonMouseListener nie jest null
        assertNotNull(saper.buttonMouseListener);
    }

    @Test
    void odkryjPole() {
        // Sprawdzenie, czy pole[0][0] jest początkowo nie wciśnięte
        assertFalse(saper.pole[0][0].wcisniety);

        // Odkrycie pola o współrzędnych (0, 0)
        saper.odkryjPole(0, 0);

        // Sprawdzenie, czy pole[0][0] zostało poprawnie wciśnięte
        assertTrue(saper.pole[0][0].wcisniety);
    }

    @Test
    void flagowanie() {
        // Sprawdzenie, czy pole[1][1] nie ma początkowo flagi
        assertFalse(saper.pole[1][1].flaga);

        // Umieszczenie flagi na polu (1, 1)
        saper.flagowanie(1, 1);

        // Sprawdzenie, czy pole[1][1] ma teraz flagę
        assertTrue(saper.pole[1][1].flaga);
    }

    @Test
    void rozlozPola() {
        // Wywołanie metody rozłożenia pól
        saper.rozlozPola();
    }

    @Test
    void generujBomby() {
        // Wywołanie metody generującej bomby
        saper.generujBomby();
    }

    @Test
    void sprawdzIleObok() {
        // Wywołanie metody sprawdzającej ilość bomb obok pól
        saper.sprawdzIleObok();
    }

    @Test
    void resetGame() {
        // Odkrycie pola (0, 0)
        saper.odkryjPole(0, 0);

        // Zresetowanie gry
        saper.resetGame();

        // Sprawdzenie, czy pole (0, 0) nie jest wciśnięte po zresetowaniu gry
        assertFalse(saper.pole[0][0].wcisniety);
    }

    @Test
    void przegrana() {
        // Wywołanie metody oznaczającej przegraną
        saper.przegrana();

        // Sprawdzenie, czy zmienna freeze nie ma wartości 1 po przegranej
        assertFalse(saper.freeze == 1);
    }

    @Test
    void czyWygrana() {
        // Wywołanie metody sprawdzającej, czy gra została wygrana
        saper.czyWygrana();

        // Sprawdzenie, czy zmienna freeze nie ma wartości 1 po sprawdzeniu wygranej
        assertFalse(saper.freeze == 1);
    }

    @Test
    void odkrywanieFlaga() {
        // Umieszczenie flagi na polu (0, 0)
        saper.flagowanie(0, 0);

        // Odkrycie pola (0, 0), na którym jest flaga
        saper.odkrywanieFlaga(0, 0);

        // Sprawdzenie, czy pole (0, 0) nie jest wciśnięte po odkryciu z flagą
        assertFalse(saper.pole[0][0].wcisniety);
    }
}
