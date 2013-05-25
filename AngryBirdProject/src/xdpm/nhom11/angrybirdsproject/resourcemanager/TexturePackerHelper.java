package xdpm.nhom11.angrybirdsproject.resourcemanager;

import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackerTextureRegion;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.debug.Debug;

import android.content.ContextWrapper;

public class TexturePackerHelper {
	// TiledTexureRegion CHIM
	public static TiledTextureRegion BLACK_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion BLUE_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion WHITE_BIRD_EGG_TILEDTEXTURE;
	public static TiledTextureRegion WHITE_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion YELLOW_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion HELMET_PIG_TILEDTEXTURE;
	public static TiledTextureRegion RED_BIRD_TILEDTEXTURE;
	public static TiledTextureRegion KING_PIG_TILEDTEXTURE;
	public static TiledTextureRegion LARGE_PIG_TILEDTEXTURE;
	public static TiledTextureRegion MEDIUM_PIG_TILEDTEXTURE;
	public static TiledTextureRegion OLD_PIG_TILEDTEXTURE;

	public static TiledTextureRegion Full_background;
	public static TiledTextureRegion SLING_TILEDTEXTURE;
	public static TiledTextureRegion SLINGSHOT_TILEDTEXTURE;
	public static TiledTextureRegion SMALL_PIG_TILEDTEXTURE;

	// TiledTextureRegion HÌNH NỀN
	public static TiledTextureRegion background_1_TiledTexture;
	public static TiledTextureRegion surface_TiledTexture;

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

	// BUTTON
	public static TiledTextureRegion about_btn_TiledTexture;
	public static TiledTextureRegion backtoepisode_btn_TiledTexture;
	public static TiledTextureRegion back_btn_TiledTexture;
	public static TiledTextureRegion cancel_btn_TiledTexture;
	public static TiledTextureRegion chooselevel_btn_TiledTexture;
	public static TiledTextureRegion empty_btn_TiledTexture;
	public static TiledTextureRegion gachnoi_TiledTexture;
	public static TiledTextureRegion left_btn_TiledTexture;
	public static TiledTextureRegion right_btn_TiledTexture;
	public static TiledTextureRegion locklevel_TiledTexture;
	public static TiledTextureRegion nextingame_btn_TiledTexture;
	public static TiledTextureRegion nextinmenu_TiledTexture;
	public static TiledTextureRegion number_TiledTexture;
	public static TiledTextureRegion ok_btn_TiledTexture;
	public static TiledTextureRegion optioninstatic_btn_TiledTexture;
	public static TiledTextureRegion optionskin_btn_TiledTexture;
	public static TiledTextureRegion pause_btn_TiledTexture;
	public static TiledTextureRegion play_btn_TiledTexture;
	public static TiledTextureRegion replayingame_btn_TiledTexture;
	public static TiledTextureRegion replayinmenu_btn_TiledTexture;
	public static TiledTextureRegion resume_btn_TiledTexture;
	public static TiledTextureRegion tutorial_btn_TiledTexture;
	public static TiledTextureRegion volumeinmenu_btn_TiledTexture;
	public static TiledTextureRegion volumeinoption_btn_TiledTexture;

	// WORLD
	public static TiledTextureRegion lockworld_TiledTexture;
	public static TiledTextureRegion scoreworld_TiledTexture;
	public static TiledTextureRegion starworld_TiledTexture;
	public static TiledTextureRegion world1_TiledTexture;
	public static TiledTextureRegion world2_TiledTexture;
	public static TiledTextureRegion world3_TiledTexture;
	public static TiledTextureRegion world4_TiledTexture;
	public static TiledTextureRegion world5_TiledTexture;
	public static TiledTextureRegion world6_TiledTexture;
	public static TiledTextureRegion world7_TiledTexture;
	public static TiledTextureRegion world8_TiledTexture;

	// SCORE
	public static TiledTextureRegion score_3k_pink_TiledTexture;
	public static TiledTextureRegion score_3k_purple_TiledTexture;
	public static TiledTextureRegion score_3k_red_TiledTexture;
	public static TiledTextureRegion score_3k_yellow_TiledTexture;
	public static TiledTextureRegion score_5k_green_TiledTexture;
	public static TiledTextureRegion score_10k_black_TiledTexture;
	public static TiledTextureRegion score_10k_blue_TiledTexture;
	public static TiledTextureRegion score_10k_green_TiledTexture;
	public static TiledTextureRegion score_10k_orange_TiledTexture;
	public static TiledTextureRegion score_10k_pink_TiledTexture;
	public static TiledTextureRegion score_10k_red_TiledTexture;
	public static TiledTextureRegion score_10k_white_TiledTexture;
	public static TiledTextureRegion score_10k_yellow_TiledTexture;

