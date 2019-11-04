package GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarGame extends JPanel implements KeyListener, ActionListener{

    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    private ImageIcon snakeimage;

    // "Cobra" começa com tamanho
    private int lengthsnake = 3;

    private Timer timer;
    private int delay = 100;

    // Posição das "frutas"
    private int[] Simplefruitxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,
            775,800,825,850};
    private int[] Simplefruitypos = {75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625};

    private ImageIcon Simplefruit;

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    // Pontuação
    private int score = 0;

    private int moves = 0;

    private ImageIcon titleImage;

    public StarGame() {

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakexlength[2] = 50;
            snakexlength[1] = 75;
            snakexlength[0] = 100;

            snakeylength[2] = 100;
            snakeylength[1] = 100;
            snakeylength[0] = 100;
        }

        // Arte - Borda
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 851, 55);

        // Arte - Título superior
        titleImage = new ImageIcon("Resources/Backgrounds/snaketitle.png");
        titleImage.paintIcon(this, g, 25, 11 );

        // Arte - Borda gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);

        // Arte - Background gameplay
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        // Arte - Pontuação
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Pontuação: " + score, 700, 30);

        // Arte - Tamanho da "cobra"
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Tamanho: " + lengthsnake, 700, 50);


        rightmouth = new ImageIcon("Resources/Characters/draculaR.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

        // Movimento da "cobra"
        for (int a = 0; a < lengthsnake; a++) {
            if (a==0 && right) {
                rightmouth = new ImageIcon("Resources/Characters/draculaR.png");
                rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && left) {
                leftmouth = new ImageIcon("Resources/Characters/draculaL.png");
                leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && down) {
                downmouth = new ImageIcon("Resources/Characters/draculaD.png");
                downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && up) {
                upmouth = new ImageIcon("Resources/Characters/draculaU.png");
                upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a!=0) {
                snakeimage = new ImageIcon("Resources/Characters/bat.png");
                snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
        }

        Simplefruit = new ImageIcon("Resources/Fruits/simpleCandy.png");
        if ((Simplefruitxpos[xpos] == snakexlength[0] && Simplefruitypos[ypos] == snakeylength[0])) {
            score+=2;
            lengthsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        Simplefruit.paintIcon(this, g, Simplefruitxpos[xpos], Simplefruitypos[ypos]);

        for (int b = 1; b < lengthsnake; b++) {
            if (snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.ORANGE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Aperte 'space' para REINICIAR ", 290, 340);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(right) {
            for (int r = lengthsnake - 1; r >= 0; r--) {
                snakeylength[r+1] = snakeylength[r];
            }
            for (int r = lengthsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] + 25;
                }
                else {
                    snakexlength[r] = snakexlength[r-1];
                }
                if (snakexlength[r] > 850) {
                    snakexlength[r] = 25;
                }
            }
            repaint();
        }
        if(left) {
            for (int r = lengthsnake - 1; r >= 0; r--) {
                snakeylength[r+1] = snakeylength[r];
            }
            for (int r = lengthsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] - 25;
                }
                else {
                    snakexlength[r] = snakexlength[r-1];
                }
                if (snakexlength[r] < 25) {
                    snakexlength[r] = 850;
                }
            }
            repaint();
        }
        if(up) {
            for (int r = lengthsnake - 1; r >= 0; r--) {
                snakexlength[r+1] = snakexlength[r];
            }
            for (int r = lengthsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] - 25;
                }
                else {
                    snakeylength[r] = snakeylength[r-1];
                }
                if (snakeylength[r] < 75) {
                    snakeylength[r] = 625;
                }
            }
            repaint();
        }
        if(down) {
            for (int r = lengthsnake - 1; r >= 0; r--) {
                snakexlength[r+1] = snakexlength[r];
            }
            for (int r = lengthsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeylength[r] = snakeylength[r] + 25;
                }
                else {
                    snakeylength[r] = snakeylength[r-1];
                }
                if (snakeylength[r] > 625) {
                    snakeylength[r] = 75;
                }
            }
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            moves = 0;
            score = 0;
            lengthsnake = 3;
            repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            }
            else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            }
            else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            }
            else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            }
            else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
