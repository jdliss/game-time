package org.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

import org.game.Game;
import org.world.World;

public class Renderer {

	private static Frame frame;
	private static Canvas canvas;
	
	private static int canvasWidth = 0;
	private static int canvasHeight = 0;
	
	private static final int GAME_WIDTH = 400;
	private static final int GAME_HEIGHT = 250;
	
	private static int gameHeight = 0;
	private static int gameWidth = 0;
	
	private static long lastFpsCheck = 0;
	private static int currentFPS = 0;
	private static int totalFrames = 0;
	
	private static void getBestSize()  {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = toolkit.getScreenSize();
		
		boolean done = false;
		while(!done) {
			canvasWidth += GAME_WIDTH;
			canvasHeight += GAME_HEIGHT;
			if(canvasWidth > screenSize.width || canvasHeight > screenSize.height) {
				canvasWidth -= GAME_WIDTH;
				canvasHeight -= GAME_HEIGHT;
				gameHeight = canvasHeight;
				gameWidth = canvasWidth;
				done = true;
			}
		}
		int xDiff = screenSize.width - canvasWidth;
		int yDiff = screenSize.height - canvasHeight;
		int factor = canvasWidth / GAME_WIDTH;
		gameWidth = canvasWidth / factor + xDiff / factor;
		gameHeight = canvasHeight / factor + yDiff / factor;
		canvasWidth = gameWidth * factor;
		canvasHeight = gameHeight * factor;
	}	
	
	private static void startRendering() {
		Thread thread = new Thread() {
			public void run() {
				GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
				VolatileImage vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);
				
				while(true) {
					totalFrames++;
					
					if (System.nanoTime() > lastFpsCheck + 1000000000) {
						lastFpsCheck = System.nanoTime();
						currentFPS = totalFrames;
						totalFrames = 0;
					}
					
					if (vImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {
						vImage = gc.createCompatibleVolatileImage(gameWidth, gameHeight);
					}
					
					Graphics g = vImage.getGraphics();
					
					g.setColor(Color.black);
					g.fillRect(0, 0, gameWidth, gameHeight);
					
					World.update();
					World.render(g);
					
					g.setColor(Color.yellow);
					g.setFont(new Font("Futura", Font.PLAIN, 8)); 
					g.drawString(String.valueOf(currentFPS), gameWidth - 20, 10);
					
					g.dispose();
					
					g = canvas.getGraphics();
					g.drawImage(vImage, 0, 0, canvasWidth, canvasHeight, null);
					g.dispose();
				}
			}
		};
		thread.setName("rendering thread");
		thread.start();
	}
	
	private static void makeFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = env.getDefaultScreenDevice();
		if (gd.isFullScreenSupported()) {
			frame.setUndecorated(true);
			gd.setFullScreenWindow(frame);
		}
	}
	
	public static void init() {
		getBestSize();
		
		frame = new Frame();
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		frame.add(canvas);
		makeFullscreen();
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Game.quit();
			}
		});
		
		frame.setVisible(true);
		startRendering();
	}


}
