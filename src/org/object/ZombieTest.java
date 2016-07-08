package org.object;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZombieTest {

	@Test
	public void testHasPosition() {
		Zombie zombie = new Zombie(100, 100);
		
		assertEquals(100, zombie.posX, 0);
		assertEquals(100, zombie.posY, 0);
	}
	
	@Test
	public void testMovesX() {
		Zombie zombie = new Zombie(100, 100);
		
		zombie.moveX((int)zombie.runSpeed);
		
		assertEquals(140, zombie.posX, 0);
		assertEquals(100, zombie.posY, 0);
	}
	
	@Test
	public void testMovesY() {
		Zombie zombie = new Zombie(100, 100);
		
		zombie.moveY((int)zombie.runSpeed);
		
		assertEquals(100, zombie.posX, 0);
		assertEquals(140, zombie.posY, 0);
	}
	
	@Test
	public void testMovesToward45Degree() {
		Zombie zombie = new Zombie(20, 20);
		Player player = new Player(0, 0);
				
		zombie.goTo(player.posX, player.posY, 1);
		
		assertEquals(0, zombie.posX, 0);
		assertEquals(0, zombie.posY, 0);
	}
	
	@Test
	public void testMovesToward30Degree() {
		Zombie zombie = new Zombie((float) Math.sqrt(3), 1.0f);
		Player player = new Player(0, 0);
				
		zombie.goTo(player.posX, player.posY, 1);
		
		assertEquals(0, zombie.posX, 0);
		assertEquals(0, zombie.posY, 0);
	}
	
	
	@Test
	public void testMovesTowardWeirdDegree() {
		Zombie zombie = new Zombie(60, 80);
		Player player = new Player(200, 125);
				
		zombie.goTo(player.posX, player.posY, 1);
		
		assertEquals(0, zombie.posX, 0);
		assertEquals(0, zombie.posY, 0);
	}
	
}
	
//	@Test
//	public void testMovesTowardPlayerNegative() {
//		Zombie zombie = new Zombie(20, 20);
//		Player player = new Player(100, 100);
//		
//		int newPosX = (int) (zombie.posX + zombie.runSpeed);
//		int newPosY = (int) (zombie.posY + zombie.runSpeed);
//		
//		zombie.goTo(player.posX, player.posY);
//		
//		assertEquals(newPosX, zombie.posX, 0);
//		assertEquals(newPosY, zombie.posY, 0);
//	}
//	
//	@Test
//	public void testMovesTowardPlayerMixed() {
//		Zombie zombie = new Zombie(20, 100);
//		Player player = new Player(100, 20);
//		
//		int newPosX = (int) (zombie.posX + zombie.runSpeed);
//		int newPosY = (int) (zombie.posY - zombie.runSpeed);
//		
//		zombie.goTo(player.posX, player.posY);
//		
//		assertEquals(newPosX, zombie.posX, 0);
//		assertEquals(newPosY, zombie.posY, 0);
//	}
	
//	@Test
//	public void testUpdatesPathToMoveTowardPlayer() {
//		Zombie zombie = new Zombie(0, 0);
//		Player player = new Player(80, 80);
//		
//		zombie.goTo(player.posX, player.posY);
//		player.moveX(100);
//		// player -> 90, 80
//		zombie.goTo(player.posX, player.posY);
//		
//		
//	}


