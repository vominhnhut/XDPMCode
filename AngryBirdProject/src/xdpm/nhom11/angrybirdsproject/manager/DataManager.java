package xdpm.nhom11.angrybirdsproject.manager;

import java.io.IOException;
import java.util.ArrayList;
import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;
import xdpm.nhom11.angrybirdsproject.xmlbird.DAOBird;
import xdpm.nhom11.angrybirdsproject.xmlbird.DAOBlock;
import xdpm.nhom11.angrybirdsproject.xmlbird.DAOPig;
import xdpm.nhom11.angrybirdsproject.xmlbird.DAOWorld;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOBird;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOBlock;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOChapter;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOLevel;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOPig;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOWorld;
import android.app.Activity;
import android.util.Log;

/**
 * lớp quản lý dữ liệu
 * 
 * @author Hoa Phat
 * 
 */
/**
 * @author Hoa Phat
 * 
 */
public class DataManager {
    private static final DataManager INSTANCE = new DataManager();

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

    final SimpleLevelLoader worldLoader = new SimpleLevelLoader(null);

    /**
     * danh sách mảng các world
     */
    public ArrayList<DTOWorld> DTOListWorld;
    /**
     * danh sách mảng các chim
     */
    private ArrayList<DTOBird> DTOListBird;
    /**
     * danh sách mảng các pig
     */
    private ArrayList<DTOPig> DTOListPig;
    /**
     * danh sách mảng các block
     */
    private ArrayList<DTOBlock> DTOListBlock;

    /**
     * world đã và đang được chọn
     */
    public int currentWorldChoosed = -1;
    /**
     * Chapter đã và đang được chọn
     */
    public int currentChapterChoosed = 0;
    /**
     * Level đã và đang được chọn
     */
    public int currentLevelChoosed = -1;

    /**
     * load toàn bộ dữ liệu trong game
     * 
     * @param game
     */
    public void load(Activity game) {

        loadBird(game);

        loadPig(game);

        loadBlock(game);

        loadWorld(game);

        // for (World w : ListWorld) {
        // Log.e("WORLD", w.getID() + "");
        // for (Chapter ch : w.getListChapter()) {
        // Log.e("CHAPTER", ch.getID() + "");
        // for (Level lv : ch.getListLevel()) {
        // Log.e("LEVEL", lv.getID() + "");
        //
        // }
        // }
        // }
    }

    private void loadWorld(Activity game) {

        worldLoader
                .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
                        TAG_LISTWORLD) {

                    @Override
                    public IEntity onLoadEntity(String pEntityName,
                            IEntity pParent, Attributes pAttributes,
                            SimpleLevelEntityLoaderData pEntityLoaderData)
                            throws IOException {

                        worldLoader
                                .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
                                        TAG_WORLD) {
                                    @Override
                                    public IEntity onLoadEntity(
                                            String pEntityName,
                                            IEntity pParent,
                                            Attributes pAttributes,
                                            SimpleLevelEntityLoaderData pEntityLoaderData)
                                            throws IOException {
                                        // TODO Auto-generated method stub
                                        DTOWorld dtoworld = new DTOWorld();
                                        dtoworld.id = SAXUtils
                                                .getAttributeOrThrow(
                                                        pAttributes, KEY_ID);
                                        dtoworld.locked = SAXUtils
                                                .getBooleanAttribute(
                                                        pAttributes,
                                                        KEY_LOCKED, false);

                                        return null;
                                    }
                                });
                        DTOListWorld = DAOWorld.load(worldLoader);

