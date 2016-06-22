package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right,spell;

	public KeyManager() {
		keys = new boolean[256];// numbers of possibilies
	}

	public void tick() {
		up = keys[KeyEvent.VK_Z] || keys[KeyEvent.VK_UP]; // 2 differents keys
															// to move up
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		; // 2 differents keys to move down
		left = keys[KeyEvent.VK_Q] || keys[KeyEvent.VK_LEFT];
		; // same
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		; // same
		spell = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) { // when the key is pressed
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) { // when the key is release
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
