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

	protected void setUp() throws Exception {
		super.setUp();
		FixtureDef fd = new PhysicsFactory().createFixtureDef((float)3.1, (float)3.2, (float)3.3);
		BlackBird blackBird = new BlackBird((float)3.4, (float)4.1,fd);
		
		//assertEquals(expected, )
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
		fail("Not yet implemented");
	}

}
