package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	// STATIC STUFF HERE

	public static Tile[] tiles = new Tile[256];

	public static Tile Nothing = new Nothing(0);
	// public static Tile Player_D = new Player_D(0);
	// public static Tile Player_DL = new Player_DL(1);
	// public static Tile Player_DR = new Player_DR(2);
	public static Tile Player_L = new Player_L(3);
	public static Tile Player_R = new Player_R(4);
	public static Tile Player_U = new Player_U(5);
	// public static Tile Player_UL = new Player_UL(6);
	// public static Tile Player_UR = new Player_UR(7);
	public static Tile Monster_1 = new Monster_1(8);
	public static Tile Monster_2 = new Monster_2(9);
	public static Tile Monster_3 = new Monster_3(10);
	public static Tile Monster_4 = new Monster_4(11);
	public static Tile Purse = new Purse(12);
	public static Tile V_bone = new V_bone(13);
	public static Tile H_bone = new H_bone(14);
	public static Tile Bone = new Bone(15);
	public static Tile Crystal_ball = new Crystal_ball(16);
	public static Tile Fireball_1 = new Fireball_1(17);
	public static Tile Fireball_2 = new Fireball_2(18);
	public static Tile Fireball_3 = new Fireball_3(19);
	public static Tile Fireball_4 = new Fireball_4(20);
	public static Tile Fireball_5 = new Fireball_5(21);
	public static Tile Gate_closed = new Gate_closed(22);
	public static Tile Gate_open = new Gate_open(23);
	public static Tile Help1 = new Help1(51);
	public static Tile Help2 = new Help2(52);
	public static Tile Help3 = new Help3(53);
	public static Tile Help4 = new Help4(54);
	public static Tile Help5 = new Help5(55);
	public static Tile Help6 = new Help6(56);
	public static Tile Help7 = new Help7(57);
	public static Tile Help8 = new Help8(58);
	public static Tile Help9 = new Help9(59);
	public static Tile Help10 = new Help10(60);

	// CLASS

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}

}
