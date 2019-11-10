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
		window.setVisible(true);

	}
	public static void simple() {
        JFrame obj = new JFrame();
        SimpleGame SimpleGame = new SimpleGame();

        obj.setBounds(320, 240, 905, 700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(SimpleGame);
    }

    public static void kitty() {
        JFrame obj = new JFrame();
        KittyGame kittyGame = new KittyGame();

        obj.setBounds(320, 240, 905, 700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(kittyGame);
    }

    public static void star() {
        JFrame obj = new JFrame();
        StarGame starGame = new StarGame();

        obj.setBounds(320, 240, 905, 700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(starGame);
    }

	
}
