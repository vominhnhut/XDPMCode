package entities.pack;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.content.Context;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import xdpm.nhom11.angrybirdsproject.bird.Bird;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;

public class Map implements IOnSceneTouchListener {

	public static PhysicsWorld mPhysicsWorld;
	public static VertexBufferObjectManager VBO;
	// biến tạm tạo fixturedef cho toàn bộ object;
	FixtureDef fx;

	// danh sách chim
	ArrayList<Bird> ListBird = new ArrayList<Bird>();
	// danh sách vật cản
	ArrayList<GameObject> ListObject = new ArrayList<GameObject>();
	// cây ná
	Slingshot mSlingshot;

	// mặt đất tạm
	Rectangle staticRect;

	public Map(Context context, VertexBufferObjectManager vbo) {
		this.VBO = vbo;

		Map.mPhysicsWorld = new PhysicsWorld(new Vector2(0, -10), false);
		fx=PhysicsFactory.createFixtureDef(50, 0.2f, 1f);

	}

	public void Load() {
		CreateBird();
		CreateBlock();
		CreateSlingshot();
		CreateEarthSurface();
	}

	public void CreateSlingshot() {
		this.mSlingshot = new Slingshot(100, 170);
	}

	public void CreateBird() {
		Bird redBird = new RedBird(20, 10, fx);
		Bird blackBird = new BlackBird(60, 10, fx);
		Bird whiteBird = new WhiteBird(120, 10, fx);
		Bird blueBird = new BlueBird(160, 10, fx);
		Bird yellowBird = new YellowBird(19020, 10, fx);
		ListBird.add(redBird);
		ListBird.add(blackBird);
		ListBird.add(whiteBird);
		ListBird.add(blueBird);
		ListBird.add(yellowBird);

		// Set vi tri chim

		//
	}

	public void CreateEarthSurface() {

		staticRect = new Rectangle(0f, 0f, 10000f, 1f, this.VBO);
		staticRect.setColor(0f, 0f, 0f);
		staticRect.setAlpha(1);

		Body staticBody;
		staticBody = PhysicsFactory.createBoxBody(Map.mPhysicsWorld,
				staticRect, BodyType.StaticBody,
				PhysicsFactory.createFixtureDef(0.2f, 0.2f, 1f));

		Map.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(
				staticRect, staticBody));
	}

	public void CreateBlock() {

		GameObject ob1 = new GameObject("WHEEL", 664, 42, 0, fx);
		GameObject ob2 = new GameObject("WHEEL", 582, 42, 0, fx);
		GameObject ob3 = new GameObject("WHEEL", 498, 42, 0, fx);
		GameObject ob4 = new GameObject("WHEEL", 414, 42, 0, fx);
		GameObject ob5 = new GameObject("RECLONG_WOOD", 642, 94, 0, fx);
		GameObject ob6 = new GameObject("RECFULL_WOOD", 430, 146, -90, fx);
		GameObject ob7 = new GameObject("RECFULL_WOOD", 472, 146, -90, fx);
		GameObject ob8 = new GameObject("RECFULL_WOOD", 602, 146, 90, fx);
		GameObject ob9 = new GameObject("RECFULL_WOOD", 644, 146, 90, fx);
		GameObject ob10 = new GameObject("RECFULL_WOOD", 536, 146, 90, fx);

		GameObject ob11 = new GameObject("TRIAFULL_WOOD", 368, 146, -272, fx);

		GameObject ob12 = new GameObject("TRIAFULL_WOOD", 706, 146, 0, fx);
		GameObject ob13 = new GameObject("RECLONG_WOOD", 536, 200, 0, fx);
		GameObject ob14 = new GameObject("RECFULL_ROCK", 610, 252, 90, fx);
		GameObject ob15 = new GameObject("SQUAREMEDIUM_ROCK", 456, 232, 0, fx);
		GameObject ob16 = new GameObject("RECLONG_ROCK", 430, 262, 0, fx);

		GameObject ob17 = new GameObject("RECSHORTEST_ROCK", 502, 284, 0, fx);
		GameObject ob18 = new GameObject("RECLONG_WOOD", 436, 94, 0, fx);
		GameObject ob19 = new GameObject("RECSHORTEST_ROCK", 470, 294, 90, fx);
		GameObject ob20 = new GameObject("RECMEDIUM_ROCK", 566, 304, 0, fx);
		GameObject ob21 = new GameObject("FLAG_VN", 556, 380, 0, fx);
		GameObject ob22 = new GameObject("OTHER_3", 764, 104, 0,
				PhysicsFactory.createFixtureDef(500, 0.1F, 0.9F));
		ListObject.add(ob1);
		ListObject.add(ob2);
		ListObject.add(ob3);
		ListObject.add(ob4);
		ListObject.add(ob5);
		ListObject.add(ob6);
		ListObject.add(ob7);
		ListObject.add(ob8);
		ListObject.add(ob9);
		ListObject.add(ob10);
		ListObject.add(ob11);
		ListObject.add(ob12);
		ListObject.add(ob13);
		ListObject.add(ob14);
		ListObject.add(ob15);
		ListObject.add(ob16);
		ListObject.add(ob17);
		ListObject.add(ob18);
		ListObject.add(ob19);
		ListObject.add(ob20);
		ListObject.add(ob21);
		ListObject.add(ob22);
	}

	public void Attached(Scene scene) {
		// attach cho chim
		for (Bird bird : ListBird) {
			bird.Attached(scene);
		}
		for (GameObject bird : ListObject) {
			bird.Attached(scene);
		}
		mSlingshot.Attached(scene);
		scene.attachChild(staticRect);
	}

	boolean activeblock=false;
	int index=0;
	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		mSlingshot.ReadyShoot(ListBird.get(index));
		mSlingshot.UpdateTouch(pSceneTouchEvent, false);

		if (activeblock == false) {

			for(GameObject ob: ListObject)
			{
			ob.mBody.setType(BodyType.DynamicBody);
			}
			activeblock=true;
		}
		index++;
		if(index>=ListBird.size())
			index=0;
		return false;
	
	}

}
