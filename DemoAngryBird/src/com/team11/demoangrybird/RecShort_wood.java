package com.team11.demoangrybird;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class RecShort_wood extends Vatlieu 
{	
	public RecShort_wood(float x, float y, ITextureRegion texture,
			VertexBufferObjectManager Ver, Scene mScene) {
		super(x, y, texture, Ver, mScene);
		// TODO Auto-generated constructor stub
	}

	public void CreateBody_bird(PhysicsWorld physicWorld)
	{
		body = PhysicsFactory.createBoxBody(physicWorld, mSprite, BodyType.DynamicBody, 
											PhysicsFactory.createFixtureDef(weight,elastic ,friction));
		physicWorld.registerPhysicsConnector(new PhysicsConnector(mSprite, body));
	}
}
