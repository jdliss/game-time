package org.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import org.graphics.Renderer;
import org.input.Input;
import org.object.Player;
import org.object.Sprite;
import org.object.ZombieNormal;
import org.world.World;

public class Game {
	
	public static void main(String []args) {
		start();
	}

	private static void start() {
		setGameWorld();
		
		Renderer.init();
	}
	
	private static void restart() {
		setGameWorld();
	}
	
	private static void setGameWorld() {
		World.currentWorld = new World();
		World.playerOne = new Player(200, 125);
		World.currentWorld.sprites.add(World.playerOne);
		
		spawnInitialZombies();
	}
	
	private static void spawnInitialZombies() {
		for (int i = 0; i < 10; i++) {
			Random r = new Random();
			int x = r.nextInt(350 -10) + 10;
			int y = r.nextInt(10);
			World.currentWorld.sprites.add(new ZombieNormal(x, y));
		}
	}
	
	public static void quit() {
		System.exit(0);
	}
	
	public static void handlePlayerDeath(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, (int) Renderer.gameWidth, (int) Renderer.gameHeight);
		World.currentWorld.sprites = new ArrayList<Sprite>();
		g.setColor(Color.red);
		drawCenteredString(g, "GAME OVER", new Font("Futura", Font.PLAIN, 20), -50);
		
		g.setColor(Color.yellow);
		drawCenteredString(g, "Score: " + String.valueOf(World.playerOne.score), new Font("Futura", Font.PLAIN, 12), -20);
		
		g.setColor(Color.red);
		drawCenteredString(g, "Press SPACE to restart", new Font("Futura", Font.PLAIN, 11), 30);
		
		g.setColor(Color.red);
		drawCenteredString(g, "Press Q to quit", new Font("Futura", Font.PLAIN, 11), 50);		

		g.dispose();
		checkForRestart();
	}
	
	private static void drawCenteredString(Graphics g, String text, Font font, int yModifier) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = ((int) Renderer.gameWidth - metrics.stringWidth(text)) / 2;
	    int y = (((int) Renderer.gameHeight - metrics.getHeight()) / 2) + metrics.getAscent();
	    
	    g.setFont(font);
	    g.drawString(text, x, y + yModifier);
	}
	
	private static void checkForRestart() {
		if (Input.getKey(KeyEvent.VK_SPACE)) {
			restart();
		}
		
		if (Input.getKey(KeyEvent.VK_Q)) {
			quit();
		}
	}

}
