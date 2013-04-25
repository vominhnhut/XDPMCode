package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import entities.pack.GameObject;
import entities.pack.Slingshot;

import xdpm.nhom11.angrybirdsproject.bird.Bird;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

public class testmain extends SimpleBaseGameActivity {

	static final int CAMERA_WIDTH = 800;
	static final int CAMERA_HEIGHT = 480;

	private Camera mCamera;
	private Scene mMainScene;

	TexturePackerHelper tPH;
	PhysicsEditorShapeLibrary physicseditorbirdandpig;
	PhysicsEditorShapeLibrary physicseditorblock;
	PhysicsWorld physicsworld;
	FixtureDef fx;

	Bird[] bird;
	GameObject object;
	Slingshot na;
	public Rectangle staticRect;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub

		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engine = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				this.mCamera);
		return engine;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub

		physicseditorbirdandpig = new PhysicsEditorShapeLibrary();
		physicseditorbirdandpig.open(this, "gfx/body/BIRDANDPIG_BODY.xml");
		physicseditorblock = new PhysicsEditorShapeLibrary();
		physicseditorblock.open(this, "gfx/body/BLOCK_BODY.xml");
		tPH = new TexturePackerHelper(this, this);
		fx = PhysicsFactory.createFixtureDef(50, 0.4f, 0.7f);
		this.physicsworld = new PhysicsWorld(new Vector2(0, -10), false);
		bird = new Bird[5];
		bird[0] = new RedBird(physicseditorbirdandpig, physicsworld, fx);
		bird[1] = new WhiteBird(physicseditorbirdandpig, physicsworld, fx);

		bird[2] = new BlackBird(physicseditorbirdandpig, physicsworld, fx);
		bird[3] = new YellowBird(physicseditorbirdandpig, physicsworld, fx);
		bird[4] = new BlueBird(physicseditorbirdandpig, physicsworld, fx);
		
		object=new GameObject("OTHER_3",physicseditorblock,physicsworld,PhysicsFactory.createFixtureDef(500, 0.1f, 0.9f));

		
		na = new Slingshot(physicseditorbirdandpig, physicsworld, fx);
		// na.LoadResource(tPH);
		na.setPosition(new Vector2(200, 200));
		na.CreateSlingshot();
		//

		// new AnimatedSprite(200, 200, tPH.red_Bird_TiledTexture,
		// getVertexBufferObjectManager()), bd, fx, ps, rt)

	}

	int index = 0;

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub

		mMainScene = new Scene();
		mMainScene.setBackground(new Background(Color.CYAN));
		this.mMainScene.registerUpdateHandler(this.physicsworld);

		//
		bird[0].AttachChild(mMainScene);
		bird[1].AttachChild(mMainScene);
		bird[2].AttachChild(mMainScene);
		bird[4].AttachChild(mMainScene);
		bird[3].AttachChild(mMainScene);
		object.AttachChild(mMainScene);

		staticRect = new Rectangle(500f, 10f, 1000f, 5f,
				getVertexBufferObjectManager());
		staticRect.setColor(1f, 1f, 1f);
		staticRect.setAlpha(1);
		this.mMainScene.attachChild(staticRect);
		Body staticBody;
		staticBody = PhysicsFactory.createBoxBody(physicsworld, staticRect,
				BodyType.StaticBody,
				PhysicsFactory.createFixtureDef(0, 0, 0.5f));

		physicsworld.registerPhysicsConnector(new PhysicsConnector(staticRect,
				staticBody));

		physicsworld.registerPhysicsConnector(bird[0].getPhysicsConnector());
		physicsworld.registerPhysicsConnector(bird[1].getPhysicsConnector());
		physicsworld.registerPhysicsConnector(bird[2].getPhysicsConnector());
		physicsworld.registerPhysicsConnector(bird[3].getPhysicsConnector());
		physicsworld.registerPhysicsConnector(bird[4].getPhysicsConnector());
		physicsworld.registerPhysicsConnector(object.getPhysicsConnector());

		na.AttachChild(mMainScene);
		object.setTransform(new Vector2(600, 350), 0);
		bird[1].setTransform(new Vector2(500, 500), 0);
		mMainScene.setOnSceneTouchListener(new IOnSceneTouchListener() {

			@Override
			public boolean onSceneTouchEvent(Scene pScene,
					TouchEvent pSceneTouchEvent) {
				// TODO Auto-generated method stub
				na.ReadyShoot(bird[index]);
				na.UpdateTouch(pSceneTouchEvent, false);
				index++;
				if (index > 4)
					index = 0;
				return false;
			}
		});

		return mMainScene;
	}

}
