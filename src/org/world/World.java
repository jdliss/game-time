package org.world;

import java.awt.Graphics;
import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.concurrent.CopyOnWriteArrayList;

import org.object.Bullet;
import org.object.Player;
import org.object.Sprite;

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
		
	}
	
	public static void render(Graphics g) {
		for (Sprite sprite : currentWorld.sprites) {
			sprite.render(g);
		}
		
		for (Bullet bullet : currentWorld.bullets) {
			bullet.render(g);
		}
	}
}
