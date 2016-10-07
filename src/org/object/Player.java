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
import java.util.Iterator;

import org.graphics.Renderer;
import org.input.Click;
import org.input.Input;
import org.world.World;

public class Player extends Mob {

	private final float RUNSPEED = 90.0f;
	
	private static double angle = 0;
	
	private static double mouseX = 0;
	private static double mouseY = 0;
	private static float mX = 0;
	private static float mY = 0;
	
	public int score = 0;
	
	public boolean isDead = false;

	public Player(float posX, float posY) {
		super(posX, posY);

		width = 10;
		height = 10;
	}

	public void update(float deltaTime) {
		handleInput(deltaTime);
		handleSpriteCollision(deltaTime);
		updateRotation(posX, posY);
		mX = mX * deltaTime;
		mY = mY * deltaTime;
		handleWallCollision();
		moveX(mX);
		moveY(mY);
	}

	private void handleInput(float deltaTime) {
		if (Input.getKey(KeyEvent.VK_W)) {
			mY -= RUNSPEED;
		}

		if (Input.getKey(KeyEvent.VK_S)) {
			mY += RUNSPEED;
		}

		if (Input.getKey(KeyEvent.VK_A)) {
			mX -= RUNSPEED;
		}

		if (Input.getKey(KeyEvent.VK_D)) {
			mX += RUNSPEED;
		}

//		if (Click.getButton(MouseEvent.BUTTON1)) {
//			shoot(posX, posY);
//		}
	}
	
	private void handleSpriteCollision(float deltaTime) {
		Rectangle myRect = new Rectangle((int) (posX + mX * deltaTime - width / 2),
				(int) (posY + mY * deltaTime - height / 2), (int) width, (int) height);

		for (Iterator<Sprite> it = World.currentWorld.sprites.iterator(); it.hasNext();) {
			Sprite sprite = it.next();
			if (sprite == this) {
				continue;
			}

			Rectangle otherRect = new Rectangle((int) (sprite.posX + mX * deltaTime - width / 2),
					(int) (sprite.posY + mY * deltaTime - height / 2), (int) sprite.width, (int) sprite.height);

			if (myRect.intersects(otherRect)) {
				isDead = true;
			}
		}
	}
	
	private void handleWallCollision() {
		if (posX + width / 2 + mX > Renderer.gameWidth || posX - width / 2 + mX < 0) {
			mX -= mX;
		}
		
		if (posY + height / 2 + mY > Renderer.gameHeight || posY - height / 2 + mY < 0) {
			mY -= mY;
		}
	}

	private void updateRotation(float posX, float posY) {
		int centerX = (int) posX;
		int centerY = (int) posY;
		Point p = MouseInfo.getPointerInfo().getLocation();

		mouseX = findMouseX(p);
		mouseY = findMouseY(p);

		angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;
	}

	public void shoot(float posX, float posY) {
		World.currentWorld.bullets.add(new Bullet(posX, posY, angle));
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform transform = g2d.getTransform();

		g.setColor(Color.green);

		g2d.rotate(angle, posX, posY);
		g.fillRect((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
		g2d.setTransform(transform);

		g.setColor(Color.green);
		g.drawString("Score: " + String.valueOf(World.playerOne.score), 10, 20);
	}
}
