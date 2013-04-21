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

	int nSprites = 5;
	Sprite[] sprite_SquareMedium_wood;
	Sprite[] sprite_RecShort_wood;
	Body[] body_sprite_RecShort_wood;
	Body[] body_sprite_SquareMedium_wood;

	// CÁC BIẾN ĐƯỢC SỬ DỤNG
	float TouchX = 0;
	float TouchY = 0;
	public PhysicsConnector phyconnect = null;
	public boolean istouchScene = false;
	public PhysicsWorld physicworld;
	public Rectangle staticRect;
	public Body staticBody;
	final FixtureDef boxFixtureDef = PhysicsFactory.createFixtureDef(20f, 0.3f,	0.9f);

	// PHẦN DÙNG VẼ NÁ
	private TextureRegion textureRegionLeft, textureRegionRight, textureRegionPart, angryBird_textureRegion;

	// CHiM TRÊN NÁ
	// khoang cach tu chim den tam cua na.
	boolean isScene = false;
	
	@Override
	public EngineOptions onCreateEngineOptions() {

		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engine = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),this.mCamera);
		return engine;
	}
	
	loadTexturePacker LoadTexturePacker;

	@Override
	protected void onCreateResources() 
	{
		LoadTexturePacker = new loadTexturePacker(this, this);
		// Load Ná, Chim
		angryBird_textureRegion = (TextureRegion) LoadTexturePacker.red_Bird_TiledTexture.getTextureRegion(0);
		textureRegionLeft = (TextureRegion) LoadTexturePacker.slingshot_TiledTexture.getTextureRegion(0);
		textureRegionRight = (TextureRegion) LoadTexturePacker.slingshot_TiledTexture.getTextureRegion(1);
		textureRegionPart = (TextureRegion) LoadTexturePacker.sling_TiledTexture.getTextureRegion(0);
	}

	// Sprite sprite;

	private void createPhysicWorld() {
		// TẠO THẾ GIỚI VẬT LÝ
		this.physicworld = new PhysicsWorld(new Vector2(0, -10), false);
		this.mMainScene.registerUpdateHandler(this.physicworld);
	}

	Sprite spriteBackGround;
	Sprite spriteEarth;
	ParallaxBackground background;
	
	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		this.mMainScene = new Scene();
		
		createPhysicWorld();
		
		// LOAD BACKGROUND
		background = new ParallaxBackground(0.569f, 0.796f,
				0.871f);

		spriteBackGround = new Sprite(CAMERA_HEIGHT / 2,(CAMERA_WIDTH / 2) - 230,
				(TextureRegion) LoadTexturePacker.BackGround_TiledTexture.getTextureRegion(0), getVertexBufferObjectManager());

		spriteEarth = new Sprite(0, -80,(TextureRegion) LoadTexturePacker.Earth_TiledTexture.getTextureRegion(0), getVertexBufferObjectManager());

		background.attachParallaxEntity(new ParallaxEntity(10, spriteBackGround));
		background.attachParallaxEntity(new ParallaxEntity(10, spriteEarth));

		mMainScene.attachChild(spriteEarth);
		mMainScene.setBackground(background);
		
		// VẼ CÁI NÁ
		final SlingShot NA;
		
		NA = new SlingShot(textureRegionLeft, textureRegionRight, textureRegionPart, getVertexBufferObjectManager(), mMainScene);
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
												LoadTexturePacker.SquareMedium_wood_TiledTexture.getTextureRegion(0), 
												getVertexBufferObjectManager(),this.mMainScene);
			go_vuong[i].CreateBody_bird(physicworld);
		}
		
		//VẼ GỖ DÀI
		RecShort_wood[] go_dai = new RecShort_wood[nSprites];
		for(int i=0; i<nSprites; i++)
		{
			go_dai[i] = new RecShort_wood(500 + i * 2,10 + i * nSprites, 
											LoadTexturePacker.RecShort_wood_TiledTexture.getTextureRegion(0), 
											getVertexBufferObjectManager(), this.mMainScene);
			go_dai[i].CreateBody_bird(physicworld);
		}
		
		//Xử lí khi va chạm		
			
		return this.mMainScene;
	}

	// ĐẶT VỊ TRÍ CON CHIM
	private void startPositionS(Body dynamicbodyline, float angle, float x, float y) {
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
