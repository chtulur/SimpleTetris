package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public static boolean upPressed, downPressed, leftPressed, rightPressed;


	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		switch(code) {
		//normal WASD is commented out, because I'm using an abomination.
		//case KeyEvent.VK_W:
		case KeyEvent.VK_G:
		case KeyEvent.VK_UP:
			upPressed = true;
			break;
		//case KeyEvent.VK_A:
		case KeyEvent.VK_D:
		case KeyEvent.VK_LEFT:
			leftPressed = true;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			downPressed = true;
			break;
		//case KeyEvent.VK_D:
		case KeyEvent.VK_T:
		case KeyEvent.VK_RIGHT:
			rightPressed = true;
			break;
		}
	}
}
