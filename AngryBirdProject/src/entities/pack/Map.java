package entities.pack;

import java.util.ArrayList;
import java.util.List;

import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import xdpm.nhom11.angrybirdspoject.bird.Bird;
import xdpm.nhom11.angrybirdspoject.bird.BlackBird;
import xdpm.nhom11.angrybirdspoject.bird.BlueBird;
import xdpm.nhom11.angrybirdspoject.bird.RedBird;
import xdpm.nhom11.angrybirdspoject.bird.WhiteBird;
import xdpm.nhom11.angrybirdspoject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;

public class Map {

	PhysicsWorld mPhysicsWorld;

	FixtureDef fx;

	// danh sách chim
	ArrayList<Bird> ListBird = new ArrayList<Bird>();
	ArrayList<GameObject> ListObject = new ArrayList<GameObject>();

	// cây ná
	Slingshot mSlingshot;

	public Map() {
		this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, -10), false);
	}

	public void CreateBird() {
		Bird redBird = new RedBird(
				PhysicsEditorContent.physicseditorbirdandpig, mPhysicsWorld, fx);
		Bird blackBird = new BlackBird(
				PhysicsEditorContent.physicseditorbirdandpig, mPhysicsWorld, fx);
		Bird whiteBird = new WhiteBird(
				PhysicsEditorContent.physicseditorbirdandpig, mPhysicsWorld, fx);
		Bird blueBird = new BlueBird(
				PhysicsEditorContent.physicseditorbirdandpig, mPhysicsWorld, fx);
		Bird yellowBird = new YellowBird(
				PhysicsEditorContent.physicseditorbirdandpig, mPhysicsWorld, fx);
		ListBird.add(redBird);
		ListBird.add(blackBird);
		ListBird.add(whiteBird);
		ListBird.add(blueBird);
		ListBird.add(yellowBird);

		// Set vi tri chim

		//
	}

	public void LoadResource() {
		// mSlingshot=new Slingshot()
	}

}
