package org.game;

import org.graphics.Renderer;
import org.object.Player;
import org.object.Zombie;
import org.world.World;

public class Game {

	public static void main(String[] args) {
		Renderer.init();

		World.currentWorld = new World();
		World.playerOne = new Player(200, 125);
		World.currentWorld.sprites.add(World.playerOne);
		World.currentWorld.sprites.add(new Zombie(20, 10));
		World.currentWorld.sprites.add(new Zombie(0, 0));
		World.currentWorld.sprites.add(new Zombie(10, 0));
		World.currentWorld.sprites.add(new Zombie(80, 100));
		World.currentWorld.sprites.add(new Zombie(100, 120));
		World.currentWorld.sprites.add(new Zombie(120, 130));
		World.currentWorld.sprites.add(new Zombie(140, 140));
		World.currentWorld.sprites.add(new Zombie(160, 190));
		World.currentWorld.sprites.add(new Zombie(180, 200));
		World.currentWorld.sprites.add(new Zombie(200, 230));
		World.currentWorld.sprites.add(new Zombie(220, 20));
		World.currentWorld.sprites.add(new Zombie(100, 0));
		
	}
	
	public static void quit() {
		System.exit(0);
	}
}
