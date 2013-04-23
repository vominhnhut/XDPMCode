package entity.pack;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.math.Vector2;

public class GameObject extends GameEntity {

	/**
	 * Góc xoay
	 */
	private float rotation;
	
	/**
	 * Độ bền của vật liệu
	 */
	private float durability;
	
	/**
	 * Điểm cộng
	 */
	private float point;
	
	public GameObject(Vector2 position, float density, float friction,
			float elastic, AnimatedSprite sprite_list,
			PhysicsConnector physic_connector, PhysicsWorld physics_world) {
		super(position, density, friction, elastic, sprite_list, physic_connector,
				physics_world);
		// TODO Auto-generated constructor stub
	}

}
