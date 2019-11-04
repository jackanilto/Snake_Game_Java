package Main;

import GameState.SimpleGame;

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
	
}