                        return null;
                    }

                });

        //

        worldLoader.loadLevelFromAsset(game.getAssets(),
                "gfx/dataxml/WORLD.xml");

        for (DTOWorld dto : DTOListWorld) {
            Log.e("WORLD", dto.id + "");
            for (DTOChapter chapter : dto.chapters) {
                Log.e("CHAPTER", chapter.id + "");
                for (DTOLevel lv : chapter.levels) {
                    Log.e("LEVEL", lv.id + "");
                    Log.e("SLINGSHOT", lv.slingshot + "/" + lv.slingshot.x);
                    for (DTOBird bird : lv.birds) {

                        for (DTOBird b : this.DTOListBird) {
                            Log.e(b.id, bird.id);

                            if (bird.id.equalsIgnoreCase(b.id)) {

                                bird.finalscore = b.finalscore;

                                break;
                            }
                        }

                    }
                    for (DTOPig pig : lv.pigs) {
                        for (DTOPig p : this.DTOListPig) {
                            Log.e(p.id, pig.id);

                            if (pig.id.equalsIgnoreCase(p.id)) {

                                pig.lifevalue = p.lifevalue;
                                pig.score = p.score;

                                break;
                            }
                        }
                    }
                    for (DTOBlock block : lv.blocks) {
                        for (DTOBlock bl : this.DTOListBlock) {

                            if (block.id.equalsIgnoreCase(bl.id)) {

                                block.lifevalue = bl.lifevalue;
                                block.score = bl.score;

                                break;
                            }
                        }
                    }

                }
            }
        }

    }

    /**
     * load thông tin các chim
     * 
     * @param game
     */
    private void loadBird(Activity game) {

        final SimpleLevelLoader BirdLoader = new SimpleLevelLoader(null);

        BirdLoader
                .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
                        TAG_LISTBIRD) {
                    @Override
                    public IEntity onLoadEntity(String pEntityName,
                            IEntity pParent, Attributes pAttributes,
                            SimpleLevelEntityLoaderData pEntityLoaderData)
                            throws IOException {
                        // TODO Auto-generated method stub

                        DTOListBird = DAOBird.load(BirdLoader);

                        return null;
                    }
                });

        BirdLoader.loadLevelFromAsset(game.getAssets(), "gfx/dataxml/BIRD.xml");

    }

    /**
     * load thông tin các heo
     * 
     * @param game
     */
    private void loadPig(Activity game) {
        final SimpleLevelLoader PigLoader = new SimpleLevelLoader(null);

        PigLoader
                .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
                        TAG_LISTPIG) {
                    @Override
                    public IEntity onLoadEntity(String pEntityName,
                            IEntity pParent, Attributes pAttributes,
                            SimpleLevelEntityLoaderData pEntityLoaderData)
                            throws IOException {
                        // TODO Auto-generated method stub

                        DTOListPig = DAOPig.load(PigLoader);

                        return null;
                    }
                });

        PigLoader.loadLevelFromAsset(game.getAssets(), "gfx/dataxml/PIG.xml");
    }

    /**
     * load thông tin các vật cản
     * 
     * @param game
     */
    private void loadBlock(Activity game) {
        final SimpleLevelLoader BlockLoader = new SimpleLevelLoader(null);

        BlockLoader
                .registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
                        TAG_LISTBlOCK) {
                    @Override
                    public IEntity onLoadEntity(String pEntityName,
                            IEntity pParent, Attributes pAttributes,
                            SimpleLevelEntityLoaderData pEntityLoaderData)
                            throws IOException {
                        // TODO Auto-generated method stub

                        DTOListBlock = DAOBlock.load(BlockLoader);

                        return null;
                    }
                });

        BlockLoader.loadLevelFromAsset(game.getAssets(),
                "gfx/dataxml/BLOCK.xml");
    }

    //
    // private void convertToObject() {
    // ListWorld = new ArrayList<World>();
    // for (DTOWorld dtoworld : DTOListWorld) {
    // World worldTemp = new World(dtoworld);
    //
    // for (DTOChapter dtochapter : dtoworld.chapters) {
    // Chapter chapterTemp = new Chapter(dtochapter);
    //
    // for (DTOLevel dtolevel : dtochapter.levels) {
    // Level levelTemp = new Level(dtolevel);
    //
    // // levelTemp.setSlingshot(dtolevel.getSlingshot());
    //
    // // for (DTOBird dtobird : dtolevel.birds) {
    // //
    // // for (DTOBird b : DataManager.DTOListBird) {
    // //
    // // if (dtobird.id.equalsIgnoreCase(b.id)) {
    // //
    // // dtobird.finalscore = b.finalscore;
    // //
    // // break;
    // // }
    // // }
    // //
    // // levelTemp.addBird(dtobird.getBird());
    // //
    // // }
    // // for (DTOPig dtopig : dtolevel.pigs) {
    // // for (DTOPig p : DataManager.DTOListPig) {
    // // Log.e(p.id, dtopig.id);
    // //
    // // if (dtopig.id.equalsIgnoreCase(p.id)) {
    // //
    // // dtopig.lifevalue = p.lifevalue;
    // // dtopig.score = p.score;
    // //
    // // break;
    // // }
    // // }
    // // levelTemp.addPig(dtopig.getPig());
    // // }
    // // for (DTOBlock dtoblock : dtolevel.blocks) {
    // // for (DTOBlock bl : DataManager.DTOListBlock) {
    // //
    // // if (dtoblock.id.equalsIgnoreCase(bl.id)) {
    // //
    // // dtoblock.lifevalue = bl.lifevalue;
    // // dtoblock.score = bl.score;
    // //
    // // break;
    // // }
    // // }
    // // levelTemp.addBlock(dtoblock.getObjectGame());
    // // }
    // chapterTemp.addLevel(levelTemp);
    //
    // }
    // worldTemp.addChapter(chapterTemp);
    //
    // }
    //
    // ListWorld.add(worldTemp);
    // }
    // }

    /**
     * @return
     */
    public static DataManager getInstance() {
        return INSTANCE;
    }
}
