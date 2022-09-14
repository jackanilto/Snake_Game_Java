package Main;

import Gameplay.KittyGame;
import Gameplay.SimpleGame;
import Gameplay.StarGame;

import javax.swing.JFrame;
import java.awt.*;

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Doces ou Travessuras");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
	public static void simple() {
        JFrame gameplay = new JFrame("Doces ou Travessuras - Abóbora Comum");
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
        JFrame gameplay = new JFrame("Doces ou Travessuras - Fantasma de gatinho");
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
        JFrame gameplay = new JFrame("Doces ou Travessuras - Estrela Drácula");
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
