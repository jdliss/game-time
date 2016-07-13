package org.object;

import java.awt.Color;
import java.awt.Graphics;

import org.world.World;

public class ZombieFat extends Zombie {
	
	public ZombieFat(float posX, float posY) {
		super(posX, posY);
		
		width = 25;
		height = 25;
		health = 4;
	}

	
	public void update(float deltaTime) {
		goTo(World.playerOne.posX, World.playerOne.posY, deltaTime, "Normal");
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) (posX - width / 2), (int) (posY - height / 2), (int)width, (int)height);
	}
	

}
