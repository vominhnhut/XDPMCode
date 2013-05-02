package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
public class DAOWorld {
	static final String KEY_ID = "id";
	static final String KEY_LOCKED = "locked";
	static final String KEY_HIGHSCORE = "highscore";
	static final String KEY_NUMSTAR = "numstar";
	static final String KEY_WIDTH = "width";
	static final String KEY_HEIGHT = "height";
	static final String KEY_BGCOLOR = "bgcolor";
	static final String KEY_X = "x";
	static final String KEY_Y = "y";
	static final String KEY_ROTATION = "rotation";

	public ArrayList<DTOWorld> load(ContextWrapper contextwrapper)
			throws IOException, ParserConfigurationException, SAXException {

		ArrayList<DTOWorld> ListWorld = new ArrayList<DTOWorld>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/WORLD.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList worlds = doc.getElementsByTagName("WORLD");

		for (int i = 0; i < worlds.getLength(); i++) {
			DTOWorld world = new DTOWorld();

			Element ElmWorld = (Element) (worlds.item(i));

			world.id = Integer.parseInt(worlds.item(i).getAttributes()
					.getNamedItem(KEY_ID).getNodeValue().toString());
			world.locked = Boolean.parseBoolean(worlds.item(i).getAttributes()
					.getNamedItem(KEY_LOCKED).getNodeValue().toString());

			NodeList chapters = ElmWorld.getElementsByTagName("CHAPTER");
			ArrayList<Chapter> ListChapter = new ArrayList<Chapter>();
			for (int j = 0; j < chapters.getLength(); j++) {
				Chapter chapter = new Chapter();
				chapter.id = Integer.parseInt(chapters.item(j).getAttributes()
						.getNamedItem(KEY_ID).getNodeValue().toString());

				Element ElmChapter = (Element) (chapters.item(i));

				NodeList levels = ElmChapter.getElementsByTagName("LEVEL");
				ArrayList<Level> ListLevel = new ArrayList<Level>();
				for (int k = 0; k < levels.getLength(); k++) {
					Level level = new Level();
					level.id = Integer.parseInt(levels.item(k).getAttributes()
							.getNamedItem(KEY_ID).getNodeValue().toString());
					level.locked = Boolean.parseBoolean(levels.item(k)
							.getAttributes().getNamedItem(KEY_ID)
							.getNodeValue().toString());
					level.highscore = Double.parseDouble(levels.item(k)
							.getAttributes().getNamedItem(KEY_HIGHSCORE)
							.getNodeValue().toString());
					level.numstar = Integer.parseInt(levels.item(k)
							.getAttributes().getNamedItem(KEY_NUMSTAR)
							.getNodeValue().toString());
					level.width = Integer.parseInt(levels.item(k)
							.getAttributes().getNamedItem(KEY_WIDTH)
							.getNodeValue().toString());
					level.height = Integer.parseInt(levels.item(k)
							.getAttributes().getNamedItem(KEY_HEIGHT)
							.getNodeValue().toString());
					level.bgcolor = levels.item(k).getAttributes()
							.getNamedItem(KEY_BGCOLOR).getNodeValue()
							.toString();

					Element ElmBackground = (Element) (chapters.item(i));
					NodeList backgrounds = ElmBackground
							.getElementsByTagName("BACKGROUND");

					BackGround background = new BackGround();
					background.id = Integer.parseInt(backgrounds.item(0)
							.getAttributes().getNamedItem(KEY_ID)
							.getNodeValue().toString());
					level.background = background;

					Element ElmSlingshots = (Element) (chapters.item(i));
					NodeList slingshots = ElmSlingshots
							.getElementsByTagName("SLINGSHOT");
					SlingShot slingshot = new SlingShot();
					slingshot.x = Integer.parseInt(slingshots.item(0)
							.getAttributes().getNamedItem(KEY_X).getNodeValue()
							.toString());
					slingshot.y = Integer.parseInt(slingshots.item(0)
							.getAttributes().getNamedItem(KEY_Y).getNodeValue()
							.toString());
					level.slingshot = slingshot;

					Element ElmBird = (Element) (chapters.item(i));
					NodeList birds = ElmBird.getElementsByTagName("BIRD");
					ArrayList<Bird> ListBird = new ArrayList<Bird>();
					for (int m = 0; m < birds.getLength(); m++) {
						Bird bird = new Bird();
						bird.id = birds.item(m).getAttributes()
								.getNamedItem(KEY_ID).getNodeValue().toString();
						bird.x = Integer.parseInt(birds.item(m).getAttributes()
								.getNamedItem(KEY_X).getNodeValue().toString());
						bird.y = Integer.parseInt(birds.item(m).getAttributes()
								.getNamedItem(KEY_Y).getNodeValue().toString());
						ListBird.add(bird);
					}
					level.birds = ListBird;

					Element ElmBlock = (Element) (chapters.item(i));
					NodeList blocks = ElmBlock.getElementsByTagName("BLOCK");
					ArrayList<Block> ListBlock = new ArrayList<Block>();
					for (int n = 0; n < blocks.getLength(); n++) {
						Block block = new Block();
						block.id = blocks.item(n).getAttributes()
								.getNamedItem(KEY_ID).getNodeValue().toString();

						block.rotation = Integer.parseInt(blocks.item(n)
								.getAttributes().getNamedItem(KEY_ROTATION)
								.getNodeValue().toString());
						block.x = Integer.parseInt(blocks.item(n)
								.getAttributes().getNamedItem(KEY_X)
								.getNodeValue().toString());
						block.y = Integer.parseInt(blocks.item(n)
								.getAttributes().getNamedItem(KEY_Y)
								.getNodeValue().toString());
						ListBlock.add(block);
					}
					level.blocks = ListBlock;
					ListLevel.add(level);
				}

				chapter.levels = ListLevel;

				ListChapter.add(chapter);
			}

			world.chapters = ListChapter;

			ListWorld.add(world);
		}
		return ListWorld;
	}
}
