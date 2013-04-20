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
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Vat_the {
	Vector2 position;			//vị trí
	float weight = 30f;			//cân nặng	
	float elastic =  0.3f;		//đàn hồi
	float friction = 1f;		//ma sát

	Body body = null;			//body chim
	Sprite mSprite;
	PhysicsConnector physicconnect=null;
	
	public Vat_the(float x, float y, ITextureRegion texture, VertexBufferObjectManager Ver, Scene mScene)
	{		
	}
	
	public void CreateBody(PhysicsWorld physicWorld)
	{
	}	
}
