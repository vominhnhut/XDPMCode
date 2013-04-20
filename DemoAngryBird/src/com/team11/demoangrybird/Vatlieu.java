package com.team11.demoangrybird;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Vatlieu extends Vat_the {
	
	public Vatlieu(float x, float y, ITextureRegion texture,
			VertexBufferObjectManager Ver, Scene mScene) {
		super(x, y, texture, Ver, mScene);
		// TODO Auto-generated constructor stub

		position = new Vector2(x,y);
		mSprite = new Sprite(x,y, texture, Ver);
		mScene.attachChild(mSprite);
	}
	
	float rotation;				//góc quay
	float status;				//trạng thái	
	float point;				//điểm cộng
	
	public void destroyBody(Scene mScene, PhysicsWorld physicworld)
	{		
	}
}
