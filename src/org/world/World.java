package org.world;

import java.util.ArrayList;

import org.object.Sprite;

public class World {
	
	public static World currentWorld = null;
	
	private static long lastTime = 0;
	
	public ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public void update() {
		float deltaTime = System.nanoTime() - lastTime / 1000000000.0f;
		
		for (Sprite sprite : currentWorld.sprites) {
			sprite.update(deltaTime);
		}
	}
}
