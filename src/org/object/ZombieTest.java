package org.object;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZombieTest {

	@Test
	public void testHasPosition() {
		Zombie zombie = new ZombieNormal(100, 100);
		
		assertEquals(100, zombie.posX, 0);
		assertEquals(100, zombie.posY, 0);
	}
	
	@Test
	public void testMovesToward45Degree() {
		Zombie zombie = new ZombieNormal(20, 20);
		Player player = new Player(0, 0);
				
		zombie.goTo(player.posX, player.posY, 1, "Normal");
		
		assertEquals(-30, zombie.posX, 5);
		assertEquals(-30, zombie.posY, 5);
	}
	
	@Test
	public void testMovesToward30Degree() {
		Zombie zombie = new ZombieNormal((float) Math.sqrt(3), 1.0f);
		Player player = new Player(0, 0);
				
		zombie.goTo(player.posX, player.posY, 1, "Normal");
		
		assertEquals(-59, zombie.posX, 1);
		assertEquals(-34, zombie.posY, 1);
	}
	
	@Test
	public void testMovesTowardWeirdDegree() {
		Zombie zombie = new ZombieNormal(60, 80);
		Player player = new Player(200, 125);
				
		zombie.goTo(player.posX, player.posY, 1, "Normal");
		
		assertEquals(126, zombie.posX, 1);
		assertEquals(101, zombie.posY, 1);
	}
	
}
	



