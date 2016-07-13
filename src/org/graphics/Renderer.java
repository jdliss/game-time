package org.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

import org.game.Game;
import org.input.Click;
import org.input.Input;
import org.world.World;

public class Renderer {
	
	private static Frame frame;
	private static Canvas canvas;
	
	private static float canvasWidth = 0;
	private static float canvasHeight = 0;
	
	private static final int GAME_WIDTH = 600;
	private static final int GAME_HEIGHT = 375;
	
	public static float gameHeight = 0;
	public static float gameWidth = 0;
	
	private static long lastFpsCheck = 0;
	private static int currentFPS = 0;
	private static int totalFrames = 0;
	private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
		
	public static double scaleX = 0;  
	public static double scaleY = 0;

	private static void getBestSize()  {		
		boolean done = false;
		while(!done) {
			canvasWidth += GAME_WIDTH;
			canvasHeight += GAME_HEIGHT;
			if(canvasWidth > SCREEN_SIZE.width || canvasHeight > SCREEN_SIZE.height) {
				canvasWidth -= GAME_WIDTH;
				canvasHeight -= GAME_HEIGHT;
				gameHeight = canvasHeight;
				gameWidth = canvasWidth;
				done = true;
			}
		}
		
		float xDiff = SCREEN_SIZE.width - canvasWidth;
		float yDiff = SCREEN_SIZE.height - canvasHeight;
		float factor = canvasWidth / GAME_WIDTH;
		gameWidth = canvasWidth / factor + xDiff / factor;
		gameHeight = canvasHeight / factor + yDiff / factor;
		canvasWidth = gameWidth * factor;
		canvasHeight = gameHeight * factor;
		scaleX = GAME_WIDTH / (SCREEN_SIZE.getWidth() - (SCREEN_SIZE.getWidth() * 0.06));
		scaleY =GAME_HEIGHT / (SCREEN_SIZE.getHeight() - (SCREEN_SIZE.getHeight() * 0.06));
	}	
	
	private static void startRendering() {
		GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
		VolatileImage vImage = gc.createCompatibleVolatileImage((int)gameWidth, (int)gameHeight);
		
		while(true) {
			totalFrames++;
			long nanoTime = System.nanoTime();
			if (nanoTime > lastFpsCheck + 1000000000) {
				lastFpsCheck = nanoTime;
				currentFPS = totalFrames;
				totalFrames = 0;
			}
			
			if (vImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {
				vImage = gc.createCompatibleVolatileImage((int)gameWidth, (int)gameHeight);
			}
			
			Graphics g = vImage.getGraphics();
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				    RenderingHints.VALUE_ANTIALIAS_ON);
			
			g.setColor(Color.black);
			g.fillRect(0, 0, (int) gameWidth,(int)gameHeight);
			
			World.update();
			World.render(g);
			
			g.setColor(Color.yellow);
			g.setFont(new Font("Futura", Font.PLAIN, 8)); 
			g.drawString(String.valueOf(currentFPS), (int) gameWidth - 20, 10);
			g.dispose();
			
			g = canvas.getGraphics();
			g.drawImage(vImage, 0, 0, (int) canvasWidth, (int) canvasHeight, null);
			g.dispose();
		}
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
		canvas.setPreferredSize(new Dimension( (int) canvasWidth, (int) canvasHeight));
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
		canvas.addKeyListener(new Input());
		canvas.addMouseListener(new Click());
		canvas.requestFocusInWindow();

		startRendering();
	}
}
