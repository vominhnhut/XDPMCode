package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager.SceneType;

public class WorldScene extends BaseScene{

	SpriteMenuItem btn;
	Text text;
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		btn = new SpriteMenuItem(
				0,
				this.resourcesManager.texturepackerhelper.CirBig_ice_TiledTexture,
				this.vbom);
		btn.setPosition(this.camera.getCenterX(),this.camera.getCenterY());
		this.setBackground(new Background(Color.BLUE));
		text=new Text(100, 100, ResourcesManager.getInstance().font, "angry birds", vbom);
		this.attachChild(btn);
		this.attachChild(text);
		
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
