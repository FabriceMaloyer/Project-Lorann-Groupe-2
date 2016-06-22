package states;

import java.awt.Graphics;

import display.Score;
import tilegame.Game;
import tilegame.Handler;
import entities.Entity;
import entities.creatures.Monster;
import entities.creatures.Player;
import entities.creatures.Purse;
import entities.creatures.Spell;
import worlds.World;

public class GameState extends State {
	
	public World world;
	private Player player;
	private Monster monster;
	private Purse purse;
	private Purse purse2;
	private Spell spell;
	private Monster monster2;
	
	public GameState(Handler handler,Game game){
		super(game);
		player = new Player(handler,game, 100, 100, monster);  // position of the player at the beginning of the game
		world = new World(handler,"res/worlds/world1.txt"); //where the map is
		monster = new Monster(handler, game, 400, 420, player);// position of the monster
		//monster2 = new Monster(handler, game, 400, 200, player);
		purse = new Purse(handler, game, 200, 400, player);
		purse2 = new Purse(handler, game, 300, 200, player);
		spell = new Spell(handler, game, 164, 164, player);
	}
	
	@Override
	public void tick() {   // used to synchronize game logic and timing
		world.tick();
		player.tick();
		player.getPlayerPos();
		monster.tick();
		monster.getMonsterPos();
		purse.tick();
		purse2.tick();
		spell.tick();
		//monster2.tick();
	}

	@Override
	public void render(Graphics g) {  // to use our spritesheet
		world.render(g);
		purse.render(g);  // Spawn before player and monster to hide the ugly black square when player is moving over it
		purse2.render(g);
		player.render(g);
		monster.render(g);
		//monster2.render(g);
		spell.render(g);
		Score.render(g);
	}

}
