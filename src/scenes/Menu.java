package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import main.Game;
import ui.MyButton;
import static main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

	private BufferedImage img;

	private MyButton bPlaying, bQuit;

	public Menu(Game game) {
		super(game);
		importImg();
		initButtons();
	}

	private void initButtons() {

		int w = 200;
		int h = w / 5;
		int x = 960 / 2 - w / 2;
		int y = 373;
		int yOffset = 50;

		bPlaying = new MyButton("Play", x, y, w, h);
		bQuit = new MyButton("Quit", x, y + yOffset, w, h);

	}

	@Override
	public void render(Graphics g) {

 		g.drawImage(img, 0, 0, null);
		drawButtons(g);

	}

	private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bQuit.draw(g);

	}

	private void importImg() {

		InputStream is = getClass().getResourceAsStream("/menu.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(int x, int y) {

		if (bPlaying.getBounds().contains(x, y)) {
			SetGameState(PLAYING);
		} else if (bQuit.getBounds().contains(x, y))
			System.exit(0);
	}

	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setMouseOver(false);
		bQuit.setMouseOver(false);

		if (bPlaying.getBounds().contains(x, y)) {
			bPlaying.setMouseOver(true);
		} else if (bQuit.getBounds().contains(x, y)) {
			bQuit.setMouseOver(true);
		}

	}

	@Override
	public void mousePressed(int x, int y) {

		if (bPlaying.getBounds().contains(x, y)) {
			bPlaying.setMousePressed(true);
		} else if (bQuit.getBounds().contains(x, y)) {
			bQuit.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		bPlaying.resetBooleans();
		bQuit.resetBooleans();
	}

}