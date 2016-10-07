package org.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import org.game.Game;
import org.object.Bullet;
import org.object.Player;
import org.object.Sprite;
import org.object.ZombieNormal;
import org.object.ZombieAxis;
import org.object.ZombieFat;


public class World {
	
	public static World currentWorld = null;
	public static Player playerOne = null;
	public static boolean destroyZombies = false; 
	private static int count = 0;
	
	private static long lastTime = System.nanoTime();
	
	public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	public static boolean rendering = false;
	public static boolean updating = false;

	public static void update() {
		updating = true;
		float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
		lastTime = System.nanoTime();
		
		updateCurrentWorldBullets(deltaTime);
		updateCurrentWorldZombies(deltaTime);
		spawnZombie(count);
		updating = false;
	}
	
	
	public static void render(Graphics g) {
		rendering = true;
		if (Game.started) {
			renderSprites(g);
			renderBullets(g);
			
			if (playerOne.isDead) {
				Game.handlePlayerDeath(g);	
			}
			
		} else {
			Game.startScreen(g);
		}
		rendering = false;
	}
	
	private static void renderBullets(Graphics g) {
		for (Bullet bullet : currentWorld.bullets) {
			bullet.render(g);
		}
	}
	
	private static void renderSprites(Graphics g) {
		for (Sprite sprite : currentWorld.sprites) {
			sprite.render(g);
		}
	}
	
	public static void updateCurrentWorldBullets(float deltaTime){
		for (Bullet bullet : currentWorld.bullets) {
			bullet.update(deltaTime);
		}
		
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets = (ArrayList<Bullet>) currentWorld.bullets.stream().filter(e -> !e.remove).collect(Collectors.toList());
		count = currentWorld.bullets.size() - bullets.size();
		currentWorld.bullets = bullets;
	}
	
	public static void updateCurrentWorldZombies(float deltaTime){
		for (Sprite sprite : currentWorld.sprites) {
			sprite.update(deltaTime);
		}
		
		ArrayList<Sprite> sprites = new ArrayList<Sprite>();
		checkClearBoard(sprites);
		sprites = (ArrayList<Sprite>) currentWorld.sprites.stream().filter(e -> e.health > 0).collect(Collectors.toList());
		currentWorld.sprites = sprites;
	}
	
	public static void checkClearBoard(ArrayList<Sprite> sprites){
		if (destroyZombies) {
			sprites = (ArrayList<Sprite>) currentWorld.sprites.stream().filter(e -> e.getClass().equals(Player.class)).collect(Collectors.toList());
			currentWorld.sprites = sprites;
			count = 4;
			destroyZombies = false;
			World.playerOne.score += 50;
		}
	}
	
	public static void spawnZombie(int count) {		
		for (int i = 0; i < count; i++) {
			Random r = new Random();
			for (int j = 0; j < r.nextInt(3 - 1) + 1; j++) {
				int x = r.nextInt(580 - 10) + 10;
				int y = r.nextInt(350 - 10) + 10;
				
				int[] xList = new int[3];
				int[] yList = new int[3];
				
				xList[1] = 0;
				xList[2] = 600;
				yList[1] = 0;
				yList[2] = 375;
				
				Random random = new Random();
				int xCoord = random.nextInt(2) + 1;
				int yCoord = random.nextInt(2) + 1;
				
				if (j % 2 == 0) {
					World.currentWorld.sprites.add(new ZombieNormal(xList[xCoord], yList[yCoord]));	
				} else {
					World.currentWorld.sprites.add(new ZombieAxis(xList[r.nextInt(2 - 1) + 1], yList[r.nextInt(2 - 1) + 1]));
				}

				Random rand = new Random();
				if (rand.nextInt(20) == 4) {
					World.currentWorld.sprites.add(new ZombieFat(x, y));
				}				
			}
		}
	}
}
