package tilegame;

import input.KeyManager;
import input.MouseManager;
import worlds.World;

public class Handler { // the handler control the Human Machine Interface

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}