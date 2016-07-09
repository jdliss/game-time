package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.input.Input;
import org.world.World;

public class Player extends Mob {
	
	private float runSpeed = 80.0f;

	public Player(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
		handleInput(deltaTime);
	}
	
	private void handleInput(float deltaTime) {
		
		float mX = 0;
		float mY = 0;
		
		if (Input.getKey(KeyEvent.VK_W)) {
			mY -= runSpeed;
		}
		
		if (Input.getKey(KeyEvent.VK_S)) {
			mY += runSpeed;
		}
		
		if (Input.getKey(KeyEvent.VK_A)) {
			mX -= runSpeed;
		}
		
		if (Input.getKey(KeyEvent.VK_D)) {
			mX += runSpeed;
		}
		
		Rectangle myRect = new Rectangle(
				(int) (posX + mX * deltaTime - width / 2),
				(int) (posY + mY * deltaTime - height / 2),
				(int) width,
				(int) height);
		
		for (Sprite sprite : World.currentWorld.sprites) {
			if (sprite == this) {
				continue;
			}
			
			Rectangle otherRect = new Rectangle(
					(int) (sprite.posX + mX * deltaTime - width / 2),
					(int) (sprite.posY + mY * deltaTime - height / 2),
					(int) sprite.width,
					(int) sprite.height);
			
			if (myRect.intersects(otherRect)) {
				// die
				mX -= mX;
				mY -= mY;
			}
		}
		
		
		moveX(mX * deltaTime);
		moveY(mY * deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int) (posX - width / 2), (int) (posY - width / 2), (int)width, (int)height);
	}
	
}
