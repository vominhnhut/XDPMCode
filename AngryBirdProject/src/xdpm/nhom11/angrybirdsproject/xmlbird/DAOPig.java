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

public class DAOPig {

	static final String X = "x";
	static final String Y = "y";
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

	public static ArrayList<DTOPig> load(ContextWrapper contextwrapper)
			throws IOException, ParserConfigurationException, SAXException {

		ArrayList<DTOPig> ListPig = new ArrayList<DTOPig>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/PIG.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList pigs = doc.getElementsByTagName("PIG");

		for (int i = 0; i < pigs.getLength(); i++) {
			DTOPig pig = new DTOPig();
			pig.id = pigs.item(i).getAttributes().getNamedItem(KEY_ID)
					.getNodeValue().toString();

			pig.x = Float.parseFloat(pigs.item(i).getAttributes()
					.getNamedItem(X).getNodeValue().toString());

			pig.y = Float.parseFloat(pigs.item(i).getAttributes()
					.getNamedItem(Y).getNodeValue().toString());

			pig.lifevalue = Float.parseFloat(pigs.item(i).getAttributes()
					.getNamedItem(KEY_LIFEVALUE).getNodeValue().toString());

			pig.score = Integer.parseInt(pigs.item(i).getAttributes()
					.getNamedItem(KEY_SCORE).getNodeValue().toString());

			ListPig.add(pig);
		}

		return ListPig;
	}

	public static ArrayList<DTOPig> load(SimpleLevelLoader loader) {

		final ArrayList<DTOPig> ListPig = new ArrayList<DTOPig>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_PIG) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOPig dtopig = new DTOPig();

				dtopig.id = SAXUtils.getAttributeOrThrow(pAttributes, KEY_ID);
				dtopig.x = SAXUtils.getFloatAttribute(pAttributes, KEY_X, 0);
				dtopig.y = SAXUtils.getFloatAttribute(pAttributes, KEY_Y, 0);
				dtopig.lifevalue = SAXUtils.getFloatAttribute(pAttributes,
						KEY_LIFEVALUE, 0);
				dtopig.score = SAXUtils.getIntAttribute(pAttributes, KEY_SCORE,
						0);

				ListPig.add(dtopig);
				return null;
			}
		});

		return ListPig;

	}
}
