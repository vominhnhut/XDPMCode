package xdpm.nhom11.angrybirdsproject.manager;

import org.andengine.ui.IGameInterface.OnCreateSceneCallback;
import xdpm.nhom11.angrybirdsproject.scene.BaseScene;
import xdpm.nhom11.angrybirdsproject.scene.GameScene;
import xdpm.nhom11.angrybirdsproject.scene.LevelScene;
import xdpm.nhom11.angrybirdsproject.scene.MenuScene;
import xdpm.nhom11.angrybirdsproject.scene.SplashScene;
import xdpm.nhom11.angrybirdsproject.scene.WorldScene;

/**
 * Lớp quản lý màn hình
 * 
 * @author Hoa Phat
 * 
 */
public class SceneManager {
    public enum SceneType {
        SCENE_SPLASH, SCENE_MENU, SCENE_GAME, SCENE_LOADING, SCENE_WORLD, SCENE_LEVEL
    }

    private static final SceneManager INSTANCE = new SceneManager();

    OnCreateSceneCallback onCreateSceneCallback;

    /**
     * Loại scene hiện tại
     */
    private SceneType currentSceneType = SceneType.SCENE_SPLASH;

    /**
     * Scene hiện tại
     */
    private BaseScene currentScene = null;

    /**
     * Cài đặt scene
     * 
     * @param scene
     */
    private void setScene(BaseScene scene) {

        Game.getInstance().engine.setScene(scene);
        if (currentScene != null) // hủy scene
            currentScene.disposeScene();
        currentScene = scene;
        currentScene.createScene(); // tạo màn hình
        currentSceneType = scene.getSceneType();
        this.onCreateSceneCallback.onCreateSceneFinished(currentScene);
    }

    /**
     * chuyển scene theo loại
     * 
     * @param sceneType
     *            loại scene
     */
    public void setScene(SceneType sceneType) {
        switch (sceneType) {

        case SCENE_MENU:

            setScene(new MenuScene());

            break;
        case SCENE_WORLD:

            setScene(new WorldScene());

            break;
        case SCENE_SPLASH:
            setScene(new SplashScene());
            break;

        case SCENE_LEVEL:

            setScene(new LevelScene());

            break;
        case SCENE_GAME:

            setScene(new GameScene());

            break;
        default:
            break;
        }
    }

    /**
     * Lấy loại Scene hiện tại
     * 
     * @return loại scene hiện tại
     */
    public SceneType getCurrentSceneType() {
        return currentSceneType;
    }

    /**
     * Lấy Scene hiện tại
     * 
     * @return Scene hiện tại
     */
    public BaseScene getCurrentScene() {
        return currentScene;
    }

    /**
     * @param onCallback
     */
    public void setCallback(OnCreateSceneCallback onCallback) {
        this.onCreateSceneCallback = onCallback;

    }

    /**
     * @return
     */
    public static SceneManager getInstance() {
        return INSTANCE;
    }
}
