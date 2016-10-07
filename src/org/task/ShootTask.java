package org.task;

import java.util.TimerTask;

import org.world.World;

public class ShootTask extends TimerTask {

	@Override
	public void run() {
		if (!World.rendering && !World.updating) {
			World.playerOne.shoot(World.playerOne.posX, World.playerOne.posY);	
		}
	}
}
