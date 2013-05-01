package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import entities.pack.Map;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class GameScene extends BaseScene {

	Map mMap;
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		mMap=new Map(activity, vbom);
		createHUD();
		this.setBackground(new Background(Color.CYAN));
		this.registerUpdateHandler(Map.mPhysicsWorld);

		this.mMap.Load();
		this.mMap.Attached(this);
		//this.mMap.setcamera(camera);

		// camera.setChaseEntity(mMap.getEntity());
		//
		this.setOnSceneTouchListener(mMap);
		this.registerUpdateHandler(mMap);
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
	public void createHUD()
	{
		HUD gameHUD=new HUD();
		
		
		camera.setHUD(gameHUD);
		Text score=new Text(100, 100, resourcesManager.font, "ANGRY BIRDS", vbom);
		gameHUD.attachChild(score);
	}

}
