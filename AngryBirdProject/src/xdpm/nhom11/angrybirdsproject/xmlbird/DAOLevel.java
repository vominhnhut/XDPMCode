package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.IEntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import xdpm.nhom11.angrybirdsproject.entities.Slingshot;

import android.util.Log;

public class DAOLevel {
	public static final String TAG_LISTWORLD = "LISTWORLD";
	public static final String TAG_LISTBIRD = "LISTBIRD";
	public static final String TAG_LISTPIG = "LISTPIG";
	public static final String TAG_LISTBlOCK = "LISTBLOCK";
	public static final String TAG_WORLD = "WORLD";
	public static final String TAG_CHAPTER = "CHAPTER";
	public static final String TAG_LEVEL = "LEVEL";
	public static final String TAG_BACKGROUND = "BACKGROUND";
	public static final String TAG_SLINGSHOT = "SLINGSHOT";
	public static final String TAG_BIRD = "BIRD";
	public static final String TAG_PIG = "PIG";
	public static final String TAG_BLOCK = "BLOCK";

	public static final String KEY_ID = "id";
	public static final String KEY_LOCKED = "locked";
	public static final String KEY_HIGHSCORE = "highscore";
	public static final String KEY_NUMSTAR = "numstar";
	public static final String KEY_WIDTH = "width";
	public static final String KEY_HEIGHT = "height";
	public static final String KEY_BGCOLOR = "bgcolor";
	public static final String KEY_X = "x";
	public static final String KEY_Y = "y";
	public static final String KEY_ROTATION = "rotation";
	public static final String KEY_TYPE = "type";
	public static final String KEY_FINALSCORE = "finalscore";
	public static final String KEY_LIFEVALUE = "lifevalue";
	public static final String KEY_SCORE = "score";

	public static ArrayList<DTOLevel> load(final SimpleLevelLoader loader) {

		final ArrayList<DTOLevel> ListLevel = new ArrayList<DTOLevel>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_LEVEL) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOLevel dtolevel = new DTOLevel();
				dtolevel.id = SAXUtils.getAttributeOrThrow(pAttributes, KEY_ID);
				dtolevel.locked = SAXUtils.getBooleanAttribute(pAttributes,
						KEY_LOCKED, true);
				dtolevel.highscore = SAXUtils.getIntAttribute(pAttributes,
						KEY_HIGHSCORE, 0);
				dtolevel.numstar = SAXUtils.getIntAttribute(pAttributes,
						KEY_NUMSTAR, 0);
				dtolevel.width = SAXUtils.getIntAttribute(pAttributes,
						KEY_WIDTH, 0);
				dtolevel.height = SAXUtils.getIntAttribute(pAttributes,
						KEY_HEIGHT, 0);
				dtolevel.bgcolor = SAXUtils.getAttribute(pAttributes,
						KEY_BGCOLOR, "");

				dtolevel.slingshot = DAOSlingshot.load(loader);
				dtolevel.birds = DAOBird.load(loader);
				dtolevel.pigs = DAOPig.load(loader);
				dtolevel.blocks = DAOBlock.load(loader);
				ListLevel.add(dtolevel);

				return null;
			}
		});

		return ListLevel;

	}
}
