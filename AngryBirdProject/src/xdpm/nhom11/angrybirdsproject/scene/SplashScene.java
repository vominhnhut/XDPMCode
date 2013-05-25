package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.adt.color.Color;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class SplashScene extends BaseScene implements IOnMenuItemClickListener {

	private Sprite splash1;
	private Sprite splash2;

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xdpm.nhom11.angrybirdsproject.scene.BaseScene#createScene()
	 */
	@Override
	public void createScene() {
		// TODO Auto-generated method stub

		CreateBackground();

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_SPLASH;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		super.disposeScene();
		splash1.detachSelf();
		splash1.dispose();
		splash2.detachSelf();
		splash2.dispose();
		this.detachSelf();
		this.dispose();
	}

	@Override
	public void CreateBackground() {
		ResourcesManager.getInstance().texturepackerhelper
				.loadTiledTextureBackGround2s(
						Game.getInstance().activity.getTextureManager(),
						Game.getInstance().activity);

		splash1 = new Sprite(Game.getInstance().camera.getCenterX(),
				Game.getInstance().camera.getCenterY(),
				TexturePackerHelper.SPLASHES_SHEET_2_ID,
				Game.getInstance().vbom);
		splash1.setScale(Game.getInstance().camera.getHeight()
				/ splash1.getHeight());
		this.setBackground(new Background(Color.RED));
		this.setBackground(new SpriteBackground(splash1));

		this.attachChild(splash1);
	}

	int count = 0;

	@Override
	protected void onManagedUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		super.onManagedUpdate(pSecondsElapsed);

		if (count <= 500) {
			count++;
		}
		if (count > 500) {
			SceneManager.getInstance().setScene(SceneType.SCENE_MENU);
			unregisterUpdateHandler(this);
		}
		if (count > 200 && count <= 201) {
			splash2 = new Sprite(Game.getInstance().camera.getCenterX(),
					Game.getInstance().camera.getCenterY(),
					TexturePackerHelper.SPLASHES_SHEET_1_ID,
					Game.getInstance().vbom);
			splash2.setScale(Game.getInstance().camera.getHeight()
					/ splash2.getHeight());

			this.setBackground(new SpriteBackground(splash2));

			this.attachChild(splash2);
		}

	}

}
