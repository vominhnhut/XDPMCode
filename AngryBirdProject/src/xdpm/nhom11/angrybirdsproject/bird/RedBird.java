package xdpm.nhom11.angrybirdsproject.bird;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

public class RedBird extends Bird{

	
	
	public RedBird(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixtureDef) {
		super(physicseditor, physicsworld,fixtureDef);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void LoadResource() {
		// TODO Auto-generated method stub
		super.LoadResource();
		mPosition = new Vector2(200, 200);
		mSprite = new AnimatedSprite(mPosition.x, mPosition.y,
				TexturePackerHelper.red_Bird_TiledTexture,
				new VertexBufferObjectManager());
	}
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		super.LoadBody(physicseditor, physicsworld);
		this.mBody=physicseditor.createBody("RED BIRD",this.mSprite, physicsworld, this.mFixture);
	}
	
}
