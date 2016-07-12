package org.object;

import java.awt.Color;
import java.awt.Graphics;

import org.world.World;

public class ZombieX extends Zombie {

	public ZombieX(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
		 goTo(World.playerOne.posX, World.playerOne.posY, deltaTime, "X");
	}
	
	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int) (posX - width / 2), (int) (posY - height / 2), (int)width, (int)height);
	}

}

