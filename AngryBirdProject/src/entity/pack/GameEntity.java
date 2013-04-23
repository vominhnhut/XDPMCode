package entity.pack;

import java.util.List;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * @author VMNhut
 *
 */
public abstract class GameEntity {
	
	/**
	 * Vị trí của vật thể
	 */
	private Vector2 position;
	
	
	/**
	 * Khối lượng vật thể 
	 */
	private float density;
	
	/**
	 * Độ ma sát
	 */
	private float friction;
	
	/**
	 * Đàn hồi
	 */
	private float elastic;
	
	/**
	 * Body 
	 */
	private Body body;
	
	/**
	 * Danh sách các sprite của vật thể
	 */
	private AnimatedSprite sprite_list;
	
	/**
	 * 
	 */
	private PhysicsConnector physic_connector;
	
	/**
	 * Độ bền của vật liệu
	 */
	private float durability;
	
	/**
	 * Điểm cộng
	 */
	private float point;
	
	public GameEntity(Vector2 position, float density, float friction,
			float elastic, AnimatedSprite sprite_list, PhysicsWorld physics_world) {
		super();
		this.position = position;
		this.density = density;
		this.friction = friction;
		this.elastic = elastic;
		this.body = body;
		this.sprite_list = sprite_list;
		CreateBody(physics_world);
	}
	
	public void CreateBody(PhysicsWorld physics_world)
	{

	}
	
	public void PostSolve(Body body ,Contact contact, ContactImpulse impulse)
	{
		
	}
	
	public void preSolve(Body body ,Contact contact, Manifold oldManifold)
	{
		
	}

}
