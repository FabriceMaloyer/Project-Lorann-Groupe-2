package display;

import java.awt.Graphics;

import gfx.Assets;

public class Score {

	
	
	
	public static void render(Graphics g) {
		
		int x = 620;
		int y = 512;
		int width = 64;
		int height = 64;
		
		g.drawImage(Assets.score, x-64, y, width, height, null); // Show "Score :"
		
	switch(entities.creatures.Purse.score){
	case 0:
		g.drawImage(Assets.points_0, x, y, width, height, null);
		break;
	case 100:
		g.drawImage(Assets.points_100, x, y, width, height, null);
		break;
	case 200:
		g.drawImage(Assets.points_200, x, y, width, height, null);
		break;
	case 300:
		g.drawImage(Assets.points_300, x, y, width, height, null);
		break;
	case 400:
		g.drawImage(Assets.points_400, x, y, width, height, null);
		break;
	case 500:
		g.drawImage(Assets.points_500, x, y, width, height, null);
		break;
	case 600:
		g.drawImage(Assets.points_600, x, y, width, height, null);
		break;
	case 700:
		g.drawImage(Assets.points_700, x, y, 32, 32, null);
		break;
	case 800:
		g.drawImage(Assets.points_800, x, y, 32, 32, null);
		break;
	case 900:
		g.drawImage(Assets.points_900, x, y, 32, 32, null);
		break;
	case 1000:
		g.drawImage(Assets.points_1000, x, y, 32, 32, null);
		break;
	case 1100:
		g.drawImage(Assets.points_1100, x, y, 32, 32, null);
		break;
		}
	}

}

