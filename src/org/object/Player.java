package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.input.Input;

public class Player extends Mob {
	
	private float runSpeed = 80.0f;

	public Player(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
		if (Input.getKey(KeyEvent.VK_W)) {
			moveY(-runSpeed * deltaTime);
		}
		
		if (Input.getKey(KeyEvent.VK_S)) {
			moveY(runSpeed * deltaTime);
		}
		
		if (Input.getKey(KeyEvent.VK_A)) {
			moveX(-runSpeed * deltaTime);
		}
		
		if (Input.getKey(KeyEvent.VK_D)) {
			moveX(runSpeed * deltaTime);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int) (posX - width / 2), (int) (posY - width / 2), (int)width, (int)height);
	}
	
}
