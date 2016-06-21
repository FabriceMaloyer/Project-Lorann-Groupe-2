/*package dev.tilegame.entities.creatures;		No implemented because no map

import java.awt.Graphics;

import dev.tilegame.Game;
import dev.tilegame.Handler;
import dev.tilegame.gfx.Assets;

public class Monster extends Creature {
	
	private boolean isPlayerAround;
	private Game game;
	private Player player;

	public Monster(Handler handler, Game game, float x, float y, Player player) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.width = 64;
		this.player = player;
	}

	@Override
	public void tick() {
		aiMonster();
		move();	//manage collisions
	}

	public void aiMonster() {
		xMove = 0;
		yMove = 0;
		
		if(player.getX()-getX() <= 1 || player.getX()-getX()>=-1|| player.getY()-getY()<=1 || player.getY()-getY()>= -1){
			isPlayerAround = true;
			} //if the player is near the monster, boolean isPlayerAround = true, else isPlayerAround = false
		else {
			isPlayerAround = false;
		}
		if(!isPlayerAround) { //if the player isn't near the monster he moves
			int initialPosition = (int) getX();
        	if(getX() == initialPosition+2 || getX() == initialPosition-2)
            	speed *= -1;
        	this.xMove += (int) speed;
    	}
		if(isPlayerAround) { //if the player is around the monster, the monster follows him
			if(player.getX()>getX()) 
				this.xMove++;
			if(player.getX()<getX())
				this.xMove--;
			if(player.getY()<getY())
				this.yMove--;
			if(player.getY()>getY())
				this.yMove++;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.monster_1, (int) x, (int) y, width, height, null);
	}
}*/ 