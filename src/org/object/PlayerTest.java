package org.object;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.world.World;

public class PlayerTest {

	@Test
	public void testPlayerHasPosition() {
		Player player = new Player(100, 100);
		
		assertEquals(100, player.posX, 0);
		assertEquals(100, player.posY, 0);
	}
	
	@Test
	public void testPlayerMovesX() {
		Player player = new Player(100, 100);
		
		player.moveX(10);
		
		assertEquals(100, player.posY, 0);		
		assertEquals(110, player.posX, 0);
	}
	
	@Test
	public void testPlayerMovesY() {
		Player player = new Player(100, 100);
		
		player.moveY(10);
		
		assertEquals(100, player.posX, 0);
		assertEquals(110, player.posY, 0);
	}
	
	@Test
	public void testPlayerCanShoot(){
		Player player = new Player(100, 100);
		World.currentWorld = new World();
		
		int bulletsFired = World.currentWorld.bullets.size();
		
		assertEquals(0, bulletsFired);
		
		player.shoot(player.posX, player.posY);
		
		assertEquals(1, World.currentWorld.bullets.size(), 0);
	
	}
	
	@Test
	public void zombieCanKillPlayer() {
		World.currentWorld = new World();
		World.playerOne = new Player(300, 200);
		World.currentWorld.sprites.add(World.playerOne);
		World.currentWorld.sprites.add(new ZombieAxis(300,200));
			
		assertEquals(false, World.playerOne.isDead);
			
		World.update();
			
		assertEquals(true, World.playerOne.isDead);
			
		
	}

}
