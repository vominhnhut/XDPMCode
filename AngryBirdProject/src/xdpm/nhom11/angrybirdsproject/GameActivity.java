package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.adt.color.Color;
import org.andengine.util.system.CPUUsage;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class GameActivity extends BaseGameActivity {

	
	private Camera camera;

	@Override
	public Engine onCreateEngine(EngineOptions pEngineOptions) {
		// TODO Auto-generated method stub
		return new LimitedFPSEngine(pEngineOptions, 60);
	}

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		camera = new Camera(0, 0, 800, 480);
		EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(
						800, 480), this.camera);
		engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		return engineOptions;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws IOException {

		ResourcesManager.prepareManager(getEngine(), this, camera,
				getVertexBufferObjectManager());
		ResourcesManager.getInstance().loadResource();
		pOnCreateResourcesCallback.onCreateResourcesFinished();

	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws IOException {
		// scenemanager=new SceneManager();
		Scene a = new Scene();
		a.setBackground(new Background(Color.CYAN));
		a.attachChild(new Sprite(
				200,
				200,
				ResourcesManager.getInstance().texturepackerhelper.play_btn_TiledTexture,
				getVertexBufferObjectManager()));
		SceneManager.getInstance().setCallback(pOnCreateSceneCallback);		// Sprite a=new GameActivity(
		// TODO Auto-generated method stub
		SceneManager.getInstance().createMenuScene();
		

	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback)
			throws IOException {
		// TODO Auto-generated method stub
		pOnPopulateSceneCallback.onPopulateSceneFinished();

	}

}
