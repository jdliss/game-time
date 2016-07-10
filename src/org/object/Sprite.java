package org.object;

import java.awt.Graphics;
import java.awt.Point;

import org.graphics.Renderer;

public class Sprite {
	
	public float posX = 0;
	public float posY = 0;
		
	public float width = 0;
	public float height = 0;
	
	public boolean isSolid = false;
	
	public Sprite(float a, float b) {
		this.posX = a;
		this.posY = b;
	}

	public void update(float deltaTime) {
		//
	}
	
	public void render(Graphics g) {
		//
	}
	
	public void moveX(double x) {
		this.posX += x;
	}
	
	public void moveY(double y) {
		this.posY += y;
	}
	
	protected static int findMouseX(Point p) {
		System.out.println(Renderer.scaleX);
		return (int) (p.getX() * Renderer.scaleX);
	}
	
	protected static int findMouseY(Point p) {
		System.out.println(Renderer.scaleY);
		return (int) (p.getY() * Renderer.scaleY);
	}
	
	
	
}
