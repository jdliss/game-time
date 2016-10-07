package org.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

public class Click implements MouseListener {
	
	private Timer timer = new Timer();
	private ShootTask shot = new ShootTask();
	
	public void mousePressed(MouseEvent e) {
		timer.scheduleAtFixedRate(shot, 0, 100);
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
