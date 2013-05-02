package xdpm.nhom11.angrybirdsproject.resourcemanager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.graphics.Color;

import xdpm.nhom11.angrybirdsproject.GameActivity;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

public class ResourcesManager {

	private static final ResourcesManager INSTANCE = new ResourcesManager();

	public TexturePackerHelper texturepackerhelper;
	public Engine engine;
	public GameActivity activity;
	public SmoothCamera camera;
	public VertexBufferObjectManager vbom;
	public Font font;
	public PhysicsEditorShapeLibrary physicseditorbirdandpig = new PhysicsEditorShapeLibrary();;
	public PhysicsEditorShapeLibrary physicseditorblock = new PhysicsEditorShapeLibrary();;

	// ---------------------------------------------
	// TEXTURES & TEXTURE REGIONS
	// ---------------------------------------------

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------

	public void loadResource() {
		texturepackerhelper = new TexturePackerHelper(
				activity.getTextureManager(), activity);
		loadGameResources();

	}

	public void loadBodyResource() {

		physicseditorbirdandpig.open(activity, "gfx/body/BIRDANDPIG_BODY.xml");

		physicseditorblock.open(activity, "gfx/body/BLOCK_BODY.xml");
	}

	public void loadMenuResources() {
		loadMenuGraphics();
		loadMenuAudio();
	}

	public void loadGameResources() {
		loadGameGraphics();
		loadGameFonts();
		loadGameAudio();
	}

	private void loadMenuGraphics() {

	}

	private void loadMenuAudio() {

	}

	private void loadGameGraphics() {

	}

	private void loadGameFonts() {
		FontFactory.setAssetBasePath("font/");
		final ITexture mainFontTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		font = FontFactory.createStrokeFromAsset(activity.getFontManager(),
				mainFontTexture, activity.getAssets(), "angrybirdsfont.ttf",
				100, true, Color.WHITE, 2, Color.BLACK);
		font.load();

	}

	private void loadGameAudio() {
		SoundHelper.LoadSound();

	}

	public void loadSplashScreen() {

	}


	public void unloadSplashScreen() {

	}

	/**
	 * @param engine
	 * @param gameActivity
	 * @param camera
	 * @param vbom
	 * <br>
	 * <br>
	 *            We use this method at beginning of game loading, to prepare
	 *            Resources Manager properly, setting all needed parameters, so
	 *            we can latter access them from different classes (eg. scenes)
	 */
	public static void prepareManager(Engine engine, GameActivity activity,
			SmoothCamera camera, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}

	// ---------------------------------------------
	// GETTERS AND SETTERS
	// ---------------------------------------------

	public static ResourcesManager getInstance() {
		return INSTANCE;
	}
}
