package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.util.ArrayList;

public class DTOWorld {
	public int id;
	public boolean locked;
	public ArrayList<Chapter> chapters;

	public DTOWorld() {
		chapters = new ArrayList<Chapter>();
	}
}

class Chapter {
	public int id;
	public ArrayList<Level> levels;

	public Chapter() {
		levels = new ArrayList<Level>();
	}
}

class Level {
	public int id;
	public boolean locked;
	public double highscore;
	public int numstar;
	public int width;
	public int height;
	public String bgcolor;
	public BackGround background;
	public SlingShot slingshot;
	public ArrayList<Bird> birds;
	public ArrayList<Block> blocks;

	public Level() {
		background = new BackGround();
		slingshot = new SlingShot();
		birds = new ArrayList<Bird>();
		blocks = new ArrayList<Block>();
	}
}

class Block {
	public String id;
	public int rotation;
	public int x;
	public int y;
}

class Bird {
	public String id;
	public int x;
	public int y;
}

class SlingShot {
	public int x;
	public int y;
}

class BackGround {
	public int id;
}