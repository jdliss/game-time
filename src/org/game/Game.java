package org.game;

import java.util.Random;

import org.graphics.Renderer;
import org.object.Player;
import org.object.ZombieNormal;
import org.world.World;

public class Game {

	public static void main(String[] args) {
		World.currentWorld = new World();
		World.playerOne = new Player(200, 125);
		World.currentWorld.sprites.add(World.playerOne);
		
		spawnInitialZombies();
		
		Renderer.init();
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

}
