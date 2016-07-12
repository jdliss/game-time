package org.game;

import org.graphics.Renderer;
import org.object.Player;
import org.object.ZombieNormal;
import org.object.ZombieX;
import org.object.ZombieY;
import org.world.World;

public class Game {

	public static void main(String[] args) {
		World.currentWorld = new World();
		World.playerOne = new Player(200, 125);
		World.currentWorld.sprites.add(World.playerOne);
		
		World.currentWorld.sprites.add(new ZombieNormal(10, 10));
		World.currentWorld.sprites.add(new ZombieX(10, 0));
		World.currentWorld.sprites.add(new ZombieY(10, 40));
		World.currentWorld.sprites.add(new ZombieNormal(10, 60));
		World.currentWorld.sprites.add(new ZombieX(10, 80));
		World.currentWorld.sprites.add(new ZombieY(10, 100));
		World.currentWorld.sprites.add(new ZombieNormal(10, 130));
		World.currentWorld.sprites.add(new ZombieX(10, 160));
		World.currentWorld.sprites.add(new ZombieY(10, 190));
		World.currentWorld.sprites.add(new ZombieNormal(10, 230));
		World.currentWorld.sprites.add(new ZombieX(10, 210));
		World.currentWorld.sprites.add(new ZombieY(10, 250));
		World.currentWorld.sprites.add(new ZombieNormal(10, 280));
		World.currentWorld.sprites.add(new ZombieX(10, 310));
		World.currentWorld.sprites.add(new ZombieY(10, 330));
		World.currentWorld.sprites.add(new ZombieNormal(10, 350));
		
		World.currentWorld.sprites.add(new ZombieX(580, 10));
		World.currentWorld.sprites.add(new ZombieY(580, 0));
		World.currentWorld.sprites.add(new ZombieNormal(580, 40));
		World.currentWorld.sprites.add(new ZombieX(580, 60));
		World.currentWorld.sprites.add(new ZombieY(580, 80));
		World.currentWorld.sprites.add(new ZombieNormal(580, 100));
		World.currentWorld.sprites.add(new ZombieX(580, 130));
		World.currentWorld.sprites.add(new ZombieY(580, 160));
		World.currentWorld.sprites.add(new ZombieNormal(580, 190));
		World.currentWorld.sprites.add(new ZombieX(580, 230));
		World.currentWorld.sprites.add(new ZombieY(580, 210));
		World.currentWorld.sprites.add(new ZombieNormal(580, 230));
		World.currentWorld.sprites.add(new ZombieX(580, 250));
		World.currentWorld.sprites.add(new ZombieY(580, 280));
		World.currentWorld.sprites.add(new ZombieNormal(580, 280));
		World.currentWorld.sprites.add(new ZombieX(580, 300));
		World.currentWorld.sprites.add(new ZombieY(580, 320));
		World.currentWorld.sprites.add(new ZombieNormal(580, 340));
		World.currentWorld.sprites.add(new ZombieNormal(580, 346));
		
		World.currentWorld.sprites.add(new ZombieNormal(20, 10));
		World.currentWorld.sprites.add(new ZombieX(40, 10));
		World.currentWorld.sprites.add(new ZombieY(60, 10));
		World.currentWorld.sprites.add(new ZombieNormal(80, 10));
		World.currentWorld.sprites.add(new ZombieX(100, 10));
		World.currentWorld.sprites.add(new ZombieY(120, 10));
		World.currentWorld.sprites.add(new ZombieNormal(140, 10));
		World.currentWorld.sprites.add(new ZombieX(160, 10));
		World.currentWorld.sprites.add(new ZombieY(180, 10));
		World.currentWorld.sprites.add(new ZombieNormal(200, 10));
		World.currentWorld.sprites.add(new ZombieX(220, 10));
		World.currentWorld.sprites.add(new ZombieY(240, 10));
		World.currentWorld.sprites.add(new ZombieNormal(260, 10));
		World.currentWorld.sprites.add(new ZombieX(280, 10));
		World.currentWorld.sprites.add(new ZombieY(300, 10));
		World.currentWorld.sprites.add(new ZombieNormal(320, 10));

		World.currentWorld.sprites.add(new ZombieX(340, 10));
		World.currentWorld.sprites.add(new ZombieY(360, 10));
		World.currentWorld.sprites.add(new ZombieNormal(380, 10));
		World.currentWorld.sprites.add(new ZombieX(400, 10));
		World.currentWorld.sprites.add(new ZombieY(420, 10));
		World.currentWorld.sprites.add(new ZombieNormal(440, 10));
		World.currentWorld.sprites.add(new ZombieX(460, 10));
		World.currentWorld.sprites.add(new ZombieY(480, 10));
		World.currentWorld.sprites.add(new ZombieNormal(500, 10));
		World.currentWorld.sprites.add(new ZombieX(520, 10));
		World.currentWorld.sprites.add(new ZombieY(540, 10));
		World.currentWorld.sprites.add(new ZombieNormal(560, 10));
		World.currentWorld.sprites.add(new ZombieX(580, 10));
		World.currentWorld.sprites.add(new ZombieY(600, 10));
		World.currentWorld.sprites.add(new ZombieNormal(620, 10));
		
		Renderer.init();
	}
	
	
	
	public static void quit() {
		System.exit(0);
	}

}
