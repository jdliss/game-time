package org.object;

import java.awt.Color;
import java.awt.Graphics;

import org.world.World;

public class Zombie extends Mob {
	
	protected float runSpeed = 30.0f;
	
	private double xInc = 0;
	private double yInc = 0;

	public Zombie(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
		 goTo(World.playerOne.posX, World.playerOne.posY, deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect((int) (posX - width / 2), (int) (posY - height / 2), 10, 10);
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
		
		distanceX = Math.abs(this.posX - playerX);
		distanceY = Math.abs(this.posY - playerY);
		double alpha = Math.atan(distanceY / distanceX);
		
		yInc = runSpeed * Math.sin(alpha); 
		xInc = runSpeed * Math.cos(alpha);
	}

}

