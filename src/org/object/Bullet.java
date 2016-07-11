package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

import org.world.World;

public class Bullet extends Sprite {
	protected final float RUNSPEED = 250.0f;
	
	private double xInc = 0;
	private double yInc = 0;
	private double angle = 0;
	
	public Bullet(float playerX, float playerY, double angle2) {
		super(playerX, playerY);
		this.angle = angle2;
		this.posX = playerX;
		this.posY = playerY;
		
		width = 2;
		height = 2;
	}
	
	public void update(float deltaTime) {
		travel(deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawRoundRect((int) posX, (int) posY, (int) width, (int) height, 5, 5);
	}
	
	public void travel(float deltaTime) {
		calculateInc();
		
		double mX = xInc;
		double mY = -yInc;
		
		Rectangle myRect = new Rectangle(
				(int) (posX + mX * deltaTime - width / 2),
				(int) (posY + mY * deltaTime - height / 2),
				(int) width,
				(int) height);
			
			for (Iterator<Sprite> it = World.currentWorld.sprites.iterator(); it.hasNext();){
				Sprite sprite = it.next();
				if (sprite == World.playerOne || sprite == this) {
					continue;
				}
				Rectangle otherRect = new Rectangle(
						(int) (sprite.posX + mX * deltaTime - width / 2),
						(int) (sprite.posY + mY * deltaTime - height / 2),
						(int) sprite.width,
						(int) sprite.height);
			
				if (myRect.intersects(otherRect)) {
					it.remove();
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
