package entities.pack;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;
import android.widget.Switch;

import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class GameObject  extends GameEntity {

	String ID;
	TiledTextureRegion temp;

	public GameObject(String ID, PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld, FixtureDef fixturedef) {

		this.ID = ID;
		// super(physicseditor, physicsworld, fixturedef);
		// Log.e("aassd", "contructor");
		this.mFixture = fixturedef;
		this.LoadResource();
		this.LoadBody(physicseditor, physicsworld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);

	}

	public GameObject(String ID, FixtureDef fixturedef) {
		super(fixturedef);
		Log.e("red", "aaaa");

		this.ID = ID;
		this.LoadResource();
		this.LoadBody(PhysicsEditorContent.physicseditorblock,
				Map.mPhysicsWorld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);

	}

	public GameObject(String ID, float pX, float pY, FixtureDef fixturedef) {
		super(pX, pY, fixturedef);
		this.ID = ID;
		this.LoadResource();
		this.LoadBody(PhysicsEditorContent.physicseditorblock,
				Map.mPhysicsWorld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);
		Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

	}

	public GameObject(String ID, float pX, float pY, float rotation,
			FixtureDef fixturedef) {
		super(pX, pY, rotation, fixturedef);
		this.ID = ID;
		this.LoadResource();
		this.LoadBody(PhysicsEditorContent.physicseditorblock,
				Map.mPhysicsWorld);
		this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);
		this.setTransform(mPosition, mRotation);
		Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);
		this.mBody.setType(BodyType.StaticBody);

	}

	@Override
	public void Attached(Scene scn) {
		// TODO Auto-generated method stub
		super.Attached(scn);
	}

	@Override
	public void LoadResource() {
		// TODO Auto-generated method stub
		CheckID();
		this.mSprite = new AnimatedSprite(this.mPosition.x, this.mPosition.y,
				temp,Map.VBO);
	}

	@Override
	public void LoadBody(PhysicsEditorShapeLibrary physicseditor,
			PhysicsWorld physicsworld) {
		// TODO Auto-generated method stub
		this.mBody = physicseditor.createBody(ID, mSprite, physicsworld,
				mFixture);
	}

	public void CheckID() {

		if (ID.equalsIgnoreCase("RECEMPTY_WOOD")) {
			temp = TexturePackerHelper.RecFull_roc_TiledTexture;

		} else if (ID.equalsIgnoreCase("RECEMPTY_ROCK")) {
			temp = TexturePackerHelper.RecEmpty_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECEMPTY_ICE")) {
			temp = TexturePackerHelper.RecEmpty_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAEMPTY_WOOD")) {
			temp = TexturePackerHelper.TriaEmpty_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAEMPTY_ROCK")) {
			temp = TexturePackerHelper.TriaEmpty_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAEMPTY_ICE")) {
			temp = TexturePackerHelper.TriaEmpty_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAFULL_WOOD")) {
			temp = TexturePackerHelper.TriaFull_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAFULL_ROCK")) {
			temp = TexturePackerHelper.TriaFull_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("TRIAFULL_ICE")) {
			temp = TexturePackerHelper.TriaFull_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECFULL_WOOD")) {
			temp = TexturePackerHelper.RecFull_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECFULL_ROCK")) {
			temp = TexturePackerHelper.RecFull_roc_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECFULL_ICE")) {
			temp = TexturePackerHelper.RecFull_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECLONG_WOOD")) {
			temp = TexturePackerHelper.RecLong_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECLONG_ROCK")) {
			temp = TexturePackerHelper.RecLong_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECLONG_ICE")) {
			temp = TexturePackerHelper.RecLong_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECMEDIUM_WOOD")) {
			temp = TexturePackerHelper.RecMedium_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECMEDIUM_ROCK")) {
			temp = TexturePackerHelper.RecMedium_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECMEDIUM_ICE")) {
			temp = TexturePackerHelper.RecMedium_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORT_WOOD")) {
			temp = TexturePackerHelper.RecShort_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORT_ROCK")) {
			temp = TexturePackerHelper.RecShort_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORT_ICE")) {
			temp = TexturePackerHelper.RecShort_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORTEST_WOOD")) {
			temp = TexturePackerHelper.RecShortest_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORTEST_ROCK")) {
			temp = TexturePackerHelper.RecShortest_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("RECSHORTEST_ICE")) {
			temp = TexturePackerHelper.RecShortest_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUAREMEDIUM_WOOD")) {
			temp = TexturePackerHelper.SquareMedium_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUAREMEDIUM_ROCK")) {
			temp = TexturePackerHelper.SquareMedium_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUAREMEDIUM_ICE")) {
			temp = TexturePackerHelper.SquareMedium_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUARESMALL_WOOD")) {
			temp = TexturePackerHelper.SquareSmall_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUARESMALL_ROCK")) {
			temp = TexturePackerHelper.SquareSmall_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("SQUARESMALL_ICE")) {
			temp = TexturePackerHelper.SquareSmall_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRBIG_WOOD")) {
			temp = TexturePackerHelper.CirBig_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRBIG_ROCK")) {
			temp = TexturePackerHelper.CirBig_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRBIG_ICE")) {
			temp = TexturePackerHelper.CirBig_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRMEDIUM_WOOD")) {
			temp = TexturePackerHelper.CirMedium_wood_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRMEDIUM_ROCK")) {
			temp = TexturePackerHelper.CirMedium_rock_TiledTexture;
		} else if (ID.equalsIgnoreCase("CIRMEDIUM_ICE")) {
			temp = TexturePackerHelper.CirMedium_ice_TiledTexture;
		} else if (ID.equalsIgnoreCase("OTHER_1")) {
			temp = TexturePackerHelper.other_1_TiledTexture;
		} else if (ID.equalsIgnoreCase("OTHER_2")) {
			temp = TexturePackerHelper.other_2_TiledTexture;
		} else if (ID.equalsIgnoreCase("OTHER_3")) {
			temp = TexturePackerHelper.other_3_TiledTexture;
		} else if (ID.equalsIgnoreCase("TNT")) {
			temp = TexturePackerHelper.TNT_TiledTexture;
		} else if (ID.equalsIgnoreCase("WHEEL")) {
			temp = TexturePackerHelper.Wheel_TiledTexture;
		} else if (ID.equalsIgnoreCase("WATERMELON")) {
			temp = TexturePackerHelper.Watermelon_TiledTexture;
		} else if (ID.equalsIgnoreCase("LEMON")) {
			temp = TexturePackerHelper.Lemon_TiledTexture;
		} else if (ID.equalsIgnoreCase("FLAG")) {
			temp = TexturePackerHelper.Flag_TiledTexture;
		} else if (ID.equalsIgnoreCase("FLAG_VN")) {
			temp = TexturePackerHelper.Flag_VN_TiledTexture;
		} else if (ID.equalsIgnoreCase("DIAMOND")) {
			temp = TexturePackerHelper.Diamond_TiledTexture;
		} else if (ID.equalsIgnoreCase("WHEELSMALL")) {
			temp = TexturePackerHelper.Wheelsmall_TiledTexture;
		} else if (ID.equalsIgnoreCase("WHEELMEDIUM")) {
			temp = TexturePackerHelper.Wheelmedium_TiledTexture;
		} else if (ID.equalsIgnoreCase("BERRY")) {
			temp = TexturePackerHelper.Berry_TiledTexture;
		} else if (ID.equalsIgnoreCase("EGG")) {
			temp = TexturePackerHelper.Egg_TiledTexture;
		} else if (ID.equalsIgnoreCase("BALLRED")) {
			temp = TexturePackerHelper.Ballred_TiledTexture;
		} else if (ID.equalsIgnoreCase("BALLBLACK")) {
			temp = TexturePackerHelper.Ballblack_TiledTexture;
		} else if (ID.equalsIgnoreCase("CUP")) {
			temp = TexturePackerHelper.Cup_TiledTexture;
		} else if (ID.equalsIgnoreCase("EGGGOLDEN")) {
			temp = TexturePackerHelper.Egggolden_TiledTexture;
		} else if (ID.equalsIgnoreCase("GROUNDBIG")) {
			temp = TexturePackerHelper.groundbig_TiledTexture;
		} else if (ID.equalsIgnoreCase("GROUNDSMALL")) {
			temp = TexturePackerHelper.groundsmall_TiledTexture;
		} else if (ID.equalsIgnoreCase("GROUNDLONG")) {
			temp = TexturePackerHelper.groundlong_TiledTexture;
		} else if (ID.equalsIgnoreCase("GROUNDMEDIUM")) {
			temp = TexturePackerHelper.groundmedium_TiledTexture;
		} else if (ID.equalsIgnoreCase("GROUNDSHORT")) {
			temp = TexturePackerHelper.groundshort_TiledTexture;
		} else if (ID.equalsIgnoreCase("BANANA")) {
			temp = TexturePackerHelper.Banana_TiledTexture;
		} else if (ID.equalsIgnoreCase("CHEST")) {
			temp = TexturePackerHelper.Chest_TiledTexture;
		}

	}
}
