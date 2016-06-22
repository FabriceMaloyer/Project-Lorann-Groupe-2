package tilegame;

import DAODB.ManageDB;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import gfx.Assets;
import input.KeyManager;
import input.MouseManager;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;
	private Handler handler;

	// States
	private State gameState;
	private State menuState;

	// Input
	private KeyManager keyManager;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init() { // start of the game

		// ManageDB.extractMapFromDataBase(0);

		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		handler = new Handler(this);

		gameState = new GameState(handler, this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}

	private void tick() { // used to synchronize game logic and timing
		keyManager.tick();

		if (State.getState() != null) // state of our thread
			State.getState().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!

		if (State.getState() != null)
			State.getState().render(g);

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() { // slow the game to only have 60 frame per second so the
						// game isn't too fast

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				//System.out.println("Ticks and Frames: " + ticks);
				System.out.println("Score : " + entities.creatures.Purse.score);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
