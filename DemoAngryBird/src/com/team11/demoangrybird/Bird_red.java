package com.team11.demoangrybird;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Bird_red extends Bird
{	
	public Bird_red(float x, float y, ITextureRegion texture,
			VertexBufferObjectManager Ver,Scene mScene) {
		super(x, y, texture, Ver,mScene);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CreateBody(PhysicsWorld physicWorld) 
	{
		// TODO Auto-generated method stub
		super.CreateBody(physicWorld);
		
		body = PhysicsFactory.createCircleBody(physicWorld, mSprite, BodyType.DynamicBody, 
												PhysicsFactory.createFixtureDef(weight,elastic ,friction));
		body.setActive(false);
		physicconnect = new PhysicsConnector(mSprite, body);
		physicWorld.registerPhysicsConnector(physicconnect);
	}
	
	@Override
	public void Shoot(Vector2 SLINGSHOT_CENTER, Vector2 Touch) {
		// TODO Auto-generated method stub
		super.Shoot(SLINGSHOT_CENTER, Touch);
		
		float Vx = (SLINGSHOT_CENTER.x - Touch.x) / 5;
		float Vy = (SLINGSHOT_CENTER.y - Touch.y) / 5;
		body.setLinearVelocity(Vx*2, Vy*2);
		body.setActive(true)
;	}
}
