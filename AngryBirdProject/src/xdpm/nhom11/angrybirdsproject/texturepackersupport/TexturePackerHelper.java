package xdpm.nhom11.angrybirdsproject.texturepackersupport;

import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackerTextureRegion;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;

import android.content.ContextWrapper;

public class TexturePackerHelper {
	// TiledTexureRegion CHIM
	public static TiledTextureRegion BLACK_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion BLUE_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion helmet_Pig_TiledTexture;
	public static TiledTextureRegion king_Big_TiledTexture;
	public static TiledTextureRegion large_Pig_TiledTexture;
	public static TiledTextureRegion medium_Pig_TiledTexture;
	public static TiledTextureRegion old_Pig_TiledTexture;
	public static TiledTextureRegion red_Bird_TiledTexture;
	public static TiledTextureRegion sling_TiledTexture;
	public static TiledTextureRegion slingshot_TiledTexture;
	public static TiledTextureRegion small_Pig_TiledTexture;
	public static TiledTextureRegion white_Bird_Egg_TiledTexture;
	public static TiledTextureRegion white_Bird_TiledTexture;
	public static TiledTextureRegion yellow_Bird_TiledTexture;

	// TiledTextureRegion HÌNH NỀN
	public static TiledTextureRegion BackGround_TiledTexture;
	public static TiledTextureRegion Earth_TiledTexture;

	// TiledTextureRegion VẬT LIỆU
	public static TiledTextureRegion CirBig_ice_TiledTexture;
	public static TiledTextureRegion CirBig_rock_TiledTexture;
	public static TiledTextureRegion CirBig_wood_TiledTexture;
	public static TiledTextureRegion CirMedium_ice_TiledTexture;
	public static TiledTextureRegion CirMedium_rock_TiledTexture;
	public static TiledTextureRegion CirMedium_wood_TiledTexture;
	public static TiledTextureRegion RecEmpty_ice_TiledTexture;
	public static TiledTextureRegion RecEmpty_rock_TiledTexture;
	public static TiledTextureRegion RecEmpty_wood_TiledTexture;
	public static TiledTextureRegion RecFull_ice_TiledTexture;
	public static TiledTextureRegion RecFull_roc_TiledTexture;
	public static TiledTextureRegion RecFull_wood_TiledTexture;
	public static TiledTextureRegion RecLong_ice_TiledTexture;
	public static TiledTextureRegion RecLong_rock_TiledTexture;
	public static TiledTextureRegion RecLong_wood_TiledTexture;
	public static TiledTextureRegion RecMedium_ice_TiledTexture;
	public static TiledTextureRegion RecMedium_rock_TiledTexture;
	public static TiledTextureRegion RecMedium_wood_TiledTexture;
	public static TiledTextureRegion RecShort_ice_TiledTexture;
	public static TiledTextureRegion RecShort_rock_TiledTexture;
	public static TiledTextureRegion RecShort_wood_TiledTexture;
	public static TiledTextureRegion RecShortest_ice_TiledTexture;
	public static TiledTextureRegion RecShortest_rock_TiledTexture;
	public static TiledTextureRegion RecShortest_wood_TiledTexture;
	public static TiledTextureRegion SquareMedium_ice_TiledTexture;
	public static TiledTextureRegion SquareMedium_rock_TiledTexture;
	public static TiledTextureRegion SquareMedium_wood_TiledTexture;
	public static TiledTextureRegion SquareSmall_ice_TiledTexture;
	public static TiledTextureRegion SquareSmall_rock_TiledTexture;
	public static TiledTextureRegion SquareSmall_wood_TiledTexture;
	public static TiledTextureRegion TriaEmpty_ice_TiledTexture;
	public static TiledTextureRegion TriaEmpty_rock_TiledTexture;
	public static TiledTextureRegion TriaEmpty_wood_TiledTexture;
	public static TiledTextureRegion TriaFull_ice_TiledTexture;
	public static TiledTextureRegion TriaFull_rock_TiledTexture;
	public static TiledTextureRegion TriaFull_wood_TiledTexture;
	public static TiledTextureRegion other_1_TiledTexture;
	public static TiledTextureRegion other_2_TiledTexture;
	public static TiledTextureRegion other_3_TiledTexture;
	public static TiledTextureRegion TNT_TiledTexture;
	public static TiledTextureRegion Wheel_TiledTexture;
	public static TiledTextureRegion Watermelon_TiledTexture;
	public static TiledTextureRegion Lemon_TiledTexture;
	public static TiledTextureRegion Flag_TiledTexture;
	public static TiledTextureRegion Flag_VN_TiledTexture;
	public static TiledTextureRegion Diamond_TiledTexture;
	public static TiledTextureRegion Wheelsmall_TiledTexture;
	public static TiledTextureRegion Wheelmedium_TiledTexture;
	public static TiledTextureRegion Berry_TiledTexture;
	public static TiledTextureRegion Egg_TiledTexture;
	public static TiledTextureRegion Ballred_TiledTexture;
	public static TiledTextureRegion Ballblack_TiledTexture;
	public static TiledTextureRegion Cup_TiledTexture;
	public static TiledTextureRegion Egggolden_TiledTexture;
	public static TiledTextureRegion groundbig_TiledTexture;
	public static TiledTextureRegion groundmedium_TiledTexture;
	public static TiledTextureRegion groundsmall_TiledTexture;
	public static TiledTextureRegion groundlong_TiledTexture;
	public static TiledTextureRegion groundshort_TiledTexture;
	public static TiledTextureRegion Banana_TiledTexture;
	public static TiledTextureRegion Chest_TiledTexture;

