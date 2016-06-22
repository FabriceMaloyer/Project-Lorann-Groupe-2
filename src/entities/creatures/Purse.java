package entities.creatures;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;
import gfx.Assets;
import entities.creatures.Player;

public class Purse extends Creature {
	
	private Game game;
	private Player player;
	private boolean isItemAvailable = true;
	public static int score;
	public static float xPlayer;
	public static float yPlayer;

	public Purse(Handler handler, Game game, float x, float y, Player player) {
		super(handler, x, y, Purse.DEFAULT_CREATURE_WIDTH, Purse.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 60;
		bounds.width = 60;
		this.player = player;
	}
	
	

	@Override
	public void tick() {
		PickPurse();
	}
	
	private void PickPurse() {
		if(getX()-xPlayer<=54 && getX()-xPlayer>=-54 && getY()-yPlayer<=54 && getY()-yPlayer>=-54 && isItemAvailable == true){
			isItemAvailable = false;
			score += 100;
		}
	}

	@Override
	public void render(Graphics g) {
		if(isItemAvailable == true)
		g.drawImage(Assets.purse, (int) x, (int) y, width, height, null);
		else{
			g.drawImage(Assets.nothing, (int) x, (int) y, width, height, null);
		}
	}
}