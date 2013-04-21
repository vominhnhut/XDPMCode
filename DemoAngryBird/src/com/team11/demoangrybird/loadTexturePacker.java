package com.team11.demoangrybird;

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

public class loadTexturePacker {
	// TiledTexureRegion CHIM
	public static TiledTextureRegion black_Bird_TiledTexture;
	public static TiledTextureRegion blue_Bird_TiledTexture;
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

	public static TexturePackTextureRegionLibrary texturePackLibrary;
	public static TexturePack texturePack;

	loadTexturePacker(BaseGameActivity baseGameActivity,
			ContextWrapper contextWrapper) {
		loadTiledTextureBlocks(baseGameActivity, contextWrapper);
		loadTiledTextureSprites(baseGameActivity, contextWrapper);
		loadTiledTextureBackGrounds(baseGameActivity, contextWrapper);
	}

	// LẤY SPRITES TỪ SHEET	
	private ITiledTextureRegion getSpriteFromSheet(int id, int columns,
			int rows) {
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

	private void loadTiledTextureSprites(
			BaseGameActivity baseGameActivity, ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(
					baseGameActivity.getTextureManager(), "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "Sprites.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		black_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.BLACK_BIRD_ID, 7, 1);
		blue_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.BLUE_BIRD_ID, 4, 1);
		helmet_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.HELMET_PIG_ID, 9, 1);
		king_Big_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.KING_PIG_ID, 9, 1);
		large_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.LARGE_PIG_ID, 9, 1);
		medium_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.MEDIUM_PIG_ID, 9, 1);
		old_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.OLD_PIG_ID, 9, 1);
		red_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.RED_BIRD_ID, 5, 1);
		sling_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.SLING_ID, 1, 1);
		slingshot_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.SLINGSHOT_ID, 2, 1);
		small_Pig_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.SMALL_PIG_ID, 9, 1);
		white_Bird_Egg_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.WHITE_BIRD_EGG_ID, 1, 1);
		white_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.WHITE_BIRD_ID, 1, 1);
		yellow_Bird_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MySprites.YELLOW_BIRD_ID, 6, 1);

	}

	private void loadTiledTextureBackGrounds(
			BaseGameActivity baseGameActivity, ContextWrapper contextWrapper) {
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

		BackGround_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBackGrounds.BACKGROUND_ID, 1, 1);
		Earth_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBackGrounds.EARTH_ID, 1, 1);
	}

	private void loadTiledTextureBlocks(
			BaseGameActivity baseGameActivity, ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(
					baseGameActivity.getTextureManager(), "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "Blocks.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
		CirBig_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRBIG_ICE_ID, 4, 1);
		CirBig_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRBIG_ROCK_ID, 4, 1);
		CirBig_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRBIG_WOOD_ID, 4, 1);
		CirMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRMEDIUM_ICE_ID, 4, 1);
		CirMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRMEDIUM_ROCK_ID, 4, 1);
		CirMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.CIRMEDIUM_WOOD_ID, 4, 1);
		RecEmpty_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECEMPTY_ICE_ID, 4, 1);
		RecEmpty_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECEMPTY_ROCK_ID, 4, 1);
		RecEmpty_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECEMPTY_ROCK_ID, 4, 1);
		RecFull_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECFULL_ICE_ID, 4, 1);
		RecFull_roc_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECFULL_ROCK_ID, 4, 1);
		RecFull_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECFULL_WOOD_ID, 4, 1);
		RecLong_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECLONG_ICE_ID, 4, 1);
		RecLong_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECLONG_ROCK_ID, 4, 1);
		RecLong_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECLONG_WOOD_ID, 4, 1);
		RecMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECMEDIUM_ICE_ID, 4, 1);
		RecMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECLONG_ROCK_ID, 4, 1);
		RecMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECMEDIUM_WOOD_ID, 4, 1);
		RecShort_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORT_ICE_ID, 4, 1);
		RecShort_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORT_ROCK_ID, 4, 1);
		RecShort_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORT_WOOD_ID, 4, 1);
		RecShortest_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORTEST_ICE_ID, 4, 1);
		RecShortest_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORTEST_ROCK_ID, 4, 1);
		RecShortest_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.RECSHORTEST_WOOD_ID, 4, 1);
		SquareMedium_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUAREMEDIUM_ICE_ID, 4, 1);
		SquareMedium_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUAREMEDIUM_ROCK_ID, 4, 1);
		SquareMedium_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUAREMEDIUM_WOOD_ID, 4, 1);
		SquareSmall_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUARESMALL_ICE_ID, 4, 1);
		SquareSmall_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUARESMALL_ROCK_ID, 4, 1);
		SquareSmall_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.SQUARESMALL_WOOD_ID, 4, 1);
		TriaEmpty_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAEMPTY_ICE_ID, 4, 1);
		TriaEmpty_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAEMPTY_ROCK_ID, 4, 1);
		TriaEmpty_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAEMPTY_WOOD_ID, 4, 1);
		TriaFull_ice_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAFULL_ICE_ID, 4, 1);
		TriaFull_rock_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAFULL_ROCK_ID, 4, 1);
		TriaFull_wood_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.TRIAFULL_WOOD_ID, 4, 1);
		other_1_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.OTHER_1_ID, 1, 1);
		other_2_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.OTHER_2_ID, 1, 1);
		other_3_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				MyBlocks.OTHER_3_ID, 1, 1);
	}
}
