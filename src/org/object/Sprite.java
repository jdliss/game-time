package org.object;

import java.awt.Graphics;

public class Sprite {
	
	public float posX = 0;
	public float posY = 0;
	
	public float width = 0;
	public float height = 0;
	
	public boolean isSolid = false;
	
	public Sprite(float posX, float posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void update(float deltaTime) {
		//
	}
	
	public void render (Graphics g) {
		//	
	}
	
	public void moveX(int x) {
		this.posX += x;
	}
	
	public void moveY(int y) {
		this.posY += y;
	}
}
