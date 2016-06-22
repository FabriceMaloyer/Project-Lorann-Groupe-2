package states;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;

public abstract class State { // we use this to work with thread

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	// CLASS

	protected Game game;

	public State(Game game) {
		this.game = game;
	}

	public abstract void tick(); // used to synchronize game logic and timing

	public abstract void render(Graphics g); // to use our spritesheet

}

