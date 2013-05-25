package xdpm.nhom11.angrybirdsproject.xmlbird;

import xdpm.nhom11.angrybirdsproject.entities.Block;
import xdpm.nhom11.angrybirdsproject.entities.Block.BlockType;

public class DTOBlock {
	public String id;
	public float lifevalue;
	public float score;
	public float rotation;
	public float x;
	public float y;
	public String type;

	public DTOBlock() {
		this.id = "";
		this.type = "";
		this.lifevalue = 2000;
		this.score = 0;
		this.rotation = 0;
		this.x = 0;
		this.y = 0;
	}

	public Block getObjectGame() {
		if (type.equalsIgnoreCase("rock")) {
			return new Block(id, BlockType.ROCK, x, y, rotation,
					lifevalue, null);
		} else if (type.equalsIgnoreCase("wood")) {
			return new Block(id, BlockType.WOOD, x, y, rotation,
					lifevalue, null);
		} else if (type.equalsIgnoreCase("ice")) {
			return new Block(id, BlockType.ICE, x, y, rotation, lifevalue,
					null);
		}
		return new Block(id, BlockType.ICE, x, y, rotation, lifevalue,
				null);

	}
}
