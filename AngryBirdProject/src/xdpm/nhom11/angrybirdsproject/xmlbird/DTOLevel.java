package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.util.ArrayList;

import xdpm.nhom11.angrybirdsproject.entities.Bird;
import xdpm.nhom11.angrybirdsproject.entities.Block;
import xdpm.nhom11.angrybirdsproject.entities.Pig;
import xdpm.nhom11.angrybirdsproject.entities.Slingshot;

public class DTOLevel {
	// id level
	public String id;
	// level có bị khóa chưa
	public boolean locked;
	// điểm cao nhất của level
	public int highscore;
	// số sao đạt dc của level đó
	public int numstar;
	// chiều rộng của map trong level
	public float width;
	// chiều cao của map trong level
	public float height;
	// màu nền của map trong level
	public String bgcolor;
	public DTOBackground background;
	public DTOSlingShot slingshot;
	public ArrayList<DTOBird> birds;
	public ArrayList<DTOBlock> blocks;
	public ArrayList<DTOPig> pigs;

	public DTOLevel() {
		background = new DTOBackground();
		slingshot = new DTOSlingShot();
		birds = new ArrayList<DTOBird>();
		blocks = new ArrayList<DTOBlock>();
	}

	public ArrayList<Pig> getListPig() {

		ArrayList<Pig> listpig = new ArrayList<Pig>();
		for (DTOPig pig : pigs) {
			listpig.add(pig.getPig());
		}
		return listpig;

	}

	public ArrayList<Block> getListBlock() {

		ArrayList<Block> listblock = new ArrayList<Block>();
		for (DTOBlock block : blocks) {
			listblock.add(block.getObjectGame());
		}
		return listblock;

	}

	public ArrayList<Bird> getListBird() {

		ArrayList<Bird> listbird = new ArrayList<Bird>();
		for (DTOBird bird : birds) {
			listbird.add(bird.getBird());
		}
		return listbird;

	}

	public Slingshot getSlingshot() {

		return slingshot.getSlingshot();

	}

}