	// effect
	public static TiledTextureRegion explode_blacksmoke_TiledTexture;
	public static TiledTextureRegion explode_whitesmoke_TiledTexture;
	public static TiledTextureRegion blue_feather_TiledTexture;
	public static TiledTextureRegion black_feather_TiledTexture;
	public static TiledTextureRegion red_feather_TiledTexture;
	public static TiledTextureRegion yellow_feather_TiledTexture;
	public static TiledTextureRegion wood_feather_TiledTexture;
	public static TiledTextureRegion ice_feather_TiledTexture;
	public static TiledTextureRegion rock_feather_TiledTexture;
	public static TiledTextureRegion smoke_fagment_TiledTexture;

	public static TiledTextureRegion BACKGROUNDS_LS_ID;
	public static TiledTextureRegion SPLASHES_SHEET_1_ID;
	public static TiledTextureRegion SPLASHES_SHEET_2_ID;

	// gameSCENE
	public static TiledTextureRegion Popup_ID_1;
	public static TiledTextureRegion Ketthuc_ID_1;
	public static TiledTextureRegion Ketthuc_ID_2;

	// MAP BACKGROUND2;
	public static TiledTextureRegion MapBackground2_sky;
	public static TiledTextureRegion MapBackground2_;

	public static TexturePackTextureRegionLibrary texturePackLibrary;
	public static TexturePack texturePack;

	public TexturePackerHelper(TextureManager texturemanager,
			ContextWrapper contextWrapper) {

	}

	public void Load(TextureManager texturemanager,
			ContextWrapper contextWrapper) {

		loadTiledTextureBlocks(texturemanager, contextWrapper);
		loadTiledTextureBirdAndPig(texturemanager, contextWrapper);

		loadTiledTextureScore(texturemanager, contextWrapper);
		loadTiledTextureWorld(texturemanager, contextWrapper);
		loadTiledTextureButton(texturemanager, contextWrapper);

		loadTiledTextureGameScene(texturemanager, contextWrapper);
	}

