package org.world;

import static org.junit.Assert.*;

import org.junit.Test;
import org.object.Player;

public class WorldTest {

	@Test
	public void worldCanSpawnZombies() {
		World.currentWorld = new World();
		World.playerOne = new Player(300, 200);
		World.currentWorld.sprites.add(World.playerOne);
		
		assertEquals(1, World.currentWorld.sprites.size());
		
		World.spawnZombie(1);
		
		assertEquals(2, World.currentWorld.sprites.size(), 1);
	}
	
	@Test
	public void worldCanDestroyAllZombies(){
		World.currentWorld = new World();
		World.playerOne = new Player(300, 200);
		World.currentWorld.sprites.add(World.playerOne);
		
		World.spawnZombie(3);
		
		assertEquals(7, World.currentWorld.sprites.size(), 3);
		
		World.destroyZombies = true;
		
		World.update();
		
		assertEquals(7, World.currentWorld.sprites.size(), 2);
	}
	

}
