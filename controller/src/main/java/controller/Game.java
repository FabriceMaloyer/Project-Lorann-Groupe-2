package controller;

import model.database.ManageDB;
import model.gfx.Assets;
import controller.Controller;

public class Game implements Runnable {

	
	private boolean running = false;
	private Thread thread;
	public int width, height;
	public String title;
	private Handler handler;
	
	private State gameState;
	
	private void init(){
		//display = new Display(title, width, height);
		//display.getFrame().addKeyListener(keyManager);
		Assets.init();
		handler = new Handler(this);
		gameState = new GameState(handler,this);
		//menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void run(){  //slow the game to only have 60 frame per second so the game isn't too fast
		
		ManageDB.extractMapFromDataBase(0);
		System.out.println(ManageDB.getTheMapString());
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				/*tick();
				render();*/
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
