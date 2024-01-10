package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import dice.Dice;
import dice.RollingDice;
import helpz.LevelBuild;
import main.Game;
import managers.DiceManager;
import managers.TileManager;
import ui.MyButton;

import static main.GameStates.*;

public class Playing extends GameScene implements SceneMethods {

	private int[][] lvl;
	private TileManager tileManager;
	private BufferedImage img;
	private MyButton bMenu;
	
	private DiceManager diceManager;
	private MyButton bRoll;
	private MyButton bStop;



	public Playing(Game game) {
		super(game);
		importImg();
		initButtons();
		lvl = LevelBuild.getLevelData();
		tileManager = new TileManager();
		diceManager = new DiceManager(this);

	}

	private void initButtons() {
		bMenu = new MyButton("Menu", 60, 20, 60, 30);
		bRoll = new MyButton("Roll", 400, 435, 45, 25);
		bStop = new MyButton("Stop", 500, 435, 45, 25);

		
	}
	
	public void update() {
		diceManager.update();
	}

	@Override
	public void render(Graphics g) {

		for (int y = 0; y < lvl.length; y++) {
			for (int x = 0; x < lvl[y].length; x++) {
				int id = lvl[y][x];
				g.drawImage(tileManager.getSprite(id), x * 32, y * 32, null);
			}
		}
 		g.drawImage(img, 0, 0, null);
 		
 		//Dice
// 		SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new RollingDice().setVisible(true);
//            }
//        });

		drawButtons(g);
		
		diceManager.draw(g);

	}

	private void drawButtons(Graphics g) {
		bMenu.draw(g);
		bRoll.draw(g);
		bStop.draw(g);

	}
	
	private void importImg() {

		InputStream is = getClass().getResourceAsStream("/playing.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			SetGameState(MENU);
		else if (bRoll.getBounds().contains(x,y))
			Dice.roll();
	//	else if (bStop.getBounds().contains(x,y))
	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu.setMouseOver(false);
		bRoll.setMouseOver(false);
		bStop.setMouseOver(false);

		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseOver(true);
		else if (bRoll.getBounds().contains(x, y))
			bRoll.setMouseOver(true);
		else if (bStop.getBounds().contains(x, y))
			bStop.setMouseOver(true);

	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
		else if (bRoll.getBounds().contains(x, y))
			bRoll.setMousePressed(true);
		else if (bStop.getBounds().contains(x, y))
			bStop.setMousePressed(true);

	}

	@Override
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();
		bRoll.resetBooleans();
		bStop.resetBooleans();


	}

}