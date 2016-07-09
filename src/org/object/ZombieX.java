package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import org.world.World;

public class ZombieX extends Mob {
	
	protected float runSpeed = 70.0f;
	
	private double xInc = 0;
	private double yInc = 0;
	

	public ZombieX(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
		 goTo(World.playerOne.posX, World.playerOne.posY, deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawRect((int) (posX - width / 2), (int) (posY - height / 2), (int)width, (int)height);
	}

	public void goTo(float playerX, float playerY, float deltaTime) {
		calculateInc(playerX, playerY);
		
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
	
	private void calculateInc(float playerX, float playerY) {
		float distanceX = 0;
		float distanceY = 0;
		
		Random r = new Random();
		int Low = 0;
		int High = 2;
		
		distanceX = Math.abs(this.posX - playerX);
		distanceY = Math.abs(this.posY - playerY);
		double alpha = Math.atan(distanceY / distanceX);
		
		xInc = runSpeed * Math.cos(alpha + r.nextInt(High-Low) + Low);
		yInc = runSpeed * Math.sin(alpha + r.nextInt(High-Low) + Low); 
	}

}

