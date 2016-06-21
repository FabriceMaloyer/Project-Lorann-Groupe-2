package model.tiles;

import model.gfx.Assets;

public class Purse extends Tile {

	public Purse(int id) {
		super(Assets.purse, id);
	}
	
	/*public static int purse1x = 256, purse1y = 128; // Disabled because actually no map

	public static int score = 0;

	public static int purse1pickedup = 0;
	
	public Purse(int id) {
		super(Assets.purse, id);
	}


	public static void pickUpPurse(){
		
		if(Player.x == purse1x && Player.y == purse1y) {	//suppose to know when the player is on the Purse
			purse1pickedup = 1;}
	
	}
	
	public static void scoreIncrease(){  //if the player is on the purse increment score
		if (purse1pickedup == 1){
			score = score + 100;
			System.out.println(score);
			purse1pickedup = 2;
			}
	}		
	

}*/
}
