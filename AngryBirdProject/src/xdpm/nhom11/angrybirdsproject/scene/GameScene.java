package xdpm.nhom11.angrybirdsproject.scene;

import java.io.IOException;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.adt.color.Color;

import entities.pack.Map;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class GameScene extends BaseScene {

	Map mMap;
	Sound mSound;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createHUD();
		this.resourcesManager.camera.setBounds(0, 0, 1200, 700);
		this.resourcesManager.camera.setBoundsEnabled(true);
		mMap = new Map(activity, vbom);

		this.setBackground(new Background(Color.CYAN));
		this.registerUpdateHandler(Map.mPhysicsWorld);

		this.mMap.Load();
		this.mMap.Attached(this);

		this.mMap.setcamera(this.resourcesManager.camera);

		try {
			mSound = SoundFactory.createSoundFromAsset(
					this.engine.getSoundManager(), activity,
					"audio/sfx/bluebird_flying.wav");
			mSound.setLooping(false);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.resourcesManager.camera.setChaseEntity(mMap.getEntity());
		//
		this.setOnSceneTouchListener(mMap);
		// resourcesManager.engine = new Engine(new EngineOptions(true,
		// ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
		// smoothCamera));
		this.registerUpdateHandler(mMap);
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	public void createHUD() {
		HUD gameHUD = new HUD();

		camera.setHUD(gameHUD);
		Text score = new Text(100, 100, resourcesManager.font, "ANGRY BIRDS",
				vbom);
		gameHUD.attachChild(score);
	}
	@Override
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
	//	SoundHelper.level_start_military.play();
	
		return super.onSceneTouchEvent(pSceneTouchEvent);
	}
	

}
