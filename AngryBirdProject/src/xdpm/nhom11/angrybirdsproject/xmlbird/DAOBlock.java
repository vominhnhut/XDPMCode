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

public class DAOBlock {

	static final String X = "x";
	static final String Y = "y";
	static final String ROTATION = "rotation";
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

	public ArrayList<DTOBlock> load(ContextWrapper contextwrapper)
			throws IOException, ParserConfigurationException, SAXException {

		ArrayList<DTOBlock> ListBlock = new ArrayList<DTOBlock>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/BLOCK.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList blocks = doc.getElementsByTagName("BLOCK");

		for (int i = 0; i < blocks.getLength(); i++) {
			DTOBlock block = new DTOBlock();
			block.id = blocks.item(i).getAttributes().getNamedItem(KEY_ID)
					.getNodeValue().toString();

			block.lifevalue = Integer.parseInt(blocks.item(i).getAttributes()
					.getNamedItem(KEY_LIFEVALUE).getNodeValue().toString());

			block.score = Float.parseFloat(blocks.item(i).getAttributes()
					.getNamedItem(KEY_SCORE).getNodeValue().toString());
			block.x = Float.parseFloat(blocks.item(i).getAttributes()
					.getNamedItem(X).getNodeValue().toString());
			block.y = Float.parseFloat(blocks.item(i).getAttributes()
					.getNamedItem(Y).getNodeValue().toString());
			block.rotation = Float.parseFloat(blocks.item(i).getAttributes()
					.getNamedItem(KEY_ROTATION).getNodeValue().toString());

			ListBlock.add(block);
		}

		return ListBlock;
	}

	public static ArrayList<DTOBlock> load(SimpleLevelLoader loader) {

		final ArrayList<DTOBlock> ListBlock = new ArrayList<DTOBlock>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_BLOCK) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOBlock dtoblock = new DTOBlock();

				dtoblock.id = SAXUtils.getAttributeOrThrow(pAttributes, KEY_ID);
				dtoblock.x = SAXUtils.getFloatAttribute(pAttributes, KEY_X, 0);
				dtoblock.y = SAXUtils.getFloatAttribute(pAttributes, KEY_Y, 0);
				dtoblock.rotation = SAXUtils.getFloatAttribute(pAttributes,
						ROTATION, 0);
				dtoblock.lifevalue = SAXUtils.getFloatAttribute(pAttributes,
						KEY_LIFEVALUE, 5000);
				dtoblock.score = SAXUtils.getIntAttribute(pAttributes,
						KEY_SCORE, 0);
				dtoblock.type = SAXUtils.getAttribute(pAttributes, KEY_TYPE,
						"ice");

				ListBlock.add(dtoblock);
				return null;
			}
		});

		return ListBlock;

	}
}
