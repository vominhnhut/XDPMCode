package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;

public class SceneManager {
	// ---------------------------------------------
	// SCENES
	// ---------------------------------------------
	OnCreateSceneCallback onCreateSceneCallback;
	MenuScene menuScene;
	WorldScene worldScene;
	GameScene gameScene;
	EffectTestScene eScene;

	// ---------------------------------------------
	// VARIABLES
	// ---------------------------------------------

	private static final SceneManager INSTANCE = new SceneManager();

	private SceneType currentSceneType = SceneType.SCENE_SPLASH;

	private BaseScene currentScene;

	private Engine engine = ResourcesManager.getInstance().engine;

	public enum SceneType {
		SCENE_SPLASH, SCENE_MENU, SCENE_GAME, SCENE_LOADING, SCENE_WORLD, SCENE_LEVEL
	}

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------

	public void setScene(BaseScene scene) {
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}

	public void setScene(SceneType sceneType) {
		switch (sceneType) {
		case SCENE_MENU:

			setScene(menuScene);
			break;
		case SCENE_WORLD:
			setScene(worldScene);
			break;
		// case SCENE_SPLASH:
		// setScene(splashScene);
		// break;
		// case SCENE_LOADING:
		// setScene(loadingScene);
		// break;
		case SCENE_GAME:
			setScene(gameScene);
			break;
		default:
			break;
		}
	}

	public static SceneManager getInstance() {
		return INSTANCE;
	}

	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}

	public BaseScene getCurrentScene() {
		return currentScene;
	}

	public void setCallback(OnCreateSceneCallback onCallback) {
		this.onCreateSceneCallback = onCallback;
	}

	public void createMenuScene() {

		menuScene = new MenuScene();
		currentScene = menuScene;
		this.onCreateSceneCallback.onCreateSceneFinished(menuScene);

	}

	public void CreateWorldScene() {

		worldScene = new WorldScene();
		currentScene = worldScene;
		this.onCreateSceneCallback.onCreateSceneFinished(worldScene);
	}

	public void CreateGameScene() {

		gameScene = new GameScene();
		currentScene = gameScene;
		this.onCreateSceneCallback.onCreateSceneFinished(gameScene);
	}

	public void createEffectTestScene() {
		// TODO Auto-generated method stub
		eScene = new EffectTestScene();
		currentScene = eScene;
		this.onCreateSceneCallback.onCreateSceneFinished(eScene);
		
	}

}
