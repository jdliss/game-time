package org.object;

public class Zombie extends Mob {
	
	protected float runSpeed = 40.0f;

	public Zombie(float posX, float posY) {
		super(posX, posY);
	}

	public void goTo(float playerX, float playerY) {
		if (playerX < this.posX) {
			this.posX -= this.runSpeed;
		} else {
			this.posX += this.runSpeed;
		}
		
		if (playerY < this.posY) {
			this.posY -= this.runSpeed;
		} else {
			this.posY += this.runSpeed;
		}
	}
	

}
