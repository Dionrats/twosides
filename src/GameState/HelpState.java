package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Main.GamePanel;
import TileMap.Background;

public class HelpState extends GameState{
	
	private Background bg;
	private GamePanel gp = new GamePanel();
	
	private Font font;
	
	private String[] helpText = {"Hier komt de text die uitleg geeft over besturing en game-play van de",
								"game. dit moet ervoor zorgen dat de gebruiker een prettige ervaring heeft", 
								"met het spelen van de game. hierdoor begrijpt hij/zij de shit die hij/zij moet", 
								"doen om het spel leuk te vinden"};

	
	public HelpState(GameStateManager gsm){
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/grassbg1.gif", 1);
			bg.setVector(-0.1, 0);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init() {}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		//g.fillRect(10, 10, gp.WIDTH-20, gp.HEIGHT-20);
		
		drawHelpText(g);
		
		g.setColor(Color.WHITE);
		g.drawString("Back", 145, 170);
		
	}
	
	private void drawHelpText(Graphics2D g){
		g.setFont(font.deriveFont(9.0f));
		g.setColor(Color.red);
		for(int x=1;x<=helpText.length;x++){
			g.drawString(helpText[x-1], 5, 20*x);
		}
		g.setFont(font.deriveFont(28));
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(gsm.MENUSTATE);
		}
	}

	public void keyReleased(int k) {
		
	}

}
