package model.tiles;

import model.gfx.Assets;

public class Bone extends Tile {

	public Bone(int id) {
		super(Assets.bone, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
