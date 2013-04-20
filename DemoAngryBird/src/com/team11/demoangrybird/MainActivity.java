package com.team11.demoangrybird;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.modifier.JumpModifier;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.util.Vector2Pool;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;
import org.andengine.util.debug.Debug;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;

public class MainActivity extends SimpleBaseGameActivity {
	static final int CAMERA_WIDTH = 800;
	static final int CAMERA_HEIGHT = 480;

	private Camera mCamera;
	private Scene mMainScene;

	private TextureRegion mtext;
	private TexturePackTextureRegionLibrary texturePackLibrary;
	private TexturePack texturePack;
	private BitmapTextureAtlas mBitmapTextureAtlas;

	// TiledTexureRegion Sprites
	private TiledTextureRegion black_Bird_TiledTexture;
	private TiledTextureRegion blue_Bird_TiledTexture;
	private TiledTextureRegion helmet_Pig_TiledTexture;
	private TiledTextureRegion king_Big_TiledTexture;
	private TiledTextureRegion large_Pig_TiledTexture;
	private TiledTextureRegion medium_Pig_TiledTexture;
	private TiledTextureRegion old_Pig_TiledTexture;
	private TiledTextureRegion red_Bird_TiledTexture;
	private TiledTextureRegion sling_TiledTexture;
	private TiledTextureRegion slingshot_TiledTexture;
	private TiledTextureRegion small_Pig_TiledTexture;
	private TiledTextureRegion white_Bird_Egg_TiledTexture;
	private TiledTextureRegion white_Bird_TiledTexture;
	private TiledTextureRegion yellow_Bird_TiledTexture;

	// TiledTextureRegion Background
	private TiledTextureRegion BackGround_TiledTexture;
	private TiledTextureRegion Earth_TiledTexture;

	// TiledTextureRegion Rock
	private TiledTextureRegion CirBig_ice_TiledTexture;
	private TiledTextureRegion CirBig_rock_TiledTexture;
	private TiledTextureRegion CirBig_wood_TiledTexture;
	private TiledTextureRegion CirMedium_ice_TiledTexture;
	private TiledTextureRegion CirMedium_rock_TiledTexture;
	private TiledTextureRegion CirMedium_wood_TiledTexture;
	private TiledTextureRegion RecEmpty_ice_TiledTexture;
	private TiledTextureRegion RecEmpty_rock_TiledTexture;
	private TiledTextureRegion RecEmpty_wood_TiledTexture;
	private TiledTextureRegion RecFull_ice_TiledTexture;
	private TiledTextureRegion RecFull_roc_TiledTexture;
	private TiledTextureRegion RecFull_wood_TiledTexture;
	private TiledTextureRegion RecLong_ice_TiledTexture;
	private TiledTextureRegion RecLong_rock_TiledTexture;
	private TiledTextureRegion RecLong_wood_TiledTexture;
	private TiledTextureRegion RecMedium_ice_TiledTexture;
	private TiledTextureRegion RecMedium_rock_TiledTexture;
	private TiledTextureRegion RecMedium_wood_TiledTexture;
	private TiledTextureRegion RecShort_ice_TiledTexture;
	private TiledTextureRegion RecShort_rock_TiledTexture;
	private TiledTextureRegion RecShort_wood_TiledTexture;
	private TiledTextureRegion RecShortest_ice_TiledTexture;
	private TiledTextureRegion RecShortest_rock_TiledTexture;
	private TiledTextureRegion RecShortest_wood_TiledTexture;
	private TiledTextureRegion SquareMedium_ice_TiledTexture;
	private TiledTextureRegion SquareMedium_rock_TiledTexture;
	private TiledTextureRegion SquareMedium_wood_TiledTexture;
	private TiledTextureRegion SquareSmall_ice_TiledTexture;
	private TiledTextureRegion SquareSmall_rock_TiledTexture;
	private TiledTextureRegion SquareSmall_wood_TiledTexture;
	private TiledTextureRegion TriaEmpty_ice_TiledTexture;
	private TiledTextureRegion TriaEmpty_rock_TiledTexture;
	private TiledTextureRegion TriaEmpty_wood_TiledTexture;
	private TiledTextureRegion TriaFull_ice_TiledTexture;
	private TiledTextureRegion TriaFull_rock_TiledTexture;
	private TiledTextureRegion TriaFull_wood_TiledTexture;
	private TiledTextureRegion other_1_TiledTexture;
	private TiledTextureRegion other_2_TiledTexture;
	private TiledTextureRegion other_3_TiledTexture;

