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
		
		World.spawnZombie(1);
		
		Renderer.init();
	}
		

	
	public static void quit() {
		System.exit(0);
	}

}
