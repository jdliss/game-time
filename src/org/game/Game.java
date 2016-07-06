package org.game;

import org.graphics.Renderer;
import org.world.World;

public class Game {

	public static void main(String[] args) {
		Renderer.init();
		
		World.currentWorld = new World();
	}
	
	public static void quit() {
		System.exit(0);
	}
}
