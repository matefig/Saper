import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame window;


    public GUI(int width, int height) {
        window = new JFrame();
        window.setSize(width, height);
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setForeground(Color.gray);
        window.setLocationRelativeTo(null);
        window.setTitle("Saper");
        window.setResizable(false);
        window.setLayout(null);
        window.setVisible(true);
    }


}
