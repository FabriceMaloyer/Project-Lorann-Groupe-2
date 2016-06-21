package controller;

import java.awt.Graphics;
import model.entities.creatures.Player;
import controller.Game;

public class GameState extends State {
	
	private Player player;
	public World world;
	
	public GameState(Handler handler,Game game){
		super(game);
		//player = new Player(handler, game, 100, 100);
		
		//world = new World(handler,"/worlds/world1.txt");
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
