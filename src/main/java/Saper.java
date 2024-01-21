import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Saper {
    int width;
    int height;
    int miny;
    int freeze = 0;
    MouseAdapter buttonMouseListener;
    Container con;

    ImageIcon bomba;
    ImageIcon close;
    ImageIcon open;
    ImageIcon obok1;
    ImageIcon obok2;
    ImageIcon obok3;
    ImageIcon obok4;
    ImageIcon obok5;
    ImageIcon obok6;
    ImageIcon obok7;
    ImageIcon obok8;
    ImageIcon flaga;
    Pole[][] pole;


    public Saper(int width,int height,int miny,JFrame window){
        this.width=width;
        this.height=height;
        this.miny=miny;
        close = new ImageIcon("src/main/resources/close.png");
        open = new ImageIcon("src/main/resources/open.png");
        bomba = new ImageIcon("src/main/resources/bomba.png");
        obok1 = new ImageIcon("src/main/resources/obok1.png");
        obok2 = new ImageIcon("src/main/resources/obok2.png");
        obok3 = new ImageIcon("src/main/resources/obok3.png");
        obok4 = new ImageIcon("src/main/resources/obok4.png");
        obok5 = new ImageIcon("src/main/resources/obok5.png");
        obok6 = new ImageIcon("src/main/resources/obok6.png");
        obok7 = new ImageIcon("src/main/resources/obok7.png");
        obok8 = new ImageIcon("src/main/resources/obok8.png");
        flaga = new ImageIcon("src/main/resources/flaga.png");



        con = new Container();
        con = window.getContentPane();



        czytajPrzyciski(); //Zaczecie gry
        rozlozPola();
        generujBomby();
        sprawdzIleObok();
    }

    void czytajPrzyciski(){

        buttonMouseListener = new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                if(freeze==0)
                    PrzyciskReset.przyciskGdyTrzymamy();
            }

            public void mouseReleased(MouseEvent e) {

                if (freeze==0)
                    PrzyciskReset.przyciskGdyPuszczamy();

                JButton clickedButton = (JButton) e.getSource();
                int x = clickedButton.getX();
                int y = clickedButton.getY();
                //LEWY PRZYCISK MYSZKI
                if (SwingUtilities.isLeftMouseButton(e))
                {
                    if (x >= (width / 2) - 24 && x < (width / 2) + 8 && y >= 8 && y < 40) {
                        resetGame();
                    }
                    if (x >= 16 && y >= 32 && freeze==0) {
                        odkryjPole((x/16)-1,(y/16)-3);

                        if (pole[x/16-1][y/16-3].bombyobok!=0)
                        {
                            odkrywanieFlaga((x/16)-1,(y/16)-3);
                        }

                        czyWygrana();
                    }
                }
                //PRAWY PRZYCISK MYSZKI
                if (SwingUtilities.isRightMouseButton(e)&&freeze==0)
                {
                    flagowanie((x/16)-1,(y/16)-3);
                }
            }
        };
    }

    void odkryjPole(int x,int y){
        //KONCZENIE REKURENCJI
        if (x < 0 || x >= (width/16)-3 || y < 0 || y >= (height/16)-3|| pole[x][y].wcisniety)
        {
            return;
        }

        //jesli klikniesz bez bomby i bez bomby obok
        if (pole[x][y].bombyobok == 0 && !pole[x][y].bomba && !pole[x][y].flaga) {
            pole[x][y].button.setIcon(open);
            pole[x][y].wcisniety = true;
            //PETLA POTRZEBNA ZEBY ODKRYWALO SIE W KWADRACIKU 3x3
            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    //WYWOŁANIE REKURENCJI ABY ODKRYC PUSTY OBSZAR
                    odkryjPole(x+(i),y+(j));

                }
            }
        }
        //jesli klikniesz w bombe
        if (pole[x][y].bomba  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(bomba);
            przegrana();
            freeze = 1;


        }
        //jesli obok1
        if (pole[x][y].bombyobok == 1  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok1);
        }
        //jesli obok2
        if (pole[x][y].bombyobok == 2  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok2);
        }
        //jesli obok3
        if (pole[x][y].bombyobok == 3  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok3);
        }
        //jesli obok4
        if (pole[x][y].bombyobok == 4  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok4);
        }
        //jesli obok5
        if (pole[x][y].bombyobok == 5  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok5);
        }
        //jesli obok6
        if (pole[x][y].bombyobok == 6  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok6);
        }
        //jesli obok7
        if (pole[x][y].bombyobok == 7  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok7);
        }
        //jesli obok8
        if (pole[x][y].bombyobok == 8  && !pole[x][y].flaga) {
            pole[x][y].wcisniety = true;
            pole[x][y].button.setIcon(obok8);
        }

    }
    void flagowanie(int x, int y) {
        if (!pole[x][y].wcisniety)
        {
            if (pole[x][y].flaga)
            {
                pole[x][y].flaga = false;
                pole[x][y].button.setIcon(close);
            }

            else
            {
                pole[x][y].flaga = true;
                pole[x][y].button.setIcon(flaga);

            }
        }

    }
    void rozlozPola () {
        pole = new Pole[width / 16 - 2][height / 16 - 3];
        for (int y = 0; y < (height / 16) - 3; y++) {
            for (int x = 0; x < (width / 16) - 3; x++) {

                JButton button = new JButton();
                button.setBounds((x + 1) * 16, (y + 3) * 16, 16, 16);
                button.setIcon(close);
                button.setBorderPainted(false);
                button.addMouseListener(buttonMouseListener);
                con.add(button);

                pole[x][y] = new Pole();
                pole[x][y].bombyobok = 0;
                pole[x][y].wcisniety = false;
                pole[x][y].bomba = false;
                pole[x][y].flaga = false;
                pole[x][y].button = button;

            }
        }
        con.revalidate();
        con.repaint();
    }
    void generujBomby(){
        Random randomGenerator = new Random();
        int row,col;
        int mines = miny;
        while (mines > 0) {

            row = randomGenerator.nextInt((width/16)-4+1);
            col = randomGenerator.nextInt((height/16)-4+1);
            if (!pole[row][col].bomba) {
                pole[row][col].bomba = true;
                mines--;
            }
        }
    }
    void sprawdzIleObok() {
        int max_i = (width / 16) - 4;
        int max_j = (height / 16) - 4;

        for (int i = 0; i <= max_i; i++) {
            for (int j = 0; j <= max_j; j++) {
                if (!pole[i][j].bomba)
                {
                    int count = 0;
                    //lewa
                    if (i > 0 && pole[i - 1][j].bomba)
                        count++;
                    //prawa
                    if (i < max_i && pole[i + 1][j].bomba)
                        count++;
                    //lewa gora
                    if (i > 0 && j > 0 && pole[i - 1][j - 1].bomba)
                        count++;
                    //gora
                    if (j > 0 && pole[i][j - 1].bomba)
                        count++;
                    //prawa gora
                    if (i < max_i && j > 0 && pole[i + 1][j - 1].bomba)
                        count++;
                    //lewy dol
                    if (i > 0 && j < max_j && pole[i - 1][j + 1].bomba)
                        count++;
                    //dol
                    if (j < max_j && pole[i][j + 1].bomba)
                        count++;
                    //prawy dol
                    if (i < max_i && j < max_j && pole[i + 1][j + 1].bomba)
                        count++;

                    pole[i][j].bombyobok = count;
                }
            }
        }
    }
    void resetGame() {
        for (int y = 0; y < (height / 16) - 3; y++) {
            for (int x = 0; x < (width / 16) - 3; x++) {

                pole[x][y].bombyobok = 0;
                pole[x][y].wcisniety = false;
                pole[x][y].bomba = false;
                pole[x][y].flaga = false;
                pole[x][y].button.setIcon(close);
            }
        }
        freeze=0;
        generujBomby();
        sprawdzIleObok();
        PrzyciskReset.przyciskGdyPuszczamy();

        con.revalidate();
        con.repaint();
    }
    void przegrana() {
        System.out.println("Przegrałeś!");
        new OknoPrzegranej();

        for (int y = 0;y < (height/16)-3;y++)
        {
            for (int x = 0;x <(width/16)-3;x++)
            {
                if (pole[x][y].bomba) {
                    pole[x][y].button.setIcon(bomba);
                }
            }
        }
        PrzyciskReset.przyciskPrzegrana();
    }
    void czyWygrana() {
        for (int y = 0;y < (height/16)-3;y++)
        {
            for (int x = 0;x <(width/16)-3;x++)
            {
                if (!pole[x][y].wcisniety && !pole[x][y].bomba) {
                    return;
                }
            }
        }
        new OknoWygranej();
        System.out.println("Wygrales!");
        freeze = 1;
        PrzyciskReset.przyciskWygrana();
    }


    void odkrywanieFlaga(int x, int y) {

        int flagi = 0;

        //zliczanie flag obok kliknietego pola
        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                if (x+i>=0  &&  x+i<width/16-3   && y+j>=0  &&  y+j<height/16-3)
                {
                    if (pole[x + i][y + j].flaga)
                    {
                        flagi++;
                    }
                }
            }
        }

        if (pole[x][y].bombyobok == flagi && flagi != 0 && !pole[x][y].flaga && pole[x][y].wcisniety)    //jesli pole klikniete ma tyle samo flag obok co bomb obok i flagi nie wynosza 0 oraz pole to nie jest flaga
        {
            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    if (x+i>=0  &&  x+i<width/16-3   && y+j>=0  &&  y+j<height/16-3)
                    {
                        if (!pole[x+i][y+j].wcisniety) // sprawdz czy pole w tym kwadracie jest odkryte i znajduje sie na planszy jesli nie
                        {																					 // wywolaj funkcje odkrycia pola z wartosciami odpowiadającymi temu polu
                            odkryjPole(x+i,y+j);
                        }
                    }


                }
            }
        }
    }



}
