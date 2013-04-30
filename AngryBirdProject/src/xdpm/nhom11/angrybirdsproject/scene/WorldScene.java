package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.menu.item.SpriteMenuItem;

import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class WorldScene extends BaseScene{

	SpriteMenuItem btn;
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		btn = new SpriteMenuItem(
				0,
				this.resourcesManager.texturepackerhelper.CirBig_ice_TiledTexture,
				this.vbom);
		btn.setPosition(this.camera.getCenterX(),this.camera.getCenterY());
		
		this.attachChild(btn);
		
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
	

}
