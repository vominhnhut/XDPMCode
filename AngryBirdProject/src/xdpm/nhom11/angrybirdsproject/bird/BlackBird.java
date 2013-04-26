package xdpm.nhom11.angrybirdsproject.bird;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import entities.pack.Map;

public class BlackBird extends Bird {

	public BlackBird(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixtureDef) {
		super(physicseditor, physicsworld, fixtureDef);
		// TODO Auto-generated constructor stub
	}

	public BlackBird(FixtureDef fixturedef) {
		super(fixturedef);
	}

	public BlackBird(float pX, float pY, FixtureDef fixturedef) {
		super(pX, pY, fixturedef);
	}

	@Override
	public void LoadResource() {
		// TODO Auto-generated method stub
		super.LoadResource();
		mPosition = new Vector2(200, 200);
		mSprite = new AnimatedSprite(mPosition.x, mPosition.y,
				TexturePackerHelper.BLACK_BIRD_TILEDTEXTURE, Map.VBO);
	}

	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		super.LoadBody(physicseditor, physicsworld);
		this.mBody = physicseditor.createBody("BLACK BIRD", this.mSprite,
				physicsworld, this.mFixture);
	}
}