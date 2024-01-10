package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dice.Dice;
import dice.ImgService;
import scenes.Playing;

public class DiceManager {
	
	private Playing playing;
	private static BufferedImage[] diceImgs;
	private static BufferedImage img;
	private ArrayList<Dice> dices = new ArrayList<>();

	public DiceManager(Playing playing) {
		this.playing = playing;
		diceImgs = new BufferedImage[6];
		dices.add(new Dice());
		loadDiceImgs();
	}
	//Load image dice face
	private void loadDiceImgs() {

		for(int i = 0; i <= 5; i++) {
			diceImgs[i] = importImg("/dice"+ (i+1) +".png");
		}		
	}
//	
//	//Update image dice face
//    public static void updateImage(int randomNum, int diceNum, Graphics g){
//    	if(diceNum>=0 && diceNum <=3)
//    		drawDice(randomNum, g, 360+64*diceNum, 320);
//    	else
//    		drawDice(randomNum, g, 360+64*(diceNum-5), 392);
//    }
//	
	public static JLabel loadImage(String filePath){
        BufferedImage img;
        JLabel imageContainer;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            img = ImageIO.read(inputStream);
            imageContainer = new JLabel(new ImageIcon(img));
            return imageContainer;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return null;
        }
    }
	
    public static void updateImage(JLabel imageContainer, String filePath){
        BufferedImage img;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            img = ImageIO.read(inputStream);
            imageContainer.setIcon(new ImageIcon(img));
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    private static BufferedImage importImg(String imgPath) {
    	
    	InputStream is = DiceManager.class.getResourceAsStream(imgPath);
    	
    	try {
    		img = ImageIO.read(is);
    		return img;
    	} catch (IOException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
	public void update() {
		for (Dice d : dices)
			d.roll();
	}
	
	public void draw(Graphics g) {
		
		int xOffset = 63;
		int yOffset = 71;
		
		for(int y = 320; y < 400; y++) {
			for(int x = 360; x < 560; x++) {
				drawDice(0, g, x, y);
				x=x+xOffset;
			}
			y=y+yOffset;
		}
	
		
	}
	private static void drawDice(int i, Graphics g, int x, int y) {
		g.drawImage(diceImgs[i], x, y, null);
		
	}



}
