package org.object;

import static org.junit.Assert.*;

import org.junit.Test;

public class BulletTest {

	@Test
	public void bulletCanMoveTowardMouseDirectionX() {
		Bullet bullet = new Bullet(10, 10, 1);
		
		bullet.moveX(10);
		
		assertEquals(20.0, bullet.posX, 0);
	
	}
	
	@Test
	public void bulletCanMoveTowardMouseDirectionY() {
		Bullet bullet = new Bullet(10, 10, 1);
		
		bullet.moveY(10);
		
		assertEquals(10.0, bullet.posX, 0);
	
	}
	
}
