package xdpm.nhom11.angrybirdsproject;

import java.io.IOException;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.AnimatedSpriteMenuItem;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.color.Color;

import android.view.MenuItem;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager;
import entities.pack.Camera2D;
import entities.pack.Map;

public class testMenu extends SimpleBaseGameActivity implements
		IOnMenuItemClickListener {

	ResourcesManager resourcemanager;
	SceneManager scenemanager;
	private Camera camera;

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub

		camera = new SmoothCamera(0, 0, 720, 480, 800, 400, 0.3f);

		EngineOptions engine = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				camera);
		return engine;
	}
Sprite temp;
	@Override
	protected void onCreateResources() {
//		ResourcesManager.prepareManager(getEngine(), this, camera,
//				getVertexBufferObjectManager());
		ResourcesManager.getInstance().loadResource();
		temp=new Sprite(200, 200, ResourcesManager.getInstance().texturepackerhelper.play_btn_TiledTexture,getVertexBufferObjectManager() );
	

		// TODO Auto-generated method stub

	}

	int indexmove = 0;

	@Override
	protected Scene onCreateScene() {
		// TODO Auto-generated method stub
		Scene a = new Scene();
		a.setBackground(new Background(Color.CYAN));
		a.attachChild(temp);

		return a;
	}

	boolean activeblock = false;
	boolean isMove = false;

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch (pMenuItem.getID()) {
		case 0:
			// action
			// mMainScene.setChildScene(subscene);
			// VolumeOn.setCurrentTileIndex(1);
			// optionsMenuItem = new ScaleMenuItemDecorator(VolumeOff, 1, 1);
			// mMainScene.addMenuItem(optionsMenuItem);

			return true;
		case 1:
			// action
			return true;
		default:
			return false;
		}

	}
}
