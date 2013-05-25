package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;
import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;
import android.util.DisplayMetrics;
import xdpm.nhom11.angrybirdsproject.manager.DataManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;

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
        DisplayMetrics displayMetrics = new DisplayMetrics();

        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float a = displayMetrics.widthPixels;
        float b = displayMetrics.heightPixels;
        float width = 800;
        float height = 800 * (a / b);

        camera = new SmoothCamera(0, 0, width, height, 400, 300, 0.5f);
        EngineOptions engineOptions = new EngineOptions(true,
                ScreenOrientation.LANDSCAPE_FIXED, new RatioResolutionPolicy(
                        width, height), this.camera);
        engineOptions.getAudioOptions().getMusicOptions().setNeedsMusic(true);
        engineOptions.getAudioOptions().setNeedsSound(true);
        engineOptions.getAudioOptions().getSoundOptions()
                .setMaxSimultaneousStreams(5);
        engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
        return engineOptions;
    }

    @Override
    public void onCreateResources(
            OnCreateResourcesCallback pOnCreateResourcesCallback)
            throws IOException {

        Game.getInstance().prepareGame(getEngine(), this, camera,
                getVertexBufferObjectManager());
        ResourcesManager.getInstance().prepareManager();

        pOnCreateResourcesCallback.onCreateResourcesFinished();

    }

    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
            throws IOException {

        SceneManager.getInstance().setCallback(pOnCreateSceneCallback);
        SceneManager.getInstance().setScene(SceneType.SCENE_SPLASH);
        ResourcesManager.getInstance().loadResource();
        DataManager.getInstance().load(this);
    }

    @Override
    public void onPopulateScene(Scene pScene,
            OnPopulateSceneCallback pOnPopulateSceneCallback)
            throws IOException {

        pOnPopulateSceneCallback.onPopulateSceneFinished();

    }

    @Override
    public synchronized void onPauseGame() {
        // TODO Auto-generated method stub
        super.onPauseGame();

    }

}
