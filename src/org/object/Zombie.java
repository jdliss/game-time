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

	public void goTo(float playerX, float playerY, float deltaTime, String zombieVersion) {
		if (zombieVersion == "Normal") {
			calculateIncNormal(playerX, playerY);
		} else {
			calculateIncXandY(playerX, playerY, "Axis");
		}
		moveZombie(playerX, playerY, deltaTime);
	}
	
	private void moveZombie(float playerX, float playerY, float deltaTime) {
		double mX = 0;
		double mY = 0;
				
				
		if (this.posX > playerX) {
			mX = -xInc * deltaTime;
		} else {
			mX = xInc * deltaTime;
			
		}
		
		if (this.posY > playerY) {
			mY = -yInc * deltaTime;			
		} else {
			mY = yInc * deltaTime;
		}
		
		moveX(mX);
		moveY(mY);
	}
	
	private void calculateIncXandY(float playerX, float playerY, String zombieType) {
		float distanceX = calculateDist(this.posX, playerX);
		float distanceY = calculateDist(this.posY, playerY);
		double alpha = calculateAlpha(distanceX, distanceY);
		
		Random r = new Random();
		int randomInt = r.nextInt(2);
		
		if (zombieType == "Axis") {
			setIncrements(alpha + randomInt);
		} else {
			setIncrements(alpha - randomInt);
		}
	}
	
	private void calculateIncNormal(float playerX, float playerY) {
		float distanceX = calculateDist(this.posX, playerX);
		float distanceY = calculateDist(this.posY, playerY);
		
		double alpha = calculateAlpha(distanceX, distanceY);
		
		setIncrements(alpha);
	}
	
	private void setIncrements(double alpha) {
		xInc = RUNSPEED * Math.cos(alpha);
		yInc = RUNSPEED * Math.sin(alpha);
	}
	
	private double calculateAlpha(float distX, float distY) {
		return Math.atan(distY / distX);
	}
	
	private float calculateDist(float thisCoord, float playerCoord) {
		return Math.abs(thisCoord - playerCoord);
	}

}

