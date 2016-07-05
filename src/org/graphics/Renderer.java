package org.graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.game.Game;

public class Renderer {

	private static Frame frame;
	private static Canvas canvas;
	
	private static int canvasWidth = 0;
	private static int canvasHeight = 0;
	
	private static final int GAME_WIDTH = 400;
	private static final int GAME_HEIGHT = 250;
	
	private static void getBestSize()  {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = toolkit.getScreenSize();
		
		boolean done = false;
		while(!done) {
			canvasWidth += GAME_WIDTH;
			canvasHeight += GAME_HEIGHT;
			
			if(canvasWidth > screenSize.width || canvasHeight > screenSize.height) {
				canvasWidth -= GAME_WIDTH + GAME_WIDTH / 10 ;
				canvasHeight -= GAME_HEIGHT + GAME_HEIGHT / 10 ;
				
				done = true;
			}
		}
	}	
	
	public static void init() {
		getBestSize();
		
		frame = new Frame();
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		frame.add(canvas);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Game.quit();
			}
		});
		
		frame.setVisible(true);
	}
}
