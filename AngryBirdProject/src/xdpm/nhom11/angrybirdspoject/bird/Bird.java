package xdpm.nhom11.angrybirdspoject.bird;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import entities.pack.GameEntity;

public abstract class Bird extends GameEntity {

	public Bird(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixtureDef) {
		super(physicseditor, physicsworld, fixtureDef);
		

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

}
