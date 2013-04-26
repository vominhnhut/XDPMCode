package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
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
import org.andengine.input.touch.TouchEvent;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import entities.pack.GameObject;
import entities.pack.Map;
import entities.pack.Slingshot;

import xdpm.nhom11.angrybirdsproject.bird.Bird;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

public class testmain extends SimpleBaseGameActivity {

	static final int CAMERA_WIDTH = 720;
	static final int CAMERA_HEIGHT = 480;

	private Camera mCamera;
	private Scene mMainScene;

	Map mMap;
	TexturePackerHelper tPH;
	PhysicsEditorContent peContent;


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
		mMap = new Map(this,getVertexBufferObjectManager());
		peContent = new PhysicsEditorContent(this);
		tPH = new TexturePackerHelper(this, this);

		
	

	}

	int index = 0;

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub

		mMainScene = new Scene();
		mMainScene.setBackground(new Background(Color.CYAN));
		this.mMainScene.registerUpdateHandler(Map.mPhysicsWorld);
		
		this.mMap.Load();
		this.mMap.Attached(mMainScene);

		//
	

		

		
		

		// bird[1].setTransform(new Vector2(200, 500), 0);
		mMainScene.setOnSceneTouchListener(mMap);
		return mMainScene;
	}

	boolean activeblock = false;

}
