package entities.creatures;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;
import gfx.Assets;

public class Monster extends Creature {
	
	private boolean isPlayerAround;
	private Game game;
	private Player player;
	public static int MonsterDead = 0;

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
		CheckMonsterAlive();
		move();	//manage collisions
	}
	
	public void getMonsterPos(){
		Player.xMonster = getX();
		Player.yMonster = getY();
		Spell.xMonster = getX();
		Spell.yMonster = getY();
	}
	
	public void CheckMonsterAlive(){
		if(MonsterDead == 1){
			x = 400;
			y = 400;
		}
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
			if(player.getX()>=getX()) 
				this.xMove++;
			if(player.getX()<=getX())
				this.xMove--;
			if(player.getY()<=getY())
				this.yMove--;
			if(player.getY()>=getY())
				this.yMove++;
		}
	}
	


	@Override
	public void render(Graphics g) {
		if(MonsterDead == 0)
		g.drawImage(Assets.monster_2, (int) x, (int) y, width, height, null);
	}
}