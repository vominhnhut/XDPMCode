package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;

public class LoadingScene extends BaseScene {

	@Override
	public void createScene() {
		this.setBackground(new Background(Color.WHITE));
		attachChild(new Text(400, 240, ResourcesManager.getInstance().font,
				"Loading...", Game.getInstance().vbom));

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CreateBackground() {
		// TODO Auto-generated method stub

	}

}
