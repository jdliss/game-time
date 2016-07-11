package org.object;

import java.awt.Graphics;
import java.util.Random;

public abstract class Zombie extends Mob {
		
	private double xInc = 0;
	private double yInc = 0;
	

	public Zombie(float posX, float posY) {
		super(posX, posY);
	}
	
	public abstract void update(float deltaTime);
	
	public abstract void render(Graphics g);

	public void goTo(float playerX, float playerY, float deltaTime) {
		calculateNormalInc(playerX, playerY);
		
		if (this.posX > playerX) {
			moveX(-xInc * deltaTime); 
		} else {
			moveX(xInc * deltaTime);
		}
		
		if (this.posY > playerY) {
			moveY(-yInc * deltaTime);
		} else {
			moveY(yInc * deltaTime);
		}
	}
	
	private void calculateNormalInc(float playerX, float playerY) {
		float distanceX = calculateDist(this.posX, playerX);
		float distanceY = calculateDist(this.posY, playerY);
		
		double alpha = calculateAlpha(distanceX, distanceY);
		
		xInc = RUNSPEED * Math.cos(alpha);
		yInc = RUNSPEED * Math.sin(alpha); 
	}
	
	private double calculateAlpha(float distX, float distY) {
		return Math.atan(distX / distY);
	}
	
	private float calculateDist(float thisCoord, float playerCoord) {
		Random r = new Random();
		int randomInt = r.nextInt(200 - -200) + -200;
		
		return Math.abs(thisCoord - playerCoord + randomInt);
	}

}

