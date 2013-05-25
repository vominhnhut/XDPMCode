package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.util.Log;

public class DAOBird {

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

	public ArrayList<DTOBird> load(ContextWrapper contextwrapper)
			throws IOException, ParserConfigurationException, SAXException {

		ArrayList<DTOBird> ListBird = new ArrayList<DTOBird>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/BIRD.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList birds = doc.getElementsByTagName("BIRD");

		for (int i = 0; i < birds.getLength(); i++) {
			DTOBird bird = new DTOBird();
			bird.id = birds.item(i).getAttributes().getNamedItem(KEY_ID)
					.getNodeValue().toString();
			bird.finalscore = Integer.parseInt(birds.item(i).getAttributes()
					.getNamedItem(KEY_FINALSCORE).getNodeValue().toString());
			ListBird.add(bird);
		}

		return ListBird;
	}

	public static ArrayList<DTOBird> load(SimpleLevelLoader loader) {

		final ArrayList<DTOBird> ListBird = new ArrayList<DTOBird>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_BIRD) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOBird dtobird = new DTOBird();

				dtobird.id = SAXUtils.getAttributeOrThrow(pAttributes, KEY_ID);
				dtobird.x = SAXUtils.getFloatAttribute(pAttributes, KEY_X, 0);
				dtobird.y = SAXUtils.getFloatAttribute(pAttributes, KEY_Y, 0);
				dtobird.finalscore = SAXUtils.getIntAttribute(pAttributes,
						KEY_FINALSCORE, 0);

				ListBird.add(dtobird);
				return null;
			}
		});

		return ListBird;

	}

}
