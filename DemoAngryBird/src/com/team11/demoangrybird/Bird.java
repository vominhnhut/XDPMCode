package com.team11.demoangrybird;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Bird extends Vat_the
{	
	public Bird(float x, float y, ITextureRegion texture,
			VertexBufferObjectManager Ver, Scene mScene) {
		super(x, y, texture, Ver, mScene);
		// TODO Auto-generated constructor stub
		
		mSprite = new Sprite(x,y, texture, Ver);
		position = new Vector2(x,y);
		mSprite.setZIndex(2);
		mScene.attachChild(mSprite);
		mScene.sortChildren();
	}

	float timeLife = 500;		//thời gian sống
	int status = 1;			//trạng thái
		
	public void Shoot(Vector2 SLINGSHOT_CENTER, Vector2 Touch) 
	{		
	}
	
	public void Collision(float force)
	{
	}
	
	public boolean UseSkill()
	{
		return false;
	}
}