	int nSprites = 5;
	Sprite[] sprite_SquareMedium_wood;
	Sprite[] sprite_RecShort_wood;
	Body[] body_sprite_RecShort_wood;
	Body[] body_sprite_SquareMedium_wood;

	// CÁC BIẾN ĐƯỢC SỬ DỤNG
	private boolean isDrawing = false;
	// Sprite sprite1 = null;
	float TouchX = 0;
	float TouchY = 0;
	public PhysicsConnector phyconnect = null;
	public boolean istouchScene = false;
	public PhysicsWorld physicworld;
	public Rectangle staticRect;
	public Body dynamicBody = null;
	public Body staticBody;
	final FixtureDef boxFixtureDef = PhysicsFactory.createFixtureDef(20f, 0.3f,	0.9f);

	// PHẦN DÙNG VẼ NÁ
	static float px = 200;
	static float py = 110;
	static final float MAX_DISTANCE = 100f;
	public static final Vector2 SLINGSHOT_CENTER = new Vector2(300 - px, 300 - py);

	private TextureRegion textureRegion1, textureRegion2, textureRegion3, angryBird_textureRegion;

	// CHiM TRÊN NÁ
	Body bodychim = null;
	public float distance; // khoang cach tu chim den tam cua na.
	private boolean isClick = true;
	private Line line1, line2;
	private Vector2 endPoint = new Vector2();
	boolean isScene = false;
	
