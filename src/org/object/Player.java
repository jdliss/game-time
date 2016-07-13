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

import org.input.Click;
import org.input.Input;
import org.world.World;

public class Player extends Mob {

	private final float RUNSPEED = 80.0f;
	
	private static double angle = 0;
	
	private static double mouseX = 0;
	private static double mouseY = 0;
	
	public int score = 0;
	
	public boolean isDead = false;

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

		if (Click.getButton(MouseEvent.BUTTON1)) {
			shoot(posX, posY);
		}

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
//				// die
//				mX -= mX;
//				mY -= mY;
				isDead = true;
			}
		}

		updateRotation(posX, posY);

		moveX(mX * deltaTime);
		moveY(mY * deltaTime);
	}

	private void updateRotation(float posX, float posY) {
		int centerX = (int) posX;
		int centerY = (int) posY;
		Point p = MouseInfo.getPointerInfo().getLocation();

		mouseX = findMouseX(p);
		mouseY = findMouseY(p);

		angle = Math.atan2(centerY - mouseY, centerX - mouseX) - Math.PI / 2;
	}

	private void shoot(float posX, float posY) {
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
