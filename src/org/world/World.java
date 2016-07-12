package org.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.object.Bullet;
import org.object.Player;
import org.object.Sprite;
import org.object.ZombieNormal;
import org.object.ZombieX;
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
		currentWorld.bullets = bullets;
		
		
	}
	
	public static void render(Graphics g) {
		for (Sprite sprite : currentWorld.sprites) {
			sprite.render(g);
		}
		
		for (Bullet bullet : currentWorld.bullets) {
			bullet.render(g);
		}
	}
	
	public static void spawnZombie() {
		
		World.currentWorld.sprites.add(new ZombieNormal(10, 10));
		World.currentWorld.sprites.add(new ZombieX(600, 0));
		World.currentWorld.sprites.add(new ZombieY(0, 375));
		World.currentWorld.sprites.add(new ZombieY(600, 375));
	}
	
}
