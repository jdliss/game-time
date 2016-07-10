package org.object;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Mob {
	protected float runSpeed = 250.0f;
	
	private double xInc = 0;
	private double yInc = 0;
	private double angle = 0;
	
	public Bullet(float playerX, float playerY, double angle2) {
		super(playerX, playerY);
		this.angle = angle2;
		this.posX = playerX;
		this.posY = playerY;
	}

	
	public void update(float deltaTime) {
		travel(deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawRoundRect((int) posX, (int) posY, 2, 2, 5, 5);
	}
	
	public void travel(float deltaTime) {
		calculateInc();
		
		if (angle < 90 || angle > 270 ) {
			moveX(xInc * deltaTime); 
		} else {
			moveX(-xInc * deltaTime);
		}
		
		if (angle > 0 || angle < 180) {
			moveY(-yInc * deltaTime);
		} else {
			moveY(yInc * deltaTime);
		}
			
	}
	
	private void calculateInc() {
		xInc = runSpeed * Math.sin(angle);
		yInc = runSpeed * Math.cos(angle); 
	}
	
}
