package org.object;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Mob {

	public Player(float posX, float posY) {
		super(posX, posY);
		
		width = 10;
		height = 10;
	}
	
	public void update(float deltaTime) {
	 //
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.drawRect((int) (posX - width / 2), (int) (posY - width / 2), (int)width, (int)height);
	}
	
}
