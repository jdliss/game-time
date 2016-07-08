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
		
		World.currentWorld.sprites.add(new Zombie(10, 10));
		World.currentWorld.sprites.add(new Zombie(10, 0));
		World.currentWorld.sprites.add(new Zombie(10, 40));
		World.currentWorld.sprites.add(new Zombie(10, 60));
		World.currentWorld.sprites.add(new Zombie(10, 80));
		World.currentWorld.sprites.add(new Zombie(10, 100));
		World.currentWorld.sprites.add(new Zombie(10, 130));
		World.currentWorld.sprites.add(new Zombie(10, 160));
		World.currentWorld.sprites.add(new Zombie(10, 190));
		World.currentWorld.sprites.add(new Zombie(10, 230));
		World.currentWorld.sprites.add(new Zombie(10, 210));
		World.currentWorld.sprites.add(new Zombie(10, 250));
		World.currentWorld.sprites.add(new Zombie(10, 280));
		World.currentWorld.sprites.add(new Zombie(10, 310));
		World.currentWorld.sprites.add(new Zombie(10, 330));
		World.currentWorld.sprites.add(new Zombie(10, 350));		
		
		World.currentWorld.sprites.add(new Zombie(580, 10));
		World.currentWorld.sprites.add(new Zombie(580, 0));
		World.currentWorld.sprites.add(new Zombie(580, 40));
		World.currentWorld.sprites.add(new Zombie(580, 60));
		World.currentWorld.sprites.add(new Zombie(580, 80));
		World.currentWorld.sprites.add(new Zombie(580, 100));
		World.currentWorld.sprites.add(new Zombie(580, 130));
		World.currentWorld.sprites.add(new Zombie(580, 160));
		World.currentWorld.sprites.add(new Zombie(580, 190));
		World.currentWorld.sprites.add(new Zombie(580, 230));
		World.currentWorld.sprites.add(new Zombie(580, 210));
		World.currentWorld.sprites.add(new Zombie(580, 230));
		World.currentWorld.sprites.add(new Zombie(580, 250));
		World.currentWorld.sprites.add(new Zombie(580, 280));
		World.currentWorld.sprites.add(new Zombie(580, 280));
		World.currentWorld.sprites.add(new Zombie(580, 300));
		World.currentWorld.sprites.add(new Zombie(580, 320));
		World.currentWorld.sprites.add(new Zombie(580, 340));
		World.currentWorld.sprites.add(new Zombie(580, 346));

		
	}
	
	public static void quit() {
		System.exit(0);
	}
}
