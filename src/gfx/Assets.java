package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;

	public static BufferedImage help1, help2, help3, help4, help5, help6, help7, help8, help9, help10, nothing,
			player_DL, player_DR, player_UL, player_UR, player_L, player_R, player_D, player_U, monster_1, monster_2,
			monster_3, monster_4, purse, v_bone, h_bone, bone, crystal_ball, fireball_1, fireball_2, fireball_3,
			fireball_4, fireball_5, gate_closed, gate_open, btn_start, score, 
			points_0, points_100, points_200, points_300, points_400, points_500, 
			points_600, points_700, points_800, points_900, points_1000, points_1100;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		// All player's animations
		player_DL = sheet.crop(width, 0, width, height);
		player_DR = sheet.crop(width * 2, 0, width, height);
		player_UL = sheet.crop(width * 2, height, width, height);
		player_UR = sheet.crop(width * 3, height, width, height);

		player_U = sheet.crop(width, height, width, height);
		player_R = sheet.crop(0, height, width, height);
		player_D = sheet.crop(0, 0, width, height);
		player_L = sheet.crop(width * 3, 0, width, height);

		//All monsters
		monster_1 = sheet.crop(0, height * 2, width, height);
		monster_2 = sheet.crop(width, height * 2, width, height);
		monster_3 = sheet.crop(width * 2, height * 2, width, height);
		monster_4 = sheet.crop(width * 3, height * 2, width, height);

		//World objects
		purse = sheet.crop(0, height * 3, width, height);
		v_bone = sheet.crop(width, height * 3, width, height); // Mur
		h_bone = sheet.crop(width * 2, height * 3, width, height); // Mur
		bone = sheet.crop(width * 3, height * 3, width, height); // Mur

		// Bonus, fireballs and gates
		crystal_ball = sheet.crop(0, height * 4, width, height);
		fireball_1 = sheet.crop(width, height * 4, width, height);
		fireball_2 = sheet.crop(width * 2, height * 4, width, height);
		fireball_3 = sheet.crop(width * 3, height * 4, width, height);

		fireball_4 = sheet.crop(0, height * 5, width, height);
		fireball_5 = sheet.crop(width, height * 5, width, height);
		gate_closed = sheet.crop(width * 2, height * 5, width, height);
		gate_open = sheet.crop(width * 3, height * 5, width, height);

		
		//Black square
		nothing = sheet.crop(0, height * 6, width, height);

		
		//Key Help
		help1 = sheet.crop(0, height * 7, width, height);
		help2 = sheet.crop(width, height * 7, width, height);

		help3 = sheet.crop(0, height * 8, width, height);
		help4 = sheet.crop(width, height * 8, width, height);

		help5 = sheet.crop(0, height * 9, width, height);
		help6 = sheet.crop(width, height * 9, width, height);

		help7 = sheet.crop(0, height * 10, width, height);
		help8 = sheet.crop(width, height * 10, width, height);

		help9 = sheet.crop(0, height * 11, width, height);
		help10 = sheet.crop(width, height * 11, width, height);
		
		//Score
		score = sheet.crop(width, height * 6, width, height);
		
		points_0 = sheet.crop(width * 2, height * 6, width, height);
		points_100 = sheet.crop(width * 2, height * 7, width, height);
		points_200 = sheet.crop(width * 2, height * 8, width, height);
		points_300 = sheet.crop(width * 2, height * 9, width, height);
		points_400 = sheet.crop(width * 2, height * 10, width, height);
		points_500 = sheet.crop(width * 2, height * 11, width, height);
		
		points_600 = sheet.crop(width * 3, height * 6, width, height);
		points_700 = sheet.crop(width * 3, height * 7, width, height);
		points_800 = sheet.crop(width * 3, height * 8, width, height);
		points_900 = sheet.crop(width * 3, height * 9, width, height);
		points_1000 = sheet.crop(width * 3, height * 10, width, height);
		points_1100 = sheet.crop(width * 3, height * 11, width, height);
	}

}
