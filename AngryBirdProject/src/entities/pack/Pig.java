package entities.pack;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Pig extends GameEntity {

	public Pig()
	{
		super();
	}
	public Pig(AnimatedSprite spr, Body bd, FixtureDef fx, Vector2 ps, float rt)
	{
		super(spr, bd, fx, ps, rt);
	}
	
	@Override
	public void Collide(float force) {
		// TODO Auto-generated method stub
		super.Collide(force);
	}
	@Override
	public void LoadResource() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		
	}
	
	
}
