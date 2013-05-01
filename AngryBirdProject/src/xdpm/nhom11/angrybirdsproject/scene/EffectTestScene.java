package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.input.touch.TouchEvent;

import xdpm.nhom11.angrybirdsproject.effectmanager.EffectManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class EffectTestScene extends BaseScene {

	@Override
	public void createScene() {
		// TODO Auto-generated method stub

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
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub

		EffectManager.PigDead(pSceneTouchEvent.getX(),pSceneTouchEvent.getY(), this);
		return true;
	}

}
