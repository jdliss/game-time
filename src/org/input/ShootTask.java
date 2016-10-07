package org.input;

import java.util.TimerTask;

import org.world.World;

public class ShootTask extends TimerTask {

	@Override
	public void run() {
//		System.out.println("Shooting...");
		World.playerOne.shoot(World.playerOne.posX, World.playerOne.posY);
	}
}
