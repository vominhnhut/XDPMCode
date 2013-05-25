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

public class DAOSlingshot {
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

	public static DTOSlingShot load(SimpleLevelLoader loader) {

		final DTOSlingShot Slingshot = new DTOSlingShot();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_SLINGSHOT) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub

				Slingshot.x = SAXUtils.getFloatAttribute(pAttributes, KEY_X, 0);

				Slingshot.y = SAXUtils.getFloatAttribute(pAttributes, KEY_Y, 0);

				return null;
			}
		});

		return Slingshot;

	}
}
