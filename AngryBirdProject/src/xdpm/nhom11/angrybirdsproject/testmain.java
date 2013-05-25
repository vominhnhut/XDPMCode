package xdpm.nhom11.angrybirdsproject;

import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

import xdpm.nhom11.angrybirdsproject.manager.DataManager;

public class testmain extends SimpleBaseGameActivity {

    private Scene mMainScene;

    public Rectangle staticRect;

    SmoothCamera camera;

    @Override
    public EngineOptions onCreateEngineOptions() {
        // TODO Auto-generated method stub

        camera = new SmoothCamera(0, 0, 720, 480, 800, 400, 0.3f);

        EngineOptions engine = new EngineOptions(true,
                ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
                camera);
        return engine;
    }

    @Override
    protected void onCreateResources() {
        // TODO Auto-generated method stub

        DataManager.getInstance().load(this);
    }

    int indexmove = 0;

    @Override
    protected Scene onCreateScene() {
        // TODO Auto-generated method stub

        mMainScene = new Scene();
        mMainScene.setBackground(new Background(Color.BLACK));

        return mMainScene;
    }

    boolean activeblock = false;
    boolean isMove = false;
}
