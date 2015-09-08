package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Main.GamePanel;
import TileMap.Background;

public class GameOverState extends GameState {

	private Background bg;
	private GamePanel gp = new GamePanel();
	
	private Font font;
	private Color color;
	
	public GameOverState(GameStateManager gsm){
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/gameoverbg.png", 1);
			//bg.setVector(-0.1, 0);
			
			color = new Color(128, 0, 0);
			font = new Font(
					"Century Gothic",
					Font.PLAIN,
					28);
			
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
		
		g.setColor(color);
		g.setFont(font);
		g.drawString("GAME OVER", 80, 70);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 12));
		g.drawString("Press enter to try again", 100, 170);
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(gsm.MENUSTATE);
		}
	}

	public void keyReleased(int k) {
		
	}

}