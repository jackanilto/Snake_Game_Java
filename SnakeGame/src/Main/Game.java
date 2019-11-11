package Main;

import GameState.KittyGame;
import GameState.SimpleGame;
import GameState.StarGame;

import javax.swing.JFrame;
import java.awt.*;

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Tricks or Treats");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
	public static void simple() {
        JFrame gameplay = new JFrame("Tricks or Treats - Comum Pumpkin");
        SimpleGame SimpleGame = new SimpleGame();

        gameplay.setBounds(320, 240, 905, 700);
        gameplay.setBackground(new Color(56, 36, 83));
        gameplay.setResizable(false);
        gameplay.setVisible(true);
        gameplay.setLocationRelativeTo(null);
        gameplay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gameplay.add(SimpleGame);
    }

    public static void kitty() {
        JFrame gameplay = new JFrame("Tricks or Treats - Kitty Ghost");
        KittyGame kittyGame = new KittyGame();

        gameplay.setBounds(320, 240, 905, 700);
        gameplay.setBackground(new Color(56, 36, 83));
        gameplay.setResizable(false);
        gameplay.setVisible(true);
        gameplay.setLocationRelativeTo(null);
        gameplay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gameplay.add(kittyGame);
    }

    public static void star() {
        JFrame gameplay = new JFrame("Tricks or Treats - Star Dracula");
        StarGame starGame = new StarGame();

        gameplay.setBounds(320, 240, 905, 700);
        gameplay.setBackground(new Color(56, 36, 83));
        gameplay.setResizable(false);
        gameplay.setVisible(true);
        gameplay.setLocationRelativeTo(null);
        gameplay.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gameplay.add(starGame);
    }

	
}
