package worlds;

import java.awt.Graphics;

import tilegame.Handler;
import tiles.Tile;
import utils.Utils;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private Handler handler;
	private int[][] tiles;
	
	public World(Handler handler,String path){
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	public void render(Graphics g){
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.Bone;
		if(x<0 || y<0 || x>=width || y>= height)
			return Tile.Nothing;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		this.handler.setWorld(this);
	}	
}