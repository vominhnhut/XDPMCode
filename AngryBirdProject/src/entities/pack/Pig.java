package entities.pack;

import org.andengine.entity.sprite.AnimatedSprite;

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
	
	
}
