package entities.pack;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

import com.badlogic.gdx.physics.box2d.FixtureDef;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

public class GameObject extends GameEntity {

	String ID;
	TiledTextureRegion temp;
	public GameObject(String ID, PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixturedef) {
		
		this.ID=ID;
		//super(physicseditor, physicsworld, fixturedef);
		Log.e("aassd", "contructor");
		this.mFixture=fixturedef;
		this.LoadResource();
		this.LoadBody(physicseditor, physicsworld);
		this.mPhysicsConnector=new PhysicsConnector(mSprite, mBody);

		
	}

	@Override
	public void AttachChild(Scene scn) {
		// TODO Auto-generated method stub
		super.AttachChild(scn);
	}

	@Override
	public void LoadResource() {
		// TODO Auto-generated method stub
		super.LoadResource();
		CheckID();
		
		this.mSprite=new AnimatedSprite(0, 0,temp, new VertexBufferObjectManager());
	}

	@Override
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		super.LoadBody(physicseditor, physicsworld);
		this.mBody=physicseditor.createBody(ID, mSprite, physicsworld, mFixture);
	}
	public void CheckID()
	{
		
	 if(ID.equalsIgnoreCase("RECFULL_ROCK"))
	 {
		 temp=TexturePackerHelper.RecFull_roc_TiledTexture;
		
	 }
	 else if( ID.equalsIgnoreCase("OTHER_3"))
	 {
		 temp=TexturePackerHelper.other_3_TiledTexture;
	 }
	 
	}
}
