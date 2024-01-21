import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// @param TEST KOMENTARZA

public class Menu {

    MouseAdapter buttonMouseListener;
    Container con;
    public Menu(int width, int height)
    {
        GUI guimenu = new GUI(250,300);
        guimenu.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        con = new Container();
        con = guimenu.window.getContentPane();

        czytajPrzyciski();

        JButton easy = new JButton("Easy");
        easy.setBounds(70, 40, 100, 36);
        easy.setBorderPainted(false);
        easy.addMouseListener(buttonMouseListener);
        con.add(easy);

        JButton medium = new JButton("Medium");
        medium.setBounds(70, 110, 100, 36);
        medium.setBorderPainted(false);
        medium.addMouseListener(buttonMouseListener);
        con.add(medium);

        JButton hard = new JButton("Hard");
        hard.setBounds(70, 180, 100, 36);
        hard.setBorderPainted(false);
        hard.addMouseListener(buttonMouseListener);
        con.add(hard);

        con.revalidate();
        con.repaint();


    }

    void czytajPrzyciski() {
        buttonMouseListener = new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {

                JButton clickedButton = (JButton) e.getSource();
                String poziomtrudnosci = clickedButton.getText();

                switch (poziomtrudnosci) {
                    case "Easy" -> {
                        GUI gui = new GUI(432, 487);
                        Saper saper = new Saper(432, 432, 40, gui.window);
                        PrzyciskReset reset = new PrzyciskReset((432 / 2) - 24, 8, 32, 32, saper.con, saper.buttonMouseListener);
                    }
                    case "Medium" -> {
                        GUI gui = new GUI(432, 487);
                        Saper saper = new Saper(432, 432, 65, gui.window);
                        PrzyciskReset reset = new PrzyciskReset((432 / 2) - 24, 8, 32, 32, saper.con, saper.buttonMouseListener);
                    }
                    case "Hard" -> {
                        GUI gui = new GUI(432, 487);
                        Saper saper = new Saper(432, 432, 90, gui.window);
                        PrzyciskReset reset = new PrzyciskReset((432 / 2) - 24, 8, 32, 32, saper.con, saper.buttonMouseListener);
                    }
                }

            }
        };
    }





}
