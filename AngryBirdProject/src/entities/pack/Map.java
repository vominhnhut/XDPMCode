package entities.pack;

import java.util.ArrayList;
import java.util.List;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.content.Context;
import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Manifold;

import xdpm.nhom11.angrybirdsproject.bird.Bird;
import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;

public class Map implements IOnSceneTouchListener, IUpdateHandler {

	public static PhysicsWorld mPhysicsWorld;

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
	SmoothCamera camera;

	public Map(Context context, VertexBufferObjectManager vbo) {

		Map.mPhysicsWorld = new PhysicsWorld(new Vector2(0, -10), false);
		fx = PhysicsFactory.createFixtureDef(50, 0.2f, 1f);
		Map.mPhysicsWorld.setContactListener(createContactListener());
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

		staticRect = new Rectangle(0f, 0f, 10000f, 1f,
				ResourcesManager.getInstance().vbom);
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

	Scene scene;

	public void Attached(Scene scene) {
		// attach cho chim
		this.scene = scene;
		for (Bird bird : ListBird) {
			bird.Attached(scene);
		}
		for (GameObject bird : ListObject) {
			bird.Attached(scene);
		}
		mSlingshot.Attached(scene);
		scene.attachChild(staticRect);

	}

	public void AddBird(Bird bird) {
		bird.Attached(this.scene);

	}

	boolean activeblock = false;
	int index = 0;

	// camera
	Camera2D camera2D;

	public Camera2D getcamera() {
		return camera2D;

	}

	public void setcamera(SmoothCamera camera) {
		this.camera = camera;
		if (camera != null) {
			camera.setChaseEntity(ListBird.get(0).getSprite());

		}
	}

	public IEntity getEntity() {
		return (IEntity) ListBird.get(4).getBody();
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		// set active vật liệu
		if (activeblock == false) {

			for (GameObject ob : ListObject) {
				ob.mBody.setType(BodyType.DynamicBody);
			}
			activeblock = true;
		}

		mSlingshot.ReadyShoot(ListBird.get(4));
		// gán indexmove con chim đang ở trên ná và đưa camera về lại vị trí ban
		// đầu
		indexmove = index;

		// camera2D.mSmoothCamera.set(0,0,800,480);

		// đảm bảo lúc này con chim ko bay
		// isMove = false;
		//
		// //nếu con chim ko bay cho phép scroll và zoom
		// if(!isMove)
		// {
		// camera2D.mPinchZoomDetector.onSceneTouchEvent(pScene,
		// pSceneTouchEvent);
		// if (camera2D.mPinchZoomDetector.isZooming())
		// {
		// camera2D.mScrollDetector.setEnabled(false);
		// } else
		// {
		// camera2D.mScrollDetector.onSceneTouchEvent(pScene, pSceneTouchEvent);
		// }
		// }
		//
		mSlingshot.UpdateTouch(pSceneTouchEvent, null);

		return false;
	}

	boolean isMove = false; // cho biết chim đang di chuyển
	boolean iszoom1 = false;
	int indexmove; // index con chim đang di chuyển
	boolean zoomed = false;

	@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		// if(mSlingshot.isShoot)
		// {
		// //cho biết con chim đã bay
		// isMove = true;
		// mSlingshot.isShoot = false;
		//
		// index++;
		// if(index>=ListBird.size())
		// index=0;
		// }
		if (ListBird.get(0).getSprite().getY() > camera.getBoundsHeight()
				&& zoomed == false) {
			camera.setZoomFactor(0.68f);
			zoomed = true;

		} else if (ListBird.get(0).getSprite().getY() <= camera
				.getBoundsHeight() && zoomed == true) {
			camera.setZoomFactor(1f);
			zoomed = false;
		}
		for (int i = 0; i < ListObject.size(); i++) {
			ListObject.get(i).onUpdate(pSecondsElapsed);

		}
		// if(isMove)
		// {
		// //đặt con chim tiếp theo vào vị trí bắn
		// if( mSlingshot.birdShooted == null &&
		// ListBird.get(indexmove).getSprite().getY() +
		// ListBird.get(indexmove).getSprite().getHeight()*2 >
		// mSlingshot.mPosition.y)
		// {
		// mSlingshot.ReadyShoot(ListBird.get(index));
		// }
		//
		// //di chuyển camera theo con chim
		// camera2D.FollowBird(isMove, iszoom1,
		// ListBird.get(indexmove).getBody().getLinearVelocity());
		// }
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	float maxImpulse;

	private ContactListener createContactListener() {

		ContactListener contactListener = new ContactListener() {

			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub

			}

			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub

				// for (int j = 0; j < ListBird.size(); j++) {

				maxImpulse = impulse.getNormalImpulses()[0];
				// for (int i = 1; i < impulse.getNormalImpulses().length; i++)
				// maxImpulse = Math.max(impulse.getNormalImpulses()[i],
				// maxImpulse);

				if (maxImpulse > 400f) {

					final Fixture x1 = contact.getFixtureA();
					final Fixture x2 = contact.getFixtureB();

					if (x1.getBody().getUserData() != null
							&& x2.getBody().getUserData() != null) {
						// if (x2.getBody().getUserData().getClass() ==
						// GameObject.class &&
						// x1.getBody().getUserData().getClass()
						// == GameObject.class) {
						//
						// ((AnimatedSprite) ((GameObject) x1.getBody()
						// .getUserData()).getSprite())
						// .setCurrentTileIndex(3);
						// }
						//Log.e("aaaa", x1.getBody().getUserData().getClass().get+"");
						if (x2.getBody().getUserData().getClass()==YellowBird.class) {

							// ((AnimatedSprite) ((GameObject) x1.getBody()
							// .getUserData()).getSprite())
							// .setCurrentTileIndex(3);
							Log.e("aaaa", "x1.getBody().getUserData().getClass()");

						}
					}
				}

				// }

			}

			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub

			}
		};
		return contactListener;
	}

	// xác định 1 body va chạm đầu tiên
	public boolean isBodyContacted(Body pBody, Contact pContact) {
		if (pContact.getFixtureA().getBody().equals(pBody)
				|| pContact.getFixtureB().getBody().equals(pBody))
			return true;

		return false;
	}

	// xác định 2 body nào va chạm
	public int areBodiesContacted(Body pBody1, Contact pContact) {
		for (int i = 0; i < ListObject.size(); i++)
			if (pContact.getFixtureA().getBody().equals(pBody1)
					|| pContact.getFixtureB().getBody().equals(pBody1)) {
				if (pContact.getFixtureA().getBody()
						.equals(ListObject.get(i).getBody())
						|| pContact.getFixtureB().getBody()
								.equals(ListObject.get(i).getBody()))
					return i;
			}

		return -1;
	}

}
