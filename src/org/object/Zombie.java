package org.object;

import java.awt.Color;
import java.awt.Graphics;

import org.world.World;

public class Zombie extends Mob {
	
	protected float runSpeed = 40.0f;

	public Zombie(float posX, float posY) {
		super(posX, posY);
	}
	
	public void update(float deltaTime) {
		goTo(World.playerOne.posX, World.playerOne.posY, deltaTime);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.drawRect((int) (posX - width / 2), (int) (posY - width / 2), 10, 10);
	}

	public void goTo(float playerX, float playerY, float deltaTime) {
		if (playerX < this.posX) {
			posX -= runSpeed * deltaTime;
		} else {
			posX += runSpeed * deltaTime;
		}
				
		if (playerY < this.posY) {
			posY -= runSpeed * deltaTime;
		} else {
			posY += runSpeed * deltaTime;
		}
				
	}

}
