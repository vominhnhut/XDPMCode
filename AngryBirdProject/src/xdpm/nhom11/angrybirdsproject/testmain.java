package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.SmoothCamera;
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

import entities.pack.Camera2D;
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
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class testmain extends SimpleBaseGameActivity {

	private Scene mMainScene;

	Map mMap;
	TexturePackerHelper tPH;
	PhysicsEditorContent peContent;

	public Rectangle staticRect;

	Camera2D camera2D;
	SmoothCamera camera;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub

		camera2D = new Camera2D();
		camera = new SmoothCamera(0, 0, 720, 480, 800, 400, 0.3f);

		EngineOptions engine = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				camera);
		return engine;
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		mMap = new Map(this, getVertexBufferObjectManager());
	
		tPH = new TexturePackerHelper(this.getTextureManager(), this);

	}

	int indexmove = 0;

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub

		mMainScene = new Scene();
		// mMainScene.setWidth(800);
		mMainScene.setBackground(new Background(Color.CYAN));
		this.mMainScene.registerUpdateHandler(Map.mPhysicsWorld);

		camera.setBounds(0, 0, 1200, 700);
		camera.setBoundsEnabled(true);
		this.mMap.Load();
		this.mMap.Attached(mMainScene);
		this.mMap.setcamera(camera);

		// camera.setChaseEntity(mMap.getEntity());
		//
		mMainScene.setOnSceneTouchListener(mMap);
		mMainScene.registerUpdateHandler(mMap);
		// mMainScene.setOnSceneTouchListener(new IOnSceneTouchListener() {
		//
		// @Override
		// public boolean onSceneTouchEvent(Scene pScene, TouchEvent
		// pSceneTouchEvent) {
		// // TODO Auto-generated method stub
		// // camera.setCenter(pSceneTouchEvent.getX(),
		// pSceneTouchEvent.getY());
		//
		// return false;
		// }
		// });

		return mMainScene;
	}

	boolean activeblock = false;
	boolean isMove = false;
}