	// LÂ�?Y SPRITES TỪ SHEET
	public static ITiledTextureRegion getSpriteFromSheet(int id, int columns,
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

	private void loadTiledTextureBirdAndPig(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
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
		HELMET_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.HELMET_PIG_ID, 9, 1);
		KING_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.KING_PIG_ID, 9, 1);
		LARGE_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.LARGE_PIG_ID, 9, 1);
		MEDIUM_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.MEDIUM_PIG_ID, 9, 1);
		OLD_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.OLD_PIG_ID, 9, 1);
		RED_BIRD_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.RED_BIRD_ID, 5, 1);
		SLING_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SLING_ID, 1, 1);
		SLINGSHOT_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SLINGSHOT_ID, 2, 1);
		SMALL_PIG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SMALL_PIG_ID, 9, 1);
		WHITE_BIRD_EGG_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.WHITE_BIRD_EGG_ID, 1, 1);
		WHITE_BIRD_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.WHITE_BIRD_ID, 5, 1);
		YELLOW_BIRD_TILEDTEXTURE = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.YELLOW_BIRD_ID, 6, 1);
		explode_whitesmoke_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.EXPLODE_WHITESMOKE_ID, 6, 1);
		explode_blacksmoke_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.EXPLODE_BLACKSMOKE_ID, 7, 1);
		blue_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.BLUE_FEATHER_ID, 2, 1);
		black_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.BLACK_FEATHER_ID, 2, 1);
		red_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.RED_FEATHER_ID, 4, 1);
		yellow_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.YELLOW_FEATHER_ID, 4, 1);
		smoke_fagment_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				BirdAndPig.SMOKE_FRAGMENT_ID, 4, 1);

	}

	public void loadBackgroundByID(TextureManager texturemanager,
			ContextWrapper contextWrapper, String ID) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(),
							"full_background.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
	}

	public void loadTiledTextureBackGround2s(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(),
							"Background2.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		BACKGROUNDS_LS_ID = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.Background2.BACKGROUNDS_LS_ID,
				1, 1);

		SPLASHES_SHEET_1_ID = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.Background2.SPLASHES_SHEET_1_ID,
				1, 1);

		SPLASHES_SHEET_2_ID = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.Background2.SPLASHES_SHEET_2_ID,
				1, 1);
	}

	private void loadTiledTextureBlocks(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
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
				Block.RECEMPTY_WOOD_ID, 4, 1);
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
		wood_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.WOOD_FRAGMENT_ID, 3, 1);
		ice_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.ICE_FRAGMENT_ID, 3, 1);
		rock_feather_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Block.ROCK_FRAGMENT_ID, 3, 1);

	}

	private void loadTiledTextureScore(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "Score.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
		score_10k_black_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_BLACK_ID, 1, 1);
		score_10k_blue_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_BLUE_ID, 1, 1);
		score_10k_green_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_GREEN_ID, 1, 1);
		score_10k_orange_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_ORANGE_ID, 1, 1);
		score_10k_pink_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_PINK_ID, 1, 1);
		score_10k_red_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_RED_ID, 1, 1);
		score_10k_white_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_WHITE_ID, 1, 1);
		score_10k_yellow_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_10K_YELLOW_ID, 1, 1);
		score_3k_pink_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_3K_PINK_ID, 1, 1);
		score_3k_purple_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_3K_PURPLE_ID, 1, 1);
		score_3k_red_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_3K_RED_ID, 1, 1);
		score_3k_yellow_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_3K_YELLOW_ID, 1, 1);
		score_5k_green_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Score.SCORE_5K_GREEN_ID, 1, 1);

	}

	private void loadTiledTextureWorld(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "World.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
		lockworld_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.LOCKWORLD_ID, 1, 1);
		scoreworld_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.SCOREWORLD_ID, 1, 1);
		starworld_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.STARWORLD_ID, 1, 1);
		world1_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD1_ID, 1, 1);
		world2_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD2_ID, 1, 1);
		world3_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD3_ID, 1, 1);
		world4_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD4_ID, 1, 1);
		world5_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD5_ID, 1, 1);
		world6_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD6_ID, 1, 1);
		world7_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD7_ID, 1, 1);
		world8_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				World.WORLD8_ID, 1, 1);

	}

	private void loadTiledTextureButton(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "Button.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}
		about_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.ABOUT_BTN_ID, 1, 1);
		back_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.BACK_BTN_ID, 1, 1);
		backtoepisode_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.BACKTOEPISODE_BTN_ID, 1, 1);
		cancel_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.CANCEL_BTN_ID, 1, 1);
		chooselevel_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.CHOOSELEVEL_BTN_STRIP6_ID, 6, 1);
		empty_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.EMPTY_BTN_ID, 1, 1);
		gachnoi_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.GACHNOI_ID, 1, 1);
		left_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.LEFT_BTN_ID, 1, 1);
		locklevel_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.LOCKLEVEL_ID, 1, 1);
		nextingame_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.NEXTINGAME_BTN_ID, 1, 1);
		nextinmenu_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.NEXTINMENU_BTN_ID, 1, 1);
		number_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.NUMBER_STRIP10_ID, 10, 1);
		ok_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.OK_BTN_ID, 1, 1);
		optioninstatic_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.OPTIONINSTATIC_BTN_ID, 1, 1);
		optionskin_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.OPTIONSKIN_BTN_ID, 1, 1);
		pause_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.PAUSE_BTN_ID, 1, 1);
		play_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.PLAY_BTN_ID, 1, 1);
		replayingame_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.REPLAYINGAME_BTN_ID, 1, 1);
		replayinmenu_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.REPLAYINMENU_BTN_ID, 1, 1);
		resume_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.RESUME_BTN_ID, 1, 1);
		right_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.RIGHT_BTN_ID, 1, 1);
		tutorial_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.TUTORIAL_BTN_ID, 1, 1);
		volumeinmenu_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.VOLUMEINMENU_BTN_ID, 2, 1);
		volumeinoption_btn_TiledTexture = (TiledTextureRegion) getSpriteFromSheet(
				Button.VOLUMEINOPTION_BTN_ID, 2, 1);

	}

	private void loadTiledTextureGameScene(TextureManager texturemanager,
			ContextWrapper contextWrapper) {
		try {
			texturePack = new TexturePackLoader(texturemanager, "gfx/")
					.loadFromAsset(contextWrapper.getAssets(), "GameScene.xml");
			texturePack.loadTexture();
			texturePackLibrary = texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		Popup_ID_1 = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.GameScene.ID_popup,
				1, 1);

		Ketthuc_ID_1 = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.GameScene.ID_ketthuc_1,
				1, 1);

		Ketthuc_ID_2 = (TiledTextureRegion) getSpriteFromSheet(
				xdpm.nhom11.angrybirdsproject.resourcemanager.GameScene.ID_ketthuc_2,
				1, 1);

	}

}
