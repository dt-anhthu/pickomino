package dice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import managers.DiceManager;

public class Dice {
	
	private static DiceManager diceManager;

	public Dice() {
	}
	
	public static void roll() {
		
		Random rand = new Random();
		JLabel dice1Img = DiceManager.loadImage("/dice1.png");
		JLabel dice2Img = DiceManager.loadImage("/dice1.png");
		JLabel dice3Img = DiceManager.loadImage("/dice1.png");
		JLabel dice4Img = DiceManager.loadImage("/dice1.png");
		JLabel dice5Img = DiceManager.loadImage("/dice1.png");
		JLabel dice6Img = DiceManager.loadImage("/dice1.png");
		JLabel dice7Img = DiceManager.loadImage("/dice1.png");
		JLabel dice8Img = DiceManager.loadImage("/dice1.png");
		
	    // roll for 3 seconds
	    long startTime = System.currentTimeMillis();
	    Thread rollThread = new Thread(new Runnable() {
	          @Override
	          public void run() {
	              long endTime = System.currentTimeMillis();
	              try{
	                  while((endTime - startTime)/1000F < 3){
	                      // roll dice
	                	  
	                	  int dice1 = rand.nextInt(6)+1;
	                	  int dice2 = rand.nextInt(6)+1;
	                	  int dice3 = rand.nextInt(6)+1;
	                	  int dice4 = rand.nextInt(6)+1;
	                	  int dice5 = rand.nextInt(6)+1;
	                	  int dice6 = rand.nextInt(6)+1;
	                	  int dice7 = rand.nextInt(6)+1;
	                	  int dice8 = rand.nextInt(6)+1;

                          // update dice images 
	                	  DiceManager.updateImage(dice1Img, "/dice" + dice1 + ".png");
	                	  DiceManager.updateImage(dice2Img, "/dice" + dice2 + ".png");
	                	  DiceManager.updateImage(dice3Img, "/dice" + dice3 + ".png");
	                	  DiceManager.updateImage(dice4Img, "/dice" + dice4 + ".png");
	                	  DiceManager.updateImage(dice5Img, "/dice" + dice5 + ".png");
	                	  DiceManager.updateImage(dice6Img, "/dice" + dice6 + ".png");
	                	  DiceManager.updateImage(dice7Img, "/dice" + dice7 + ".png");
	                	  DiceManager.updateImage(dice8Img, "/dice" + dice8 + ".png");
	                	  
//	                	  repaint();
//                          revalidate();
//                          
//	                	  for(int i=0; i<8; i++) {
//	                		  int randomNum = rand.nextInt(6)+1;
//	                		  int diceNum = i;
//		                      // update dice images 
//	                		  DiceManager.updateImage(, "/dice" + randomNum + ".png");
//	                	  }
//	                	  
	                      // sleep thread
	                      Thread.sleep(60);
	
	                      endTime = System.currentTimeMillis();
	
	                  }
	
	              }catch(InterruptedException e){
	                  System.out.println("Threading Error: " + e);
	                  }
	              }
	          });
	          rollThread.start();	
		}
}
