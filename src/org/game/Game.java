package org.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.graphics.Renderer;
import org.input.Input;
import org.object.Player;
import org.object.Sprite;
import org.object.ZombieNormal;
import org.world.World;

public class Game {
	
	public static boolean started = false;
	
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
		World.playerOne = new Player(300, 200);
		World.currentWorld.sprites.add(World.playerOne);
		
		spawnInitialZombies();
	}
	
	private static void spawnInitialZombies() {
		World.currentWorld.sprites.add(new ZombieNormal(0,0));
		World.currentWorld.sprites.add(new ZombieNormal(0, 375));
		World.currentWorld.sprites.add(new ZombieNormal(600,0));
		World.currentWorld.sprites.add(new ZombieNormal(600,375));
	}
	
	public static void quit() {
		System.exit(0);
	}
	
	public static void startScreen(Graphics g) {
		drawStartScreen(g);
		handleStartInput();
	}
	
	public static void drawStartScreen(Graphics g) {
		g.setColor(Color.yellow);
		drawCenteredString(g, "SquarePocalypse", new Font("Futura", Font.PLAIN, 30), -150);
		
		g.setColor(Color.white);
		Font body = new Font("Futura", Font.PLAIN, 14);
		drawCenteredString(g, "Move with WASD.", body, -80);
		drawCenteredString(g, "Aim and shoot with the mouse.", body, -60);
		
		g.setColor(Color.red);
		drawCenteredString(g, "Goal: Survive.", body, -20);
		
		g.setColor(Color.white);
		drawCenteredString(g, "Press SPACE to begin", body, 80);
		drawCenteredString(g, "Press Q to quit", body, 100);
		
		g.dispose();
	}
	
	public static void handlePlayerDeath(Graphics g) {
		wipeGameState(g);
		drawDeathScreen(g);
		handleDeathInput();
	}
	
	private static void wipeGameState(Graphics g) { 
		g.setColor(Color.black);
		g.fillRect(0, 0, (int) Renderer.gameWidth, (int) Renderer.gameHeight);
		World.currentWorld.sprites = new ArrayList<Sprite>();
	}
	
	private static void drawDeathScreen(Graphics g) {
		g.setColor(Color.red);
		drawCenteredString(g, "GAME OVER", new Font("Futura", Font.PLAIN, 20), -50);
		
		g.setColor(Color.yellow);
		drawCenteredString(g, "Score: " + String.valueOf(World.playerOne.score), new Font("Futura", Font.PLAIN, 12), -20);
		
		g.setColor(Color.red);
		drawCenteredString(g, "Press SPACE to restart", new Font("Futura", Font.PLAIN, 11), 30);
		
		g.setColor(Color.red);
		drawCenteredString(g, "Press Q to quit", new Font("Futura", Font.PLAIN, 11), 50);
		
		g.dispose();
	}
	
	private static void drawCenteredString(Graphics g, String text, Font font, int yModifier) {
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = ((int) Renderer.gameWidth - metrics.stringWidth(text)) / 2;
	    int y = (((int) Renderer.gameHeight - metrics.getHeight()) / 2) + metrics.getAscent();
	    
	    g.setFont(font);
	    g.drawString(text, x, y + yModifier);
	}
	
	private static void handleStartInput() {
		if (Input.getKey(KeyEvent.VK_SPACE)) {
			started = true;
		}
		
		quitInput();
	}
	
	private static void handleDeathInput() {
		if (Input.getKey(KeyEvent.VK_SPACE)) {
			restart();
		}
		
		quitInput();
	}
	
	private static void quitInput() {
		if (Input.getKey(KeyEvent.VK_Q)) {
			quit();
		}
	}
	
}