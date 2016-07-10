//package org.object;
//
//import java.awt.Graphics;
//
//import org.world.World;
//
//public class Bullet extends Mob {
//	
//	protected float runSpeed = 100.0f;
//	
//	private double xInc = 0;
//	private double yInc = 0;
//	
//	public void update(float deltaTime) {
//		travel(directionX, directionY, deltaTime);
//	}
//	
//	public void render(Graphics g){
//		
//	}
//	
//	public void travel(float directionX, float directionY, float deltaTime) {
//		calculateInc(directionX, directionY);
//		
//		if (World.playerOne.posX > directionX) {
//			moveX(-xInc * deltaTime); 
//		} else {
//			moveX(xInc * deltaTime);
//		}
//		
//		if (World.playerOne.posY > directionY) {
//			moveY(-yInc * deltaTime);
//		} else {
//			moveY(yInc * deltaTime);
//		}
//			
//	}
//	
//	private void calculateInc(float directionX, float directionY) {
//		float distanceX = 0;
//		float distanceY = 0;
//		
//		distanceX = Math.abs(directionX - World.playerOne.posX );
//		distanceY = Math.abs(directionY - World.playerOne.posY);
//		
//		double alpha = Math.atan(distanceY / distanceX);
//		
//		xInc = runSpeed * Math.cos(alpha);
//		yInc = runSpeed * Math.sin(alpha); 
//	}
//	
//}
