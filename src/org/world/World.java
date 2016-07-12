package org.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import org.object.Bullet;
import org.object.Player;
import org.object.Sprite;
import org.object.ZombieNormal;
import org.object.ZombieY;

public class World {
	
	public static World currentWorld = null;
	public static Player playerOne = null;
	
	private static long lastTime = System.nanoTime();
	
	public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public static void update() {
		float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
		lastTime = System.nanoTime();
		
		for (Sprite sprite : currentWorld.sprites) {
			sprite.update(deltaTime);
		}
		
		for (Bullet bullet : currentWorld.bullets) {
			bullet.update(deltaTime);
		}
		
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets = (ArrayList<Bullet>) currentWorld.bullets.stream().filter(e -> !e.remove).collect(Collectors.toList());
		int count = currentWorld.bullets.size() - bullets.size();
		currentWorld.bullets = bullets;
		
		spawnZombie(count);
	}
	
	public static void render(Graphics g) {
		for (Sprite sprite : currentWorld.sprites) {
			sprite.render(g);
		}
		
		for (Bullet bullet : currentWorld.bullets) {
			bullet.render(g);
		}
	}
	
	public static void spawnZombie(int count) {
		
		for (int i = 0; i < count; i++) {
			if (i % 2 == 0) {
				Random r = new Random();
				for (int j = 0; j < r.nextInt(3 - 1) + 1; j++) {
					int x = r.nextInt(580 - 10) + 10;
					int y = r.nextInt(350 - 10) + 10;
					
					World.currentWorld.sprites.add(new ZombieNormal(x, y));
				}
				
			} else {
				Random r = new Random();
				for (int j = 0; j < r.nextInt(3 - 1) + 1; j++) {
					int x = r.nextInt(580 - 10) + 10;
					int y = r.nextInt(350 - 10) + 10;
					
					World.currentWorld.sprites.add(new ZombieY(x, y));
				}
			}
		}
	}
	
}
