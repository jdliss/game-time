package org.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Random;

import org.world.World;

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
		} else if (zombieVersion == "X") {
			calculateIncXandY(playerX, playerY, "X");
		} else {
			calculateIncXandY(playerX, playerY, "Y");
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
		
//		Rectangle myRect = new Rectangle(
//				(int) (posX + mX * deltaTime - width / 2),
//				(int) (posY + mY * deltaTime - height / 2),
//				(int) width,
//				(int) height);
//			
//			for (Iterator<Bullet> it = World.currentWorld.bullets.iterator(); it.hasNext();){
//				Bullet bullet = it.next();
//				
//				Rectangle otherRect = new Rectangle(
//						(int) (bullet.posX + mX * deltaTime - width / 2),
//						(int) (bullet.posY + mY * deltaTime - height / 2),
//						(int) bullet.width,
//						(int) bullet.height);
//			
//				if (myRect.intersects(otherRect)) {
//					it.remove();
//				}
//			}
		
		moveX(mX);
		moveY(mY);
	}
	
	private void calculateIncXandY(float playerX, float playerY, String zombieType) {
		float distanceX = calculateDist(this.posX, playerX, false);
		float distanceY = calculateDist(this.posY, playerY, false);
		double alpha = calculateAlpha(distanceX, distanceY);
		
		Random r = new Random();
		int randomInt = r.nextInt(2);
		
		if (zombieType == "X") {
			setIncrements(alpha + randomInt);
		} else {
			setIncrements(alpha - randomInt);
		}
	}
	
	private void calculateIncNormal(float playerX, float playerY) {
		float distanceX = calculateDist(this.posX, playerX, true);
		float distanceY = calculateDist(this.posY, playerY, true);
		
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
	
	private float calculateDist(float thisCoord, float playerCoord, boolean needsRandom) {
		int randomInt = 0;
		if (needsRandom) {
			Random r = new Random();
			randomInt = r.nextInt(400) + -200;			
		}
		
		return Math.abs(thisCoord - playerCoord + randomInt);
	}

}

