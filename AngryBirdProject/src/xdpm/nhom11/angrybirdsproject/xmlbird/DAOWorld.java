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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.util.Log;

public class DAOWorld {

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
	public static final String KEY_BGID = "backgroundID";

	public static ArrayList<DTOWorld> load(final SimpleLevelLoader loader) {

		final ArrayList<DTOWorld> ListWorld = new ArrayList<DTOWorld>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_WORLD) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOWorld dtoworld = new DTOWorld();
				dtoworld.id = SAXUtils.getAttributeOrThrow(pAttributes, KEY_ID);
				dtoworld.locked = SAXUtils.getBooleanAttributeOrThrow(
						pAttributes, KEY_LOCKED);

				dtoworld.chapters = DAOChapter.load(loader);
				dtoworld.backgroundID = SAXUtils.getAttribute(pAttributes,
						KEY_BGID, "background1");

				ListWorld.add(dtoworld);
				return null;
			}
		});

		return ListWorld;

	}

	public static ArrayList<DTOWorld> load(ContextWrapper contextwrapper)
			throws IOException, ParserConfigurationException, SAXException {

		ArrayList<DTOWorld> ListWorld = new ArrayList<DTOWorld>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/WORLD.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);

		// File fXmlFile = assetManager.open("res/xml/WORLD.xml");
		// InputStream is =
		// contextwrapper.getResources().openRawResource(R.xml.);
		// DocumentBuilderFactory dbFactory =
		// DocumentBuilderFactory.newInstance();
		// DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		// Document doc = dBuilder.parse(fXmlFile);
		// doc.getDocumentElement().normalize();

		NodeList worlds = doc.getElementsByTagName("WORLD");

		for (int i = 0; i < worlds.getLength(); i++) {
			DTOWorld world = new DTOWorld();

			Element ElmWorld = (Element) (worlds.item(i));

			world.id = worlds.item(i).getAttributes().getNamedItem(KEY_ID)
					.getNodeValue().toString();
			world.locked = Boolean.parseBoolean(worlds.item(i).getAttributes()
					.getNamedItem(KEY_LOCKED).getNodeValue().toString());

			NodeList chapters = ElmWorld.getElementsByTagName("CHAPTER");
			ArrayList<DTOChapter> ListChapter = new ArrayList<DTOChapter>();
			for (int j = 0; j < chapters.getLength(); j++) {
				DTOChapter chapter = new DTOChapter();
				chapter.id = chapters.item(j).getAttributes()
						.getNamedItem(KEY_ID).getNodeValue().toString();

				Element ElmChapter = (Element) (chapters.item(i));

				NodeList levels = ElmChapter.getElementsByTagName("LEVEL");
				ArrayList<DTOLevel> ListLevel = new ArrayList<DTOLevel>();
				for (int k = 0; k < levels.getLength(); k++) {
					DTOLevel level = new DTOLevel();
					level.id = levels.item(k).getAttributes()
							.getNamedItem(KEY_ID).getNodeValue().toString();
					level.locked = Boolean.parseBoolean(levels.item(k)
							.getAttributes().getNamedItem(KEY_ID)
							.getNodeValue().toString());
					level.highscore = Integer.parseInt(levels.item(k)
							.getAttributes().getNamedItem(KEY_HIGHSCORE)
							.getNodeValue().toString());
					level.numstar = Integer.parseInt(levels.item(k)
							.getAttributes().getNamedItem(KEY_NUMSTAR)
							.getNodeValue().toString());
					level.width = Float.parseFloat(levels.item(k)
							.getAttributes().getNamedItem(KEY_WIDTH)
							.getNodeValue().toString());
					level.height = Float.parseFloat(levels.item(k)
							.getAttributes().getNamedItem(KEY_HEIGHT)
							.getNodeValue().toString());
					level.bgcolor = levels.item(k).getAttributes()
							.getNamedItem(KEY_BGCOLOR).getNodeValue()
							.toString();

					Element ElmBackground = (Element) (chapters.item(i));
					NodeList backgrounds = ElmBackground
							.getElementsByTagName("BACKGROUND");

					DTOBackground background = new DTOBackground();

					level.background = background;

					Element ElmSlingshots = (Element) (chapters.item(i));
					NodeList slingshots = ElmSlingshots
							.getElementsByTagName("SLINGSHOT");
					DTOSlingShot slingshot = new DTOSlingShot();
					slingshot.x = Integer.parseInt(slingshots.item(0)
							.getAttributes().getNamedItem(KEY_X).getNodeValue()
							.toString());
					slingshot.y = Integer.parseInt(slingshots.item(0)
							.getAttributes().getNamedItem(KEY_Y).getNodeValue()
							.toString());
					level.slingshot = slingshot;

					Element ElmBird = (Element) (chapters.item(i));
					NodeList birds = ElmBird.getElementsByTagName("BIRD");
					ArrayList<DTOBird> ListBird = new ArrayList<DTOBird>();
					for (int m = 0; m < birds.getLength(); m++) {
						DTOBird bird = new DTOBird();
						bird.id = birds.item(m).getAttributes()
								.getNamedItem(KEY_ID).getNodeValue().toString();
						bird.x = Integer.parseInt(birds.item(m).getAttributes()
								.getNamedItem(KEY_X).getNodeValue().toString());
						bird.y = Integer.parseInt(birds.item(m).getAttributes()
								.getNamedItem(KEY_Y).getNodeValue().toString());
						ListBird.add(bird);
					}
					level.birds = ListBird;

					Element ElmPig = (Element) (chapters.item(i));
					NodeList pigs = ElmPig.getElementsByTagName("PIG");
					ArrayList<DTOPig> ListPig = new ArrayList<DTOPig>();
					for (int m = 0; m < pigs.getLength(); m++) {
						DTOPig pig = new DTOPig();
						pig.id = pigs.item(m).getAttributes()
								.getNamedItem(KEY_ID).getNodeValue().toString();
						pig.x = Float.parseFloat(pigs.item(m).getAttributes()
								.getNamedItem(KEY_X).getNodeValue().toString());
						pig.y = Float.parseFloat(pigs.item(m).getAttributes()
								.getNamedItem(KEY_Y).getNodeValue().toString());
						ListPig.add(pig);
					}
					level.pigs = ListPig;

					Element ElmBlock = (Element) (chapters.item(i));
					NodeList blocks = ElmBlock.getElementsByTagName("BLOCK");
					ArrayList<DTOBlock> ListBlock = new ArrayList<DTOBlock>();
					for (int n = 0; n < blocks.getLength(); n++) {
						DTOBlock block = new DTOBlock();
						block.id = blocks.item(n).getAttributes()
								.getNamedItem(KEY_ID).getNodeValue().toString();

						block.type = blocks.item(n).getAttributes()
								.getNamedItem(KEY_TYPE).getNodeValue()
								.toString();

						block.rotation = Float.parseFloat(blocks.item(n)
								.getAttributes().getNamedItem(KEY_ROTATION)
								.getNodeValue().toString());
						block.x = Float.parseFloat(blocks.item(n)
								.getAttributes().getNamedItem(KEY_X)
								.getNodeValue().toString());
						block.y = Float.parseFloat(blocks.item(n)
								.getAttributes().getNamedItem(KEY_Y)
								.getNodeValue().toString());
						ListBlock.add(block);
					}
					level.blocks = ListBlock;
					ListLevel.add(level);
				}
				//
				chapter.levels = ListLevel;
				//
				ListChapter.add(chapter);
			}

			world.chapters = ListChapter;

			ListWorld.add(world);
		}
		return ListWorld;
	}
}
