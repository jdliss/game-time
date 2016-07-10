package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import org.input.Click;
import org.input.Input;
import org.world.World;

public class Player extends Mob {
	
	private float runSpeed = 80.0f;
	private static double angle = 0;
	private static double mouseX = 0;
	private static double mouseY = 0;

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
		
		if (Click.getButton(MouseEvent.BUTTON1)) {
			
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
		
		updateRotation(posX, posY);
		
		moveX(mX * deltaTime);
		moveY(mY * deltaTime);
	}
	
	private static void updateRotation(float posX, float posY){
		int centerX = (int) posX;
		int centerY = (int) posY;
		Point p = MouseInfo.getPointerInfo().getLocation();
		
		mouseX = findMouseX(p);
		mouseY = findMouseY(p);
		
		angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;
	}
	
	
	public void render(Graphics g) {		
		Graphics2D g2d = (Graphics2D) g;		
		AffineTransform transform = g2d.getTransform();

		g.setColor(Color.green);
		
		g2d.rotate(angle, posX, posY);

		g.drawRect((int) (posX - width / 2), (int) (posY - width / 2), (int)width, (int)height);
		
		g2d.setTransform(transform);

		g.drawLine((int)posX, (int)posY, (int) mouseX, (int) mouseY);
		
	}
	
}
