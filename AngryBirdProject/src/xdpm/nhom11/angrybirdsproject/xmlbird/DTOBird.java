package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import android.util.Log;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.entities.Bird;

public class DTOBird {
	public int finalscore;
	public String id;
	public float x;
	public float y;

	public DTOBird() {
		this.id = "";
		this.x = 0;
		this.y = 0;
		this.finalscore = 0;
	}

	public Bird getBird() {
		if (id.equalsIgnoreCase("RED BIRD")) {
			return new RedBird(x, y, null);
		} else if (id.equalsIgnoreCase("YELLOW BIRD")) {
			return new YellowBird(x, y, null);
		} else if (id.equalsIgnoreCase("BLUE BIRD")) {
			return new BlueBird(x, y, null);
		} else if (id.equalsIgnoreCase("BLACK BIRD")) {
			return new BlackBird(x, y, null);
		} else if (id.equalsIgnoreCase("WHITE BIRD")) {
			return new WhiteBird(x, y, null);
		}
		return new RedBird(x, y, null);

	}

}
