import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class PrzyciskReset {

    static ImageIcon IconReset;
    static ImageIcon IconResetPressed;
    static ImageIcon IconResetLose;
    static ImageIcon IconResetWygrana;
    int x;
    int y;
    int width;
    int height;
    static JButton reset;



    PrzyciskReset(int x, int y, int width, int height, Container con, MouseAdapter buttonMouseListener) {
        IconReset = new ImageIcon("src/main/resources/reset.png");
        IconResetPressed = new ImageIcon("src/main/resources/resetpressed.png");
        IconResetLose = new ImageIcon("src/main/resources/resetlose.png");
        IconResetWygrana = new ImageIcon("src/main/resources/resetwin.gif");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        reset = new JButton();
        reset.setIcon(IconReset);
        reset.setBounds(x,y,width,height);
        reset.addMouseListener(buttonMouseListener);
        con.add(reset);

        con.revalidate();
        con.repaint();
    }

    static void przyciskGdyTrzymamy() {
        reset.setIcon(IconResetPressed);
    }
    static void przyciskGdyPuszczamy() {
        reset.setIcon(IconReset);
    }
    static void przyciskPrzegrana(){
        reset.setIcon(IconResetLose);
    }
    static void przyciskWygrana(){
        reset.setIcon(IconResetWygrana);
    }
}
