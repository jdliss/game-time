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
	public void testMovesTowardPlayerPositive() {
		Zombie zombie = new Zombie(100, 100);
		Player player = new Player(20, 20);
		
		int newPosX = (int) (zombie.posX - zombie.runSpeed);
		int newPosY = (int) (zombie.posY - zombie.runSpeed);
		
		zombie.goTo(player.posX, player.posY);
		
		assertEquals(newPosX, zombie.posX, 0);
		assertEquals(newPosY, zombie.posY, 0);
	}
	
	@Test
	public void testMovesTowardPlayerNegative() {
		Zombie zombie = new Zombie(20, 20);
		Player player = new Player(100, 100);
		
		int newPosX = (int) (zombie.posX + zombie.runSpeed);
		int newPosY = (int) (zombie.posY + zombie.runSpeed);
		
		zombie.goTo(player.posX, player.posY);
		
		assertEquals(newPosX, zombie.posX, 0);
		assertEquals(newPosY, zombie.posY, 0);
	}
	
	@Test
	public void testMovesTowardPlayerMixed() {
		Zombie zombie = new Zombie(20, 100);
		Player player = new Player(100, 20);
		
		int newPosX = (int) (zombie.posX + zombie.runSpeed);
		int newPosY = (int) (zombie.posY - zombie.runSpeed);
		
		zombie.goTo(player.posX, player.posY);
		
		assertEquals(newPosX, zombie.posX, 0);
		assertEquals(newPosY, zombie.posY, 0);
	}
	

}
