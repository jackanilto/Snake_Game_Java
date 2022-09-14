package Gameplay;

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

public class KittyGame extends JPanel implements KeyListener, ActionListener{

    public int time;

    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];

    private static boolean gameOver = false;
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    private ImageIcon snakeimage;


    private int lengthsnake = 3;

    private Timer timer;
    private int delay = 100;


    private int[] Simplefruitxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] Bigfruitxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] Decreasefruitxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int[] Bombfruitxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};

    private int[] fruitypos = {75,100,125,150,175,200,225,250,400,425,450,
            475,500,525,550,575,600,625};


    private ImageIcon Simplefruit;
    private ImageIcon Bigfruit;
    private ImageIcon Decreasefruit;
    private ImageIcon Bombfruit;

    private ImageIcon Castleobstacle;

    private Random random = new Random();
    private int xpos = random.nextInt(29);
    private int ypos = random.nextInt(18);


    private Random randomFruit = new Random();
    private int PopsUp = randomFruit.nextInt(15);


    private int score = 0;

    private int moves = 0;

    private ImageIcon titleImage;

    public KittyGame() {
        time = 0;

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


        g.setColor(new Color(255, 127, 39));
        g.drawRect(24, 10, 851, 55);


       // titleImage = new ImageIcon("Resources/Backgrounds/snaketitle.png");
        titleImage = new ImageIcon("Resources/Backgrounds/snaketitle.png");
        titleImage.paintIcon(this, g, 25, 11 );


        g.setColor(new Color(255, 127, 39));
        g.drawRect(24, 74, 851, 577);


        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);


        g.setColor(new Color(255, 127, 39));
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Pontuação: " + score, 700, 35);


        g.setColor(new Color(255, 127, 39));
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Tamanho: " + lengthsnake, 700, 55);


        rightmouth = new ImageIcon("Resources/Characters/ghostR.png");
        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);


        for (int a = 0; a < lengthsnake; a++) {
            if (a==0 && right) {
                rightmouth = new ImageIcon("Resources/Characters/ghostR.png");
                rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && left) {
                leftmouth = new ImageIcon("Resources/Characters/ghostL.png");
                leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && down) {
                downmouth = new ImageIcon("Resources/Characters/ghostD.png");
                downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a==0 && up) {
                upmouth = new ImageIcon("Resources/Characters/ghostU.png");
                upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
            if (a!=0) {
                snakeimage = new ImageIcon("Resources/Characters/ghost.png");
                snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
        }

        Castleobstacle = new ImageIcon("Resources/Fruits/obstacleCastle.png");
        Castleobstacle.paintIcon(this, g, 375, 275);

        if (PopsUp <= 6) {
            // Simple Fruit
            Simplefruit = new ImageIcon("Resources/Fruits/simpleCandy.png");
            if ((Simplefruitxpos[xpos] == snakexlength[0] && fruitypos[ypos] == snakeylength[0])) {
                score ++;
                lengthsnake++;
                time = 0;
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);

                PopsUp = randomFruit.nextInt(10);
            }else if (time >= 90) {
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);
                PopsUp = randomFruit.nextInt(10);
                time = 0;
            }
            Simplefruit.paintIcon(this, g, Simplefruitxpos[xpos], fruitypos[ypos]);
        }
        else if (PopsUp > 6 && PopsUp <= 9 ) {
            // Big Fruit
            Bigfruit = new ImageIcon("Resources/Fruits/bigPumpkin.png");
            if ((Bigfruitxpos[xpos] == snakexlength[0] && fruitypos[ypos] == snakeylength[0])) {
                score += 2;
                lengthsnake++;
                time = 0;
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);

                PopsUp = randomFruit.nextInt(15);
            }else if (time >= 90) {
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);
                PopsUp = randomFruit.nextInt(15);
                time = 0;
            }

            Bigfruit.paintIcon(this, g, Bigfruitxpos[xpos], fruitypos[ypos]);
        }
        else if (PopsUp > 9 && PopsUp <= 13 ) {
            // Bomb Fruit
            Bombfruit = new ImageIcon("Resources/Fruits/bombPoison.png");
            if ((Bombfruitxpos[xpos] == snakexlength[0] && fruitypos[ypos] == snakeylength[0])) {
                right = false;
                left = false;
                up = false;
                down = false;
                gameOver = true;

                g.setColor(Color.ORANGE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over e TRAVESSURAS", 78, 200);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Aperte 'space' para REINICIAR ", 290, 240);

            }else if (time >= 90) {
                // Tempo de desaparecimento da fruta
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);
                PopsUp = randomFruit.nextInt(15);
                time = 0;
            }
            Bombfruit.paintIcon(this, g, Bombfruitxpos[xpos], fruitypos[ypos]);
        }
        else {
            // Decrease Fruit
            Decreasefruit = new ImageIcon("Resources/Fruits/decreaseSaw.png");
            if ((Decreasefruitxpos[xpos] == snakexlength[0] && fruitypos[ypos] == snakeylength[0])) {
                lengthsnake = 3;
                time = 0;
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);

                PopsUp = randomFruit.nextInt(15);
            }else if (time >= 90) {
                xpos = random.nextInt(29);
                ypos = random.nextInt(18);
                PopsUp = randomFruit.nextInt(15);
                time = 0;
            }
            Decreasefruit.paintIcon(this, g, Decreasefruitxpos[xpos], fruitypos[ypos]);
        }


        for (int b = 1; b < lengthsnake; b++) {
            if (snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {
                right = false;
                left = false;
                up = false;
                down = false;

                gameOver = true;

                g.setColor(Color.ORANGE);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over e TRAVESSURAS", 78, 200);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Aperte 'space' para REINICIAR ", 290, 240);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        time++;

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
                    snakexlength[r] = 850;
                }
            }
            repaint();
        }
        if (left) {
            for (int r = lengthsnake - 1; r >= 0; r--) {
                snakeylength[r + 1] = snakeylength[r];
            }
            for (int r = lengthsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexlength[r] = snakexlength[r] - 25;
                } else {
                    snakexlength[r] = snakexlength[r - 1];
                }
                if (snakexlength[r] < 25) {
                    snakexlength[r] = 25;
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
                    snakeylength[r] = 75;
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
                    snakeylength[r] = 625;
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
            time = 0;
            gameOver = false;
            repaint();
        }

        if (!gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                moves++;
                right = true;
                if (!left) {
                    right = true;
                } else {
                    right = false;
                    left = true;
                }
                up = false;
                down = false;
            }

            if (moves != 0) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    moves++;
                    left = true;
                    if (!right) {
                        left = true;
                    } else {
                        left = false;
                        right = true;
                    }
                    up = false;
                    down = false;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                moves++;
                up = true;
                if (!down) {
                    up = true;
                } else {
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
                } else {
                    down = false;
                    up = true;
                }
                left = false;
                right = false;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
