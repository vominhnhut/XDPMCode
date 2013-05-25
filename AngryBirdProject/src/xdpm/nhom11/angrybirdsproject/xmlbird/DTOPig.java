package xdpm.nhom11.angrybirdsproject.xmlbird;

import xdpm.nhom11.angrybirdsproject.entities.Pig;
import xdpm.nhom11.angrybirdsproject.entities.Pig.PigType;

public class DTOPig {
	public String id;
	public float lifevalue;
	public int score;
	public float x;
	public float y;

	public Pig getPig() {
		return new Pig(id, PigType.NORMAL, x, y, 0, 5000, null);
	}
}
