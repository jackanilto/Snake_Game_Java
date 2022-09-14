package Menu;

import Main.Game;
import Menu.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
		"Comum Pumpkin",
		"Kitty Ghost",
		"Star Dracula",
		"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			//
			bg = new Background("/Backgrounds/backMenu.png", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(159, 0, 0);
			titleFont = new Font("SERIF",
					Font.BOLD,
					20);
			
			font = new Font("Camélia", Font.PLAIN, 20);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		// Arte - Background
		bg.draw(g);
		
		// Arte - Título (dentro do Panel menu)
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Tricks or Treats", 50, 70);
		
		// Arte - Opções do menu
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLUE);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 60, 130 + i * 15);
		}
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			// Comum Pumpkin
			Game.simple();
		}
		if(currentChoice == 1) {
			// Kitty Ghost
            Game.kitty();
		}
		if(currentChoice == 2) {
			// Star Dracula
            Game.star();
		}
		if(currentChoice == 3) {
			// Quit
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
	
}
