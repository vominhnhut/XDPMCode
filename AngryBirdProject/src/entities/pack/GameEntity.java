package entities.pack;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.util.Vector2Pool;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.texturepackersupport.TexturePackerHelper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public abstract class GameEntity {

	// sprite của đối tượng.
	protected AnimatedSprite mSprite;

	// thông số vật lý
	protected FixtureDef mFixture;

	// body của vật thể
	protected Body mBody;

	// kết nối vật lý
	protected PhysicsConnector mPhysicsConnector;

	// vị trí
	protected Vector2 mPosition;

	// góc xoay
	protected float mRotation;

	public GameEntity(AnimatedSprite spr, Body bd, FixtureDef fx, Vector2 ps,
			float rt) {

		this.mSprite = spr;
		this.mBody = bd;
		this.mFixture = fx;
		this.mPosition = ps;
		this.mRotation = rt;
	}

	public GameEntity() {

	}
	public GameEntity(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixturedef)
	{
		this.mFixture=fixturedef;
		this.LoadResource();
		this.LoadBody(physicseditor, physicsworld);
		this.mPhysicsConnector=new PhysicsConnector(mSprite, mBody);
	}

	public void LoadResource() {

	}
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor, PhysicsWorld physicsworld)
	{
		
	}

	// va chạm
	public void Collide(float force) {

	}

	// hàm set
	public void setSprite(AnimatedSprite sp) {
		this.mSprite = sp;
	}

	public void setFixtureDef(FixtureDef fx) {
		this.mFixture = fx;
	}

	public void setBody(Body bd) {
		this.mBody = bd;
	}

	public void setTransform(Vector2 position, float angle) {
		
		this.mPosition = position;
		final Vector2 v2 = Vector2Pool.obtain((position.x)
				/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT, (position.y)
				/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
		this.mBody.setTransform(v2, angle);
		Vector2Pool.recycle(v2);
	}

	public void setPosition(Vector2 ps) {
		this.mPosition = ps;
	}

	public void setRotation(float rt) {
		this.mRotation = rt;
	}

	public void setPhysicsConnector(PhysicsConnector pc) {
		this.mPhysicsConnector = pc;
	}

	// hàm get
	public Sprite getSprite() {
		return this.mSprite;
	}

	public FixtureDef getFixtureDef() {
		return this.mFixture;
	}

	public Body getBody() {
		return this.mBody;
	}

	public Vector2 getPosition() {
		return this.mPosition;
	}

	public float getRotation() {
		return this.mRotation;
	}

	public PhysicsConnector getPhysicsConnector() {
		return this.mPhysicsConnector;
	}

	public void AttachChild(Scene scn) {

		scn.attachChild(mSprite);
	}

}
