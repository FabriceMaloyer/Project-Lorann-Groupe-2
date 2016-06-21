package model.entities.creatures;

import java.awt.Graphics;

import model.entities.Entity;

public class Creature extends Entity {

	public static float x = 0;
	public static float y = 0;
	public static float xMove, yMove;

	
public Creature(float x2, float y2){
	super(x2,y2);
}



public static float getX() {
	return x;
}
public static void setX() {
	x += xMove;
}
public static float getY() {
	return y;
}
public static void setY() {
	y += yMove;
	
}

/*public void move(){ //no implemented because no map
	moveX();
	moveY();
}

public void moveX(){
	if(xMove > 0){//Moving right
		int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
		
		if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
			x += xMove;
		}
	}else if(xMove < 0){//Moving left
		int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
		
		if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
				!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
			x += xMove;
		}
	}
}

public void moveY(){
	if(yMove < 0){//Up
		int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
		
		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
			y += yMove;
		}
	}else if(yMove > 0){//Down
		int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
		
		if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
			y += yMove;
		}
	}
}

protected boolean collisionWithTile(int x, int y){
	return handler.getWorld().getTile(x, y).isSolid();      
}*/



@Override
public void tick() {
	// TODO Auto-generated method stub
	
}



@Override
public void render(Graphics g) {
	// TODO Auto-generated method stub
	
}
}
