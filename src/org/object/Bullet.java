package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.world.World;

public class Bullet extends Sprite {
	
	protected final float RUNSPEED = 250.0f;
	
	private double xInc = 0;
	private double yInc = 0;
	
	private double angle = 0;
	
	public boolean remove = false;
	
	public Bullet(float playerX, float playerY, double angle2) {
		super(playerX, playerY);
		this.angle = angle2;
		this.posX = playerX;
		this.posY = playerY;

		width = 3;
		height = 3;
	}
	
	public void update(float deltaTime) {
		travel(deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRoundRect((int) posX, (int) posY, (int) width, (int) height, 5, 5);
	}
	
	public void travel(float deltaTime) {
		calculateInc();
		
		double mX = xInc;
		double mY = -yInc;
		
		Rectangle myRect = new Rectangle(
				(int) (posX + mX * deltaTime - width / 2),
				(int) (posY + mY * deltaTime - height / 2),
				(int) width + 1,
				(int) height + 1);
			
		for (Sprite sprite : World.currentWorld.sprites) { 
			if (sprite == World.playerOne || sprite == this) {
				continue;
			}
			
			Rectangle otherRect = new Rectangle(
					(int) (sprite.posX + mX * deltaTime - width / 2),
					(int) (sprite.posY + mY * deltaTime - height / 2),
					(int) sprite.width + 1,
					(int) sprite.height + 1);
		
			if (myRect.intersects(otherRect)) {
				sprite.health -= 1;
				if (sprite.getClass().equals(ZombieFat.class) && sprite.health == 0) {
					World.destroyZombies = true;
				}
				this.remove = true;
				World.playerOne.score += 10;
			}
		}
		
		moveX(mX * deltaTime);
		moveY(mY * deltaTime);
	}
	
	private void calculateInc() {
		xInc = RUNSPEED * Math.sin(angle);
		yInc = RUNSPEED * Math.cos(angle); 
	}
	
}
