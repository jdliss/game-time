package org.object;

import java.awt.Color;
import java.awt.Graphics;

import org.world.World;

public class Zombie extends Mob {
	
	protected float runSpeed = 25.0f;

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
		
		float distanceX = 0;
		float distanceY = 0;
		
	
		distanceX = Math.abs(this.posX - playerX);
	 
		distanceY = Math.abs(this.posY - playerY);
		
		
		System.out.println(distanceX);
		System.out.println(distanceY);
		
		double alpha = Math.atan(distanceY / distanceX);
		
		double yInc = runSpeed * Math.sin(alpha); 
		double xInc = runSpeed * Math.cos(alpha);
	
		if (this.posX > playerX) {
			this.posX -= (xInc * deltaTime); 
		} else {
			this.posX += (xInc * deltaTime);
		}
		
		if (this.posY > playerY) {
			this.posY -= (yInc * deltaTime);
		} else {
			this.posY += (yInc * deltaTime);
		}
		
		
	}

}

