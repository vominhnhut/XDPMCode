package xdpm.nhom11.angrybirdsproject.manager;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;

import android.graphics.Color;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

/**
 * lớp quản lý resource
 * 
 * @author Hoa Phat
 * 
 */
public class ResourcesManager {

    /**
     * mẫu singleton
     */
    private static final ResourcesManager INSTANCE = new ResourcesManager();

    /**
     * texturepacker chứa resource
     */
    public TexturePackerHelper texturepackerhelper;
    /**
     * font sử dụng trong game
     */
    public Font font;
    /**
     * load body cho chim,heo
     */
    public PhysicsEditorShapeLibrary physicseditorbirdandpig = new PhysicsEditorShapeLibrary();;
    /**
     * load body cho vật cản
     */
    public PhysicsEditorShapeLibrary physicseditorblock = new PhysicsEditorShapeLibrary();;

    /**
     * load toàn bộ tài nguyên của game
     */
    public void loadResource() {

        Game.getInstance().engine.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                loadGameGraphics();
                loadGameAudio();
                loadGameFonts();
                loadBodyResource();
            }
        });

    }

    /**
     * load body các thực thể trong game
     */
    public void loadBodyResource() {

        physicseditorbirdandpig.open(Game.getInstance().activity,
                "gfx/body/BIRDANDPIG_BODY.xml");

        physicseditorblock.open(Game.getInstance().activity,
                "gfx/body/BLOCK_BODY.xml");
    }

    /**
     * load tài nguyên hình ảnh trong game
     */
    private void loadGameGraphics() {

        // TODO Auto-generated method stub

        texturepackerhelper.Load(
                Game.getInstance().activity.getTextureManager(),
                Game.getInstance().activity);

    }

    /**
     * load font trong game
     */
    private void loadGameFonts() {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(
                Game.getInstance().activity.getTextureManager(), 1024, 1024,
                TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        font = FontFactory.createStrokeFromAsset(
                Game.getInstance().activity.getFontManager(), mainFontTexture,
                Game.getInstance().activity.getAssets(), "angrybirdsfont.ttf",
                50, true, Color.WHITE, 1, Color.BLACK);
        font.load();

    }

    /**
     * load âm thanh
     */
    private void loadGameAudio() {
        SoundHelper.LoadSoundEffect();

    }

    /**
     * @param engine
     * @param gameActivity
     * @param camera
     * @param vbom
     */
    public void prepareManager() {
        texturepackerhelper = new TexturePackerHelper(
                Game.getInstance().activity.getTextureManager(),
                Game.getInstance().activity);
    }

    /**
     * @return
     */
    public static ResourcesManager getInstance() {
        return INSTANCE;
    }
}
