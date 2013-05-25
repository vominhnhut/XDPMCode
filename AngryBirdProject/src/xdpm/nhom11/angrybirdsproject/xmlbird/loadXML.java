package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.util.ArrayList;
import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import xdpm.nhom11.angrybirdsproject.manager.Game;

public class loadXML {

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

	public static ArrayList<DTOWorld> loadWorld() {
		final SimpleLevelLoader worldLoader = new SimpleLevelLoader(
				Game.getInstance().vbom);

		final SimpleLevelLoader birdLoader = new SimpleLevelLoader(
				Game.getInstance().vbom);

		final SimpleLevelLoader pigLoader = new SimpleLevelLoader(
				Game.getInstance().vbom);

		final SimpleLevelLoader blockLoader = new SimpleLevelLoader(
				Game.getInstance().vbom);

		final ArrayList<DTOWorld> ListWorld = new ArrayList<DTOWorld>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_LISTWORLD) {
		//
		// @Override
		// public IEntity onLoadEntity(String pEntityName,
		// IEntity pParent, Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		//
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_WORLD) {
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOWorld world = new DTOWorld();
		// world.id = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes, KEY_ID);
		// world.locked = SAXUtils
		// .getBooleanAttributeOrThrow(
		// pAttributes, KEY_LOCKED);
		//
		// // //////////////////////////////////////////////////////
		// final ArrayList<DTOChapter> ListChapter = new
		// ArrayList<DTOChapter>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_CHAPTER) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOChapter chapter = new DTOChapter();
		// chapter.id = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		//
		// // ////////////////////////////////////////////////////////////
		// final ArrayList<DTOLevel> ListLevel = new ArrayList<DTOLevel>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_LEVEL) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOLevel level = new DTOLevel();
		// level.id = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// level.locked = SAXUtils
		// .getBooleanAttributeOrThrow(
		// pAttributes,
		// KEY_LOCKED);
		// level.highscore = SAXUtils
		// .getDoubleAttributeOrThrow(
		// pAttributes,
		// KEY_HIGHSCORE);
		// level.numstar = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_NUMSTAR);
		// level.width = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_WIDTH);
		// level.height = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_HEIGHT);
		// level.bgcolor = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_BGCOLOR);
		//
		// final DTOBackground backgound = new DTOBackground();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_BACKGROUND) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// backgound.id = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		//
		// return null;
		// }
		// });
		//
		// final DTOSlingShot slingshot = new DTOSlingShot();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_SLINGSHOT) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		//
		// slingshot.x = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_X);
		// slingshot.y = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_Y);
		// return null;
		// }
		// });
		//
		// final ArrayList<DTOBird> ListBird = new ArrayList<DTOBird>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_BIRD) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOBird bird = new DTOBird();
		// bird.id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// bird.x = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_X);
		// bird.y = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_Y);
		// birdLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_LISTBIRD) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		//
		// birdLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_BIRD) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// String id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// Integer finalscore = SAXUtils
		// .getIntAttributeOrThrow(
		// pAttributes,
		// KEY_FINALSCORE);
		//
		// if (bird.id
		// .equals(id)) {
		// bird.finalscore = finalscore;
		// }
		// return null;
		// }
		// });
		// return null;
		// }
		// });
		// ListBird.add(bird);
		// return null;
		// }
		// });
		//
		// final ArrayList<DTOPig> ListPig = new ArrayList<DTOPig>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_PIG) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOPig pig = new DTOPig();
		// pig.id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// pig.x = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_X);
		// pig.y = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_Y);
		// pigLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_LISTPIG) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		//
		// pigLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_PIG) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// String id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// Float lifevalue = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_LIFEVALUE);
		// Float score = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_SCORE);
		//
		// if (pig.id
		// .equals(id)) {
		// pig.lifevalue = lifevalue;
		// pig.score = score;
		// }
		// return null;
		// }
		// });
		// return null;
		// }
		// });
		//
		// ListPig.add(pig);
		// return null;
		// }
		// });
		//
		// final ArrayList<DTOBlock> ListBlock = new ArrayList<DTOBlock>();
		// worldLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_BLOCK) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// final DTOBlock block = new DTOBlock();
		// block.id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// block.type = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_TYPE);
		// block.rotation = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_ROTATION);
		// block.x = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_X);
		// block.y = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_Y);
		// blockLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_LISTBlOCK) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		//
		// blockLoader
		// .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
		// TAG_BLOCK) {
		//
		// @Override
		// public IEntity onLoadEntity(
		// String pEntityName,
		// IEntity pParent,
		// Attributes pAttributes,
		// SimpleLevelEntityLoaderData pEntityLoaderData)
		// throws IOException {
		// String id = SAXUtils
		// .getAttributeOrThrow(
		// pAttributes,
		// KEY_ID);
		// Float lifevalue = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_LIFEVALUE);
		// Float score = SAXUtils
		// .getFloatAttributeOrThrow(
		// pAttributes,
		// KEY_SCORE);
		//
		// if (block.id
		// .equals(id)) {
		// block.lifevalue = lifevalue;
		// block.score = score;
		// }
		// return null;
		// }
		// });
		//
		// return null;
		// }
		// });
		//
		// ListBlock
		// .add(block);
		//
		// return null;
		// }
		// });
		//
		// level.background = backgound;
		// level.slingshot = slingshot;
		// level.birds = ListBird;
		// level.pigs = ListPig;
		// level.blocks = ListBlock;
		//
		// ListLevel
		// .add(level);
		//
		// return null;
		//
		// }
		// });
		// chapter.levels = ListLevel;
		// ListChapter
		// .add(chapter);
		// return null;
		// }
		// });
		// world.chapters = ListChapter;
		// ListWorld.add(world);
		// return null;
		// }
		// });
		// return null;
		// }
		//
		// });
		worldLoader.loadLevelFromAsset(Game.getInstance().activity.getAssets(),
				"gfx/dataxml/WORLD.xml");

		birdLoader.loadLevelFromAsset(Game.getInstance().activity.getAssets(),
				"gfx/dataxml/BIRD.xml");

		pigLoader.loadLevelFromAsset(Game.getInstance().activity.getAssets(),
				"gfx/dataxml/PIG.xml");

		blockLoader.loadLevelFromAsset(Game.getInstance().activity.getAssets(),
				"gfx/dataxml/BLOCK.xml");

		return ListWorld;
	}
}
