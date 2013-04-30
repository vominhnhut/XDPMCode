package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.animator.SlideMenuSceneAnimator;
import org.andengine.entity.scene.menu.item.AnimatedSpriteMenuItem;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.adt.align.VerticalAlign;
import org.andengine.util.adt.spatial.Direction;
import org.andengine.util.modifier.ease.EaseBounceOut;

import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class MenuScene extends BaseScene implements IOnMenuItemClickListener {

	SpriteMenuItem play;
	private org.andengine.entity.scene.menu.MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;
	

	private void createMenuChildScene() {
		menuChildScene = new org.andengine.entity.scene.menu.MenuScene(camera);
	
		play = new SpriteMenuItem(
				0,
				this.resourcesManager.texturepackerhelper.play_btn_TiledTexture,
				this.vbom);
		play.setPosition(this.camera.getCenterX(), this.camera.getCenterY());

		menuChildScene.addMenuItem(play);
		final SlideMenuSceneAnimator menuSceneAnimator = new SlideMenuSceneAnimator(HorizontalAlign.CENTER, VerticalAlign.CENTER, Direction.UP_LEFT, EaseBounceOut.getInstance());
		menuSceneAnimator.setMenuItemSpacing(10);
		
		menuChildScene.setMenuSceneAnimator(menuSceneAnimator);
		menuChildScene.buildAnimations();
		menuChildScene.setBackgroundEnabled(true);
		menuChildScene.setOnMenuItemClickListener(this);

		setChildScene(menuChildScene);
	}

	@Override
	public void createScene() {
		// TODO Auto-generated method stub

		createMenuChildScene();

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

		this.dispose();
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MENU;
	}

	@Override
	public boolean onMenuItemClicked(
			org.andengine.entity.scene.menu.MenuScene pMenuScene,
			IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch (pMenuItem.getID()) {
		case 0:
			SceneManager.getInstance().CreateWorldScene();

			return true;
		case 1:
			// action
			return true;
		default:
			return false;
		}
	}

}