	public static TexturePackTextureRegionLibrary texturePackLibrary;
	public static TexturePack texturePack;

	public TexturePackerHelper(BaseGameActivity baseGameActivity,
			ContextWrapper contextWrapper) {
		loadTiledTextureBlocks(baseGameActivity, contextWrapper);
		loadTiledTextureSprites(baseGameActivity, contextWrapper);
		loadTiledTextureBackGrounds(baseGameActivity, contextWrapper);
	}

	// LÂ�?Y SPRITES TỪ SHEET
	private ITiledTextureRegion getSpriteFromSheet(int id, int columns, int rows) {
		TexturePackerTextureRegion localTexturePackTextureRegion = (TexturePackerTextureRegion) texturePackLibrary
				.getIDMapping().get(id);
		return TiledTextureRegion.create(
				localTexturePackTextureRegion.getTexture(),
				(int) localTexturePackTextureRegion.getTextureX(),
				(int) localTexturePackTextureRegion.getTextureY(),
				(int) localTexturePackTextureRegion.getWidth(),
				(int) localTexturePackTextureRegion.getHeight(), columns, rows,
				localTexturePackTextureRegion.isRotated());

	}

	private void loadTiledTextureSprites(BaseGameActivity baseGameActivity,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(
					baseGameActivity.getTextureManager(), "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "BirdAndPig.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		BLACK_BIRD_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.BLACK_BIRD_ID, 7, 1);
		BLUE_BIRD_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.BLUE_BIRD_ID, 4, 1);
		helmet_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.HELMET_PIG_ID, 9, 1);
		king_Big_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.KING_PIG_ID, 9, 1);
		large_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.LARGE_PIG_ID, 9, 1);
		medium_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.MEDIUM_PIG_ID, 9, 1);
		old_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.OLD_PIG_ID, 9, 1);
		red_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.RED_BIRD_ID, 5, 1);
		sling_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SLING_ID, 1, 1);
		slingshot_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SLINGSHOT_ID, 2, 1);
		small_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SMALL_PIG_ID, 9, 1);
		white_Bird_Egg_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.WHITE_BIRD_EGG_ID, 1, 1);
		white_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.WHITE_BIRD_ID, 5, 1);
		yellow_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.YELLOW_BIRD_ID, 6, 1);

	}

	private void loadTiledTextureBackGrounds(BaseGameActivity baseGameActivity,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(
					baseGameActivity.getTextureManager(), "gfx/")
					.loadFromAsset(contextWrapper.getAssets(),
							"BackGrounds.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		// BackGround_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
		// MyBackGrounds.BACKGROUND_ID, 1, 1);
		// Earth_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
		// MyBackGrounds.EARTH_ID, 1, 1);
	}

	private void loadTiledTextureBlocks(BaseGameActivity baseGameActivity,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(
					baseGameActivity.getTextureManager(), "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "Block.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
		CirBig_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRBIG_ICE_ID, 4, 1);
		CirBig_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRBIG_ROCK_ID, 4, 1);
		CirBig_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRBIG_WOOD_ID, 4, 1);
		CirMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRMEDIUM_ICE_ID, 4, 1);
		CirMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRMEDIUM_ROCK_ID, 4, 1);
		CirMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CIRMEDIUM_WOOD_ID, 4, 1);
		RecEmpty_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECEMPTY_ICE_ID, 4, 1);
		RecEmpty_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECEMPTY_ROCK_ID, 4, 1);
		RecEmpty_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECEMPTY_ROCK_ID, 4, 1);
		RecFull_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECFULL_ICE_ID, 4, 1);
		RecFull_roc_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECFULL_ROCK_ID, 4, 1);
		RecFull_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECFULL_WOOD_ID, 4, 1);
		RecLong_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECLONG_ICE_ID, 4, 1);
		RecLong_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECLONG_ROCK_ID, 4, 1);
		RecLong_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECLONG_WOOD_ID, 4, 1);
		RecMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECMEDIUM_ICE_ID, 4, 1);
		RecMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECMEDIUM_ROCK_ID, 4, 1);
		RecMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECMEDIUM_WOOD_ID, 4, 1);
		RecShort_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORT_ICE_ID, 4, 1);
		RecShort_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORT_ROCK_ID, 4, 1);
		RecShort_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORT_WOOD_ID, 4, 1);
		RecShortest_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORTEST_ICE_ID, 4, 1);
		RecShortest_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORTEST_ROCK_ID, 4, 1);
		RecShortest_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.RECSHORTEST_WOOD_ID, 4, 1);
		SquareMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUAREMEDIUM_ICE_ID, 4, 1);
		SquareMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUAREMEDIUM_ROCK_ID, 4, 1);
		SquareMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUAREMEDIUM_WOOD_ID, 4, 1);
		SquareSmall_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUARESMALL_ICE_ID, 4, 1);
		SquareSmall_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUARESMALL_ROCK_ID, 4, 1);
		SquareSmall_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.SQUARESMALL_WOOD_ID, 4, 1);
		TriaEmpty_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAEMPTY_ICE_ID, 4, 1);
		TriaEmpty_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAEMPTY_ROCK_ID, 4, 1);
		TriaEmpty_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAEMPTY_WOOD_ID, 4, 1);
		TriaFull_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAFULL_ICE_ID, 4, 1);
		TriaFull_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAFULL_ROCK_ID, 4, 1);
		TriaFull_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TRIAFULL_WOOD_ID, 4, 1);
		other_1_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.OTHER_1_ID, 1, 1);
		other_2_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.OTHER_2_ID, 1, 1);
		other_3_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.OTHER_3_ID, 1, 1);
		TNT_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.TNT_ID, 1, 1);
		Wheel_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.WHEEL_ID, 1, 1);
		Watermelon_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.WATERMELON_ID, 1, 1);
		Lemon_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.LEMON_ID, 1, 1);
		Flag_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.FLAG_ID, 1, 1);
		Flag_VN_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.FLAG_VN_ID, 1, 1);
		Diamond_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.DIAMOND_ID, 1, 1);
		Wheelsmall_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.WHEELSMALL_ID, 1, 1);
		Wheelmedium_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.WHEELMEDIUM_ID, 1, 1);
		Berry_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.BERRY_ID, 1, 1);
		Egg_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.EGG_ID, 1, 1);
		Ballred_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.BALLRED_ID, 1, 1);
		Ballblack_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.BALLBLACK_ID, 1, 1);
		Cup_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CUP_ID, 1, 1);
		Egggolden_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.EGGGOLDEN_ID, 1, 1);
		groundbig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.GROUNDBIG_ID, 1, 1);
		groundmedium_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.GROUNDMEDIUM_ID, 1, 1);
		groundsmall_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.GROUNDSMALL_ID, 1, 1);
		groundlong_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.GROUNDLONG_ID, 1, 1);
		groundshort_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.GROUNDSHORT_ID, 1, 1);
		Banana_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.BANANA_ID, 1, 1);
		Chest_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.CHEST_ID, 1, 1);

	}
}
