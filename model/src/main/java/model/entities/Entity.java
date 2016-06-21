package model.entities;

import java.awt.Graphics;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity{

	/*public float x;
	public float y;*/
	public static final float speed = 3.0f;   //speed of our character
	public static final int width = 32, height = 32;
	public static final int tilewidth = 32, tileheight = 32;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Entity(float x2, float y2){
		
		
	}
	



	public static int getWidth() {
		return width;
	}


	public static int getHeight() {
		return height;
	}
}
