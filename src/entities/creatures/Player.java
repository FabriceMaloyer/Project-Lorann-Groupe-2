package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;
import gfx.Assets;

public class Player extends Creature {

	private Game game;
	private Monster monster;
	public static float xMonster;
	public static float yMonster;
	
	
	public Player(Handler handler,Game game, float x, float y, Monster monster) {
		super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;
		this.monster = monster;
	}

	public void getPlayerPos(){
		Purse.xPlayer = getX();
		Purse.yPlayer = getY();
	}
	
	@Override
	public void tick() {
		getInput();
		move();
	}
	
	
	
	public void getInput(){
		xMove = 0;
		yMove = 0;
		if(!game.getKeyManager().spell){ // Stop move of player when shooting
			if(game.getKeyManager().up)
				yMove = -speed;
			if(game.getKeyManager().down)
				yMove = speed;
			if(game.getKeyManager().left)
				xMove = -speed;
			if(game.getKeyManager().right)
				xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		

		if(game.getKeyManager().up && game.getKeyManager().left){
			g.drawImage(Assets.player_UL, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().up && game.getKeyManager().right){
			g.drawImage(Assets.player_UR, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().down && game.getKeyManager().left){
			g.drawImage(Assets.player_DL, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().down && game.getKeyManager().right){
			g.drawImage(Assets.player_DR, (int) x, (int) y, width, height, null);}
		
		else if(game.getKeyManager().up){
			g.drawImage(Assets.player_U, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().down){
			g.drawImage(Assets.player_D, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().left){
			g.drawImage(Assets.player_L, (int) x, (int) y, width, height, null);}
		else if(game.getKeyManager().right){
			g.drawImage(Assets.player_R, (int) x, (int) y, width, height, null);}
		
		else g.drawImage(Assets.player_U, (int) x, (int) y, width, height, null);  // Default render
		
		
		//g.setColor(Color.red); // Make the hitbox red
		//g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), width, height); // Set the show hitbox
		if(getX()-xMonster<=56 && getX()-xMonster>=-56 && getY()-yMonster<=56 && getY()-yMonster>=-56) {
			g.drawImage(Assets.nothing, (int) x, (int) y, width, height, null);
			System.out.println("You are DEAAAAD !");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
}