	@Override
	public EngineOptions onCreateEngineOptions() {

		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engine = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),this.mCamera);
		return engine;
	}

	void loadTiledTextureSprites() {
		try {
			texturePack = new TexturePackLoader(getTextureManager(), "gfx/").loadFromAsset(getAssets(), "Sprites.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
		} catch (TexturePackParseException e) 
		{
			Debug.e(e);
		}

		black_Bird_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.BLACK_BIRD_ID, 7, 1);
		blue_Bird_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.BLUE_BIRD_ID, 4, 1);
		red_Bird_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.RED_BIRD_ID, 5, 1);
		white_Bird_Egg_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.WHITE_BIRD_EGG_ID, 1, 1);
		white_Bird_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.WHITE_BIRD_ID, 1, 1);
		yellow_Bird_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.YELLOW_BIRD_ID, 6, 1);
		
		helmet_Pig_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.HELMET_PIG_ID, 9, 1);
		king_Big_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.KING_PIG_ID, 9, 1);
		large_Pig_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.LARGE_PIG_ID, 9, 1);
		medium_Pig_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.MEDIUM_PIG_ID, 9, 1);
		old_Pig_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.OLD_PIG_ID, 9, 1);
		small_Pig_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.SMALL_PIG_ID, 9, 1);
		
		sling_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.SLING_ID, 1, 1);
		slingshot_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MySprites.SLINGSHOT_ID, 2, 1);		
	}

	void loadTiledTextureBlocks() {
		try {
			texturePack = new TexturePackLoader(getTextureManager(), "gfx/").loadFromAsset(getAssets(), "Blocks.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) 
		{
			Debug.e(e);
		}
		CirBig_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRBIG_ICE_ID, 4, 1);
		CirBig_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRBIG_ROCK_ID, 4, 1);
		CirBig_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRBIG_WOOD_ID, 4, 1);
		CirMedium_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRMEDIUM_ICE_ID, 4, 1);
		CirMedium_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRMEDIUM_ROCK_ID, 4, 1);
		CirMedium_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.CIRMEDIUM_WOOD_ID, 4, 1);
		
		RecEmpty_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECEMPTY_ICE_ID, 4, 1);
		RecEmpty_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECEMPTY_ROCK_ID, 4, 1);
		RecEmpty_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECEMPTY_ROCK_ID, 4, 1);
		
		RecFull_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECFULL_ICE_ID, 4, 1);
		RecFull_roc_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECFULL_ROCK_ID, 4, 1);
		RecFull_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECFULL_WOOD_ID, 4, 1);
		
		RecLong_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECLONG_ICE_ID, 4, 1);
		RecLong_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECLONG_ROCK_ID, 4, 1);
		RecLong_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECLONG_WOOD_ID, 4, 1);
		
		RecMedium_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECMEDIUM_ICE_ID, 4, 1);
		RecMedium_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECLONG_ROCK_ID, 4, 1);
		RecMedium_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECMEDIUM_WOOD_ID, 4, 1);
		
		RecShort_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORT_ICE_ID, 4, 1);
		RecShort_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORT_ROCK_ID, 4, 1);
		RecShort_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORT_WOOD_ID, 4, 1);
		RecShortest_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORTEST_ICE_ID, 4, 1);
		RecShortest_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORTEST_ROCK_ID, 4, 1);
		RecShortest_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.RECSHORTEST_WOOD_ID, 4, 1);
		
		SquareMedium_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUAREMEDIUM_ICE_ID, 4, 1);
		SquareMedium_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUAREMEDIUM_ROCK_ID, 4, 1);
		SquareMedium_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUAREMEDIUM_WOOD_ID, 4, 1);
		
		SquareSmall_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUARESMALL_ICE_ID, 4, 1);
		SquareSmall_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUARESMALL_ROCK_ID, 4, 1);
		SquareSmall_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.SQUARESMALL_WOOD_ID, 4, 1);
		
		TriaEmpty_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAEMPTY_ICE_ID, 4, 1);
		TriaEmpty_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAEMPTY_ROCK_ID, 4, 1);
		TriaEmpty_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAEMPTY_WOOD_ID, 4, 1);
		
		TriaFull_ice_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAFULL_ICE_ID, 4, 1);
		TriaFull_rock_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAFULL_ROCK_ID, 4, 1);
		TriaFull_wood_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.TRIAFULL_WOOD_ID, 4, 1);
		
		other_1_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.OTHER_1_ID, 1, 1);
		other_2_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.OTHER_2_ID, 1, 1);
		other_3_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBlocks.OTHER_3_ID, 1, 1);
	}

	void loadTiledTextureBackGrounds() {
		try {
			texturePack = new TexturePackLoader(getTextureManager(), "gfx/").loadFromAsset(getAssets(), "BackGrounds.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
		} 
		catch (TexturePackParseException e) 
		{
			Debug.e(e);
		}

		BackGround_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBackGrounds.BACKGROUND_ID, 1, 1);
		Earth_TiledTexture = (TiledTextureRegion) texturePackLibrary.get(MyBackGrounds.EARTH_ID, 1, 1);
	}

	@Override
	protected void onCreateResources() 
	{
		loadTiledTextureSprites();
		loadTiledTextureBlocks();
		loadTiledTextureBackGrounds();

		// Load Ná, Chim
		angryBird_textureRegion = (TextureRegion) red_Bird_TiledTexture.getTextureRegion(0);
		textureRegion1 = (TextureRegion) slingshot_TiledTexture.getTextureRegion(0);
		textureRegion2 = (TextureRegion) slingshot_TiledTexture.getTextureRegion(1);
		textureRegion3 = (TextureRegion) sling_TiledTexture.getTextureRegion(0);
	}

	// Sprite sprite;

	private void createPhysicWorld() {
		// TẠO THẾ GIỚI VẬT LÝ
		this.physicworld = new PhysicsWorld(new Vector2(0, -10), false);
		this.mMainScene.registerUpdateHandler(this.physicworld);
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		this.mMainScene = new Scene();
		
		createPhysicWorld();

		//ĐƯỜNG BAY
		
		// LOAD BACKGROUND
		ParallaxBackground background = new ParallaxBackground(0.569f, 0.796f, 0.871f);		
		Sprite spriteBackGround = new Sprite(CAMERA_HEIGHT / 2,(CAMERA_WIDTH / 2)-230,
				(TextureRegion) BackGround_TiledTexture.getTextureRegion(0), getVertexBufferObjectManager());

		Sprite spriteEarth = new Sprite(0,-80,
				(TextureRegion) Earth_TiledTexture.getTextureRegion(0),getVertexBufferObjectManager());

		background.attachParallaxEntity(new ParallaxEntity(10, spriteBackGround));		
		background.attachParallaxEntity(new ParallaxEntity(10, spriteEarth));		
		mMainScene.setBackground(background);
		
		// VẼ CÁI NÁ
		final SlingShot NA;
		
		NA = new SlingShot(textureRegion1, textureRegion2, textureRegion3, getVertexBufferObjectManager(), mMainScene);
		final Bird_red bird = new Bird_red(NA.SLINGSHOT_CENTER.x, NA.SLINGSHOT_CENTER.y, 
											angryBird_textureRegion, 
											getVertexBufferObjectManager(), this.mMainScene);
		IOnSceneTouchListener touchScene = new IOnSceneTouchListener() {
			
			@Override
			public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
				// TODO Auto-generated method stub
			
					NA.setSlingShot(pSceneTouchEvent,bird.body,isScene);
				return false;
			}
		};

		mMainScene.setOnSceneTouchListener(touchScene);
		

		mMainScene.registerUpdateHandler(new IUpdateHandler() {
			
			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onUpdate(float pSecondsElapsed) {
				// TODO Auto-generated method stub
				if(NA.isShoot == true)
				{
					bird.Shoot(NA.SLINGSHOT_CENTER, NA.touch);
					NA.isShoot = false;	
				}
			}
		});

		// CHIM với ná
		bird.CreateBody(physicworld);
		
		// TẠO MẶT ĐẤT
		staticRect = new Rectangle(500f, 20f, 1000f, 5f, getVertexBufferObjectManager());
		staticRect.setColor(0f, 0f, 0.7f);
		staticRect.setAlpha(0);
		this.mMainScene.attachChild(staticRect);
		staticBody = PhysicsFactory.createBoxBody(physicworld, staticRect,BodyType.StaticBody, boxFixtureDef);

	
		//VẼ GỖ VUÔNG
		final SquareMedium_wood[] go_vuong = new SquareMedium_wood[nSprites];
		for(int i=0; i<nSprites; i++)
		{
			go_vuong[i] = new SquareMedium_wood(400, 10 + i * nSprites, 
												SquareMedium_wood_TiledTexture.getTextureRegion(0), 
												getVertexBufferObjectManager(),this.mMainScene);
			go_vuong[i].CreateBody_bird(physicworld);
		}
		
		//VẼ GỖ DÀI
		RecShort_wood[] go_dai = new RecShort_wood[nSprites];
		for(int i=0; i<nSprites; i++)
		{
			go_dai[i] = new RecShort_wood(500 + i * 2,10 + i * nSprites, 
											RecShort_wood_TiledTexture.getTextureRegion(0), 
											getVertexBufferObjectManager(), this.mMainScene);
			go_dai[i].CreateBody_bird(physicworld);
		}
		
		//Xử lí khi va chạm		
			
		return this.mMainScene;
	}

	// ĐẶT VỊ TRÍ CON CHIM
	private void startPositionS(Body dynamicbodyline,
			float angle, float x, float y) {
		dynamicbodyline.setActive(false);
		dynamicbodyline.setAngularVelocity(0);
		dynamicbodyline.resetMassData();
		dynamicbodyline.setLinearVelocity(0, 0);

		final Vector2 v2 = Vector2Pool.obtain((x)/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT, (y)/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
		dynamicbodyline.setTransform(v2, angle);
		Vector2Pool.recycle(v2);
	}
	
	//xác định 1 body va chạm đầu tiên
	public boolean isBodyContacted(Body pBody, Contact pContact)
	{
		if(pContact.getFixtureA().getBody().equals(pBody) ||
			pContact.getFixtureB().getBody().equals(pBody))
			return true;
		
		return false;
	}
	
	//xác định 2 body nào va chạm
	public boolean areBodiesContacted(Body pBody1, Body pBody2, Contact pContact)
	{
		if(pContact.getFixtureA().getBody().equals(pBody1) ||
			pContact.getFixtureB().getBody().equals(pBody1))
			{
				if(pContact.getFixtureA().getBody().equals(pBody2) ||
					pContact.getFixtureB().getBody().equals(pBody2))
					return true;
			}
		
		return false;
	}
}
