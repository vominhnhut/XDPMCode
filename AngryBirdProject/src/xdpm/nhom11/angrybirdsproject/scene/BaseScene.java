package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.Scene;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;

public abstract class BaseScene extends Scene {
	// ---------------------------------------------
	// VARIABLES
	// ---------------------------------------------

	public int iBack = 1;
	public String name;

	// ---------------------------------------------
	// CONSTRUCTOR
	// ---------------------------------------------

	public BaseScene() {

	}

	// ---------------------------------------------
	// ABSTRACTION
	// ---------------------------------------------

	public abstract void createScene();

	public abstract void onBackKeyPressed();

	public abstract SceneType getSceneType();

	public void disposeScene() {
		this.clearEntityModifiers();
		this.clearTouchAreas();
		this.clearUpdateHandlers();
		this.clearChildScene();

		Game.getInstance().camera.setChaseEntity(null);
		Game.getInstance().camera.reset();
		Game.getInstance().camera.setBounds(0, 0,
				Game.getInstance().camera.getWidth(),
				Game.getInstance().camera.getHeight());
		Game.getInstance().camera.setCenterDirect(
				Game.getInstance().camera.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2);

	}

	public abstract void CreateBackground();

}
