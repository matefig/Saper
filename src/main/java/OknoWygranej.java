import javax.swing.*;
import java.awt.*;

public class OknoWygranej {

    JLabel imageLabel;
    Container con;
    JFrame window;

    public OknoWygranej(){
        //GUI OKNA PRZEGRANEJ
        GUI oknoWygranej= new GUI(300,189);
        oknoWygranej.window.setTitle("WYGRANA");
        this.window = oknoWygranej.window;  // Ustawienie pola window

        con = new Container();
        con = this.window.getContentPane();
        // Dodaj etykietę do wyświetlenia obrazu
        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 300, 150);
        con.add(imageLabel);

        ImageIcon imageIcon = new ImageIcon("src/main/resources/Wygrana.png");
        imageLabel.setIcon(imageIcon);

        // Zamknij okno po pewnym czasie (na przykład po 3 sekundach)
        Timer timer = new Timer(3000, e -> zamknijOkno());
        timer.setRepeats(false); // Wyłącz powtarzanie
        timer.start();
    }

    void zamknijOkno() {
        JFrame okno = (JFrame) SwingUtilities.getWindowAncestor(con);
        okno.dispose();
    }

    // Dodany getter dla pola window
    public JFrame getWindow() {
        return window;
    }

}
