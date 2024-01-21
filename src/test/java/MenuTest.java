import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    // Test sprawdzający poprawne zachowanie po kliknięciu przycisku "Easy"
    @Test
    void sprawdzZachowaniePrzyciskow_PrzyciskLatwyKlikniety_PrawidloweDzialanie() {
        // Inicjalizacja obiektu klasy Menu
        Menu menu = new Menu(250, 300);
        // Wywołanie metody obsługującej zdarzenie dla przycisku "Easy"
        menu.buttonMouseListener.mouseReleased(utworzZdarzenieMyszy(menu.buttonMouseListener, "Easy"));
    }

    // Test sprawdzający poprawne zachowanie po kliknięciu przycisku "Medium"
    @Test
    void sprawdzZachowaniePrzyciskow_PrzyciskSredniKlikniety_PrawidloweDzialanie() {
        // Inicjalizacja obiektu klasy Menu
        Menu menu = new Menu(250, 300);
        // Wywołanie metody obsługującej zdarzenie dla przycisku "Medium"
        menu.buttonMouseListener.mouseReleased(utworzZdarzenieMyszy(menu.buttonMouseListener, "Medium"));

    }

    // Test sprawdzający poprawne zachowanie po kliknięciu przycisku "Hard"
    @Test
    void sprawdzZachowaniePrzyciskow_PrzyciskTrudnyKlikniety_PrawidloweDzialanie() {
        // Inicjalizacja obiektu klasy Menu
        Menu menu = new Menu(250, 300);
        // Wywołanie metody obsługującej zdarzenie dla przycisku "Hard"
        menu.buttonMouseListener.mouseReleased(utworzZdarzenieMyszy(menu.buttonMouseListener, "Hard"));

    }





    // Metoda pomocnicza do tworzenia zdarzenia myszy dla przycisku o określonym tekście
    private MouseEvent utworzZdarzenieMyszy(MouseAdapter listener, String buttonText) {
        // Tworzenie przycisku z podanym tekstem
        JButton button = new JButton(buttonText);
        // Tworzenie zdarzenia myszy (MouseEvent) dla przycisku
        MouseEvent mouseEvent = new MouseEvent(
                button, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(),
                0, 0, 0, 1, false
        );
        // Wywołanie metody obsługującej zdarzenie dla przycisku
        listener.mouseReleased(mouseEvent);
        // Zwrócenie zdarzenia myszy
        return mouseEvent;
    }
}
