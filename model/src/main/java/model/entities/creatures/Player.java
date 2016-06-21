package model.entities.creatures;

import java.awt.Graphics;
import model.entities.creatures.Creature;
import java.awt.image.BufferedImage;

import model.gfx.Assets;

public class Player extends Creature{

	
	private static int MoveState = 0;
	public Player (float x, float y, int width, int height){
		super(x,y);	
	}
	
	@Override
	public void tick() {
		//getInput();
		//move();
		xMove = 0;
		yMove = 0;
		MoveState = 0;
		
	}

		//movement
		
		public void moveRight(){
			xMove = speed;
			Creature.setX();
			MoveState = 2;
		}
		public void moveLeft(){
			xMove = -speed;
			Creature.setX();
			MoveState = 4;
		}
		public void moveUp(){
			yMove = -speed;
			Creature.setY();
			MoveState = 1;
		}
		public void moveDown(){
			yMove = speed;
			Creature.setY();
			MoveState = 3;
		}
		public void moveUpLeft(){
			xMove = -speed;
			yMove = -speed;
			Creature.setX();
			Creature.setY();
		}
		public void moveUpRight(){
			xMove = speed;
			yMove = -speed;
			Creature.setX();
			Creature.setY();
		}
		public void moveDownLeft(){
			xMove = -speed;
			yMove = speed;
			Creature.setX();
			Creature.setY();
		}
		public void moveDownRight(){
			xMove = speed;
			yMove = speed;
			Creature.setX();
			Creature.setY();
		}
	

public static void paintComponent(Graphics graphics){ // Movement animations
	
	graphics.drawImage(Assets.player_U, (int)Player.getX(), (int)Player.getY(), width, height, null); // Default
	
	if(MoveState == 1){
		graphics.drawImage(Assets.player_U, (int) x, (int) y, width, height, null);} //Up
	else if(MoveState == 3){
		graphics.drawImage(Assets.player_D, (int) x, (int) y, width, height, null);} //Down
	else if(MoveState == 4){
		graphics.drawImage(Assets.player_L, (int) x, (int) y, width, height, null);} //Left
	else if(MoveState == 2){
		graphics.drawImage(Assets.player_R, (int) x, (int) y, width, height, null);} //Right
}


}
