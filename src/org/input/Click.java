package org.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import org.world.World;

public class Click implements MouseListener {
	
	private static boolean[] currentMouse = new boolean[32];
	
	private Timer timer = new Timer();
	private ShootTask shot = new ShootTask();
	
	public static boolean getButton(int mouseButton) {
		boolean bool = currentMouse[mouseButton];
		currentMouse[mouseButton] = false;
		return bool;
	}
	
	public void mousePressed(MouseEvent e) {
		timer.scheduleAtFixedRate(shot, 0, 100);
		// currentMouse[e.getButton()] = true;
	}
	
	public void mouseReleased(MouseEvent e) {
		shot.cancel();
		shot = new ShootTask();
	}

	public void mouseClicked(MouseEvent e) {
		//
	}

		
	public void mouseEntered(MouseEvent e) {
		//
	}

	
	public void mouseExited(MouseEvent e) {
		//
	}

}
