package xdpm.nhom11.angrybirdsproject.bird;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import entities.pack.GameEntity;
import entities.pack.Map;

public abstract class Bird extends GameEntity {

	public Bird(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixtureDef) {
		super(physicseditor, physicsworld, fixtureDef);

	}

	public Bird(FixtureDef fixturedef) {
		super(fixturedef);

		this.LoadResource();
		this.LoadBody(ResourcesManager.getInstance().physicseditorbirdandpig,
				Map.mPhysicsWorld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);
		Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

	}

	public Bird(float pX, float pY, FixtureDef fixturedef) {
		super(pX, pY, fixturedef);
		this.LoadResource();
		this.LoadBody(ResourcesManager.getInstance().physicseditorbirdandpig,
				Map.mPhysicsWorld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);
		Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

	}

	// bắn chim

	public void Shoot(Vector2 force) {
		this.mBody.setLinearVelocity(force);
		this.mBody.setActive(true);
	}

	// Sử dụng skill
	public void UseSkill() {

	}

	// va chạm
	@Override
	public void Collide(float force) {
		// TODO Auto-generated method stub
		super.Collide(force);
	}
	@Override
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		this.mBody.setUserData(this);
	
		
	}

}
