package xdpm.nhom11.angrybirdsproject.test;

import org.andengine.extension.physics.box2d.PhysicsFactory;

import com.badlogic.gdx.physics.box2d.FixtureDef;

import android.widget.ListView.FixedViewInfo;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import junit.framework.TestCase;

public class BlackBird_test extends TestCase {

	public BlackBird_test(String name) {
		super(name);
	}
	
	BlackBird blackBird;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLoadResource() {
		fail("Not yet implemented");
	}

	public void testLoadBody() {
		fail("Not yet implemented");
	}

	public void testCollide() {
		fail("Not yet implemented");
	}

	public void testCheckState() {
		fail("Not yet implemented");
	}

	public void testDestroy() {
		fail("Not yet implemented");
	}

	public void testShoot() {
		fail("Not yet implemented");
	}

	public void testUseSkill() {
		fail("Not yet implemented");
	}

	public void testBlackBird() {
		
		FixtureDef fd = new PhysicsFactory().createFixtureDef((float)0.1, (float)0.2, (float)0.3);
		BlackBird blackBird = new BlackBird((float)0.4, (float)0.7,fd);
		assertEquals((float) 0.4, blackBird.getPosition().x);
		assertEquals((float) 0.7, blackBird.getPosition().y);
		//assertEquals((float) 0.1, blackBird.getFixtureDef().density);
		//assertEquals((float) 0.2, blackBird.getFixtureDef().restitution);
		//assertEquals((float) 0.3, blackBird.getFixtureDef().friction);
		fail("Not yet implemented");
	}

}
