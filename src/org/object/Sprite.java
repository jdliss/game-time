package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import org.graphics.Renderer;

public abstract class Sprite {
	
	protected float posX = 0;
	protected float posY = 0;
		
	protected float width = 0;
	protected float height = 0;

	public int health = 1;
	
	public Sprite(float a, float b) {
		this.posX = a;
		this.posY = b;
	}

	public abstract void update(float deltaTime);
	
	public abstract void render(Graphics g);
	
	protected void moveX(double x) {
		this.posX += x;
	}
	
	protected void moveY(double y) {
		this.posY += y;
	}
	
	protected static int findMouseX(Point p) {
		return (int) (p.getX() * Renderer.scaleX);
	}
	
	protected static int findMouseY(Point p) {
		return (int) (p.getY() * Renderer.scaleY);
	}
	
	
	
}
