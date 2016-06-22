package entities.creatures;

import java.awt.Graphics;

import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;

 

public class Spell extends Creature{
	
	private Game game;
	private Player player;
	
	public static float xSpell;
	public static float ySpell;
	
	public static float xMonster;
	public static float yMonster;
	
	private boolean spellALIVE;
	private int SpellDirection;

public Spell(Handler handler, Game game, float x, float y, Player player) {
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
	move();
	SpellCast();
}



public void SpellCast(){
	//System.out.println("X : " + x + "   Y : " + y + "     Move X : " + xMove + "   Move Y : " + yMove);
	if(game.getKeyManager().spell){
		if(game.getKeyManager().up){
			SpellDirection = 0;
			x=player.getX();
			y=player.getY()-64;}
		if(game.getKeyManager().down){
			SpellDirection = 4;
			x=player.getX();
			y=player.getY()+64;}
		if(game.getKeyManager().left){
			SpellDirection = 2;
			x=player.getX()-64;
			y=player.getY();}
		if(game.getKeyManager().right){
			SpellDirection = 6;
			x=player.getX()+64;
			y=player.getY();}
		
		if(game.getKeyManager().up && game.getKeyManager().left){
			SpellDirection = 1;
			x=player.getX()-64;
			y=player.getY()-64;}
		if(game.getKeyManager().up && game.getKeyManager().right){
			SpellDirection = 7;
			x=player.getX()+64;
			y=player.getY()-64;}
		if(game.getKeyManager().down && game.getKeyManager().left){
			SpellDirection = 3;
			x=player.getX()-64;
			y=player.getY()+64;}
		if(game.getKeyManager().down && game.getKeyManager().right){
			SpellDirection = 5;
			x=player.getX()+64;
			y=player.getY()+64;
		}
		
		if(game.getKeyManager().spell && spellALIVE == false){
			spellALIVE = true;
		}
	}
	
	if(x-xMonster<=54 && x-xMonster>=-54 && y-yMonster<=54 && y-yMonster>=-54){
		spellALIVE = false;
		entities.creatures.Purse.score += 100;
		Monster.MonsterDead = 1;
	}
	
	if(spellALIVE == false){
		x = 1337;
		y = 1337;
	}
	
}
/*public void getSpellPos(){
	Monster.xSpell = getX();
	Monster.ySpell = getY();
}
*/
@Override
public void render(Graphics g) {
	
	switch(SpellDirection){  // Direction of the Spell when launch
	case 0: // Up
		y-=2;
		break;
	case 1: // UpLeft
		x-=2;
		y-=2;
		break;
	case 7: // UpRight
		x+=2;
		y-=2;
		break;
	case 4: // Down
		y+=2;
		break;
	case 3: // DownLeft
		x-=2;
		y-=2;
		break;
	case 5: // DownRight
		x+=2;
		y+=2;
		break;
	case 2: // Left
		x-=2;
		break;
	case 6: // Right
		x+=2;
		break;
	default:
		break;
	}
	
	if(spellALIVE == true){
		g.drawImage(Assets.fireball_1, (int) x, (int) y, width, height, null);
	}
	
	
	
}
}