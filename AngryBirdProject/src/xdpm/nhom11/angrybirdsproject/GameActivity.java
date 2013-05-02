package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.adt.color.Color;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.andengine.util.system.CPUUsage;
import org.xml.sax.Attributes;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class GameActivity extends BaseGameActivity {

	private SmoothCamera camera;

	@Override
	public Engine onCreateEngine(EngineOptions pEngineOptions) {
		// TODO Auto-generated method stub
		return new LimitedFPSEngine(pEngineOptions, 60);
	}

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		camera = new SmoothCamera(0, 0, 720, 480, 300, 300, 0.5f);
		EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(
						720, 480), this.camera);
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
//
		ResourcesManager.getInstance().loadBodyResource();
	//	ResourcesManager.getInstance().loadGameResources();
		pOnCreateResourcesCallback.onCreateResourcesFinished();

	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws IOException {
		// scenemanager=new SceneManager();
		Scene a = new Scene();
		a.setBackground(new Background(Color.CYAN));
		a.attachChild(new Sprite(200, 200,
				TexturePackerHelper.play_btn_TiledTexture,
				getVertexBufferObjectManager()));
		SceneManager.getInstance().setCallback(pOnCreateSceneCallback);
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
