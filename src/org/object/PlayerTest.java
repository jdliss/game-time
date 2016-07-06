package org.object;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
