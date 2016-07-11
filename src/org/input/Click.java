package org.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Click implements MouseListener {
	
	private static boolean[] currentMouse = new boolean[32];
	
	public static boolean getButton(int mouseButton) {
		boolean bool = currentMouse[mouseButton];
		currentMouse[mouseButton] = false;
		return bool;
	}
	
	public void mousePressed(MouseEvent e) {		
		currentMouse[e.getButton()] = true;
	}

	
	public void mouseReleased(MouseEvent e) {
		//
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
