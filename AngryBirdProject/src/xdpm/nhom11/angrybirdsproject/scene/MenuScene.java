package xdpm.nhom11.angrybirdsproject.scene;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class MenuScene extends BaseScene implements OnClickListener {

	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;
	private final int MENU_SOUND = 2;
	private final int MENU_ABOUT = 3;
	private final int MENU_close_about = 7;

	IUpdateHandler iupdate_option_rec;
	HUD hud;

	Rectangle rec_black;

	ButtonSprite play, options, volume, about, close_about;

	Rectangle option_rec;
	Boolean is_option_rec;
	Boolean is_option_click;
	Boolean is_active_scene;
	Sprite skin_option;
	Sprite nen_kt2;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		is_option_rec = false;
		is_option_click = false;
		is_active_scene = true;

		CreateBackground();
		CreateGameHUD();
		AlphaScene();

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		super.disposeScene();
		this.unregisterUpdateHandler(iupdate_option_rec);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MENU;
	}

	public void CreateGameHUD() {
		hud = new HUD();
		Game.getInstance().camera.setHUD(hud);

		// BUTTON PLAY
		play = new ButtonSprite(Game.getInstance().camera.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2,
				TexturePackerHelper.play_btn_TiledTexture,
				Game.getInstance().vbom);
		play.setTag(MENU_PLAY);

		// BUTTON OPTIONS

		options = new ButtonSprite(Game.getInstance().camera.getWidth() - 60,
				60, TexturePackerHelper.empty_btn_TiledTexture,
				Game.getInstance().vbom);
		options.setTag(MENU_OPTIONS);
		options.setZIndex(0);
		// Vong tron xoay quanh Option
		skin_option = new Sprite(options.getWidth() / 2 - 1,
				options.getHeight() / 2 + 7,
				TexturePackerHelper.optionskin_btn_TiledTexture,
				Game.getInstance().vbom);
		options.attachChild(skin_option);
		skin_option.setZIndex(1);

		// Vien bao boc 2 option
		option_rec = new Rectangle(options.getWidth() / 2,
				options.getHeight() / 2 - 25, 70, 50, Game.getInstance().vbom);
		option_rec.setColor(Color.BLACK);
		option_rec.setAlpha(0.2f);

		options.attachChild(option_rec);

		// cho hinh chu nhat nam duoi
		option_rec.setZIndex(-1);
		options.sortChildren();
		option_rec.setAnchorCenterY(0);
		setActionOption();
		this.registerUpdateHandler(iupdate_option_rec);
		// VOLUME
		// volume = new ButtonSprite(0,
		// 0,TexturePackerHelper.volumeinoption_btn_TiledTexture.getTextureRegion(0),
		// Game.getInstance().vbom);

		volume = new ButtonSprite(0, 0,
				TexturePackerHelper.volumeinoption_btn_TiledTexture,
				Game.getInstance().vbom);

		volume.setPosition(option_rec.getX(),
				options.getY() + options.getHeight() - volume.getHeight() / 2);
		volume.setTag(MENU_SOUND);

		if (Game.getInstance().engine.getEngineOptions().getAudioOptions()
				.getSoundOptions().needsSound() == true) {
			volume.setCurrentTileIndex(0);
		} else {
			volume.setCurrentTileIndex(1);
		}

		options.attachChild(volume);
		volume.setVisible(false);

		about = new ButtonSprite(0, 0,
				TexturePackerHelper.about_btn_TiledTexture,
				Game.getInstance().vbom);
		about.setPosition(option_rec.getX(), volume.getY() + volume.getHeight());
		about.setTag(MENU_ABOUT);

		options.attachChild(about);
		about.setVisible(false);

		play.setOnClickListener(this);
		options.setOnClickListener(this);
		volume.setOnClickListener(this);
		about.setOnClickListener(this);

		hud.registerTouchArea(play);
		hud.registerTouchArea(options);
		hud.registerTouchArea(volume);
		hud.registerTouchArea(about);

		hud.attachChild(play);
		hud.attachChild(options);
	}

	public void setActionOption() {
		iupdate_option_rec = new IUpdateHandler() {
			@Override
			public void reset() {
			}

			@Override
			public void onUpdate(float pSecondsElapsed) {
				// tang chieu dai
				if (is_option_click == true && option_rec.getHeight() <= 220) {
					option_rec.setHeight(option_rec.getHeight() + 5);
					if (option_rec.getHeight() + option_rec.getY() >= volume
							.getY())
						volume.setVisible(true);

					if (option_rec.getHeight() + option_rec.getY() >= about
							.getY())
						about.setVisible(true);
				}
				// giam chieu dai
				if (is_option_click == false && option_rec.getHeight() >= 50) {
					option_rec.setHeight(option_rec.getHeight() - 5);
					if (option_rec.getHeight() + option_rec.getY() <= volume
							.getY())
						volume.setVisible(false);
					if (option_rec.getHeight() + option_rec.getY() <= about
							.getY())
						about.setVisible(false);
				}
			}
		};
	}

	public void scene_about() {
		rec_black.setColor(Color.BLACK);
		rec_black.setAlpha(0.8f);

		nen_kt2 = new Sprite(0, 0, TexturePackerHelper.Ketthuc_ID_2,
				Game.getInstance().vbom);

		close_about = new ButtonSprite(
				0,
				0,
				TexturePackerHelper.cancel_btn_TiledTexture.getTextureRegion(0),
				Game.getInstance().vbom);
		close_about.setTag(MENU_close_about);

		Text txt_name = new Text(0, 0, ResourcesManager.getInstance().font,
				"Nhom 11", Game.getInstance().vbom);

		txt_name.setScale(0.8f);
		close_about.setScale(0.6f);

		txt_name.setPosition(nen_kt2.getWidth() / 2, nen_kt2.getHeight() / 2);
		close_about.setPosition(nen_kt2.getWidth() / 2, 0);
		nen_kt2.setPosition(400, 240);

		nen_kt2.attachChild(txt_name);
		nen_kt2.attachChild(close_about);
		hud.attachChild(nen_kt2);

		close_about.setOnClickListener(this);
		hud.registerTouchArea(close_about);

	}

	public void AlphaScene() {
		rec_black = new Rectangle(Game.getInstance().camera.getCenterX(),
				Game.getInstance().camera.getCenterY(), 2000, 2000,
				Game.getInstance().vbom);

		rec_black.setAlpha(0.0f);
		hud.attachChild(rec_black);

	}

	@Override
	public void CreateBackground() {
		// TODO Auto-generated method stub
		Sprite temp = new Sprite(Game.getInstance().camera.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2,
				TexturePackerHelper.BACKGROUNDS_LS_ID, Game.getInstance().vbom);
		temp.setScale(Game.getInstance().camera.getHeight() / temp.getHeight());
		this.setBackground(new SpriteBackground(temp));
	}

	// Tao man hinh den phu len scene

	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		// TODO Auto-generated method stub

		switch (pButtonSprite.getTag()) {
		case MENU_PLAY:

			SceneManager.getInstance().setScene(SceneType.SCENE_WORLD);

			break;
		case MENU_OPTIONS:

			skin_option.setRotation(0);

			// check xem button option click
			if (is_option_click == false)
				is_option_click = true;
			else
				is_option_click = false;

			skin_option.clearEntityModifiers();
			skin_option.registerEntityModifier(new RotationModifier(0.5f, 0,
					180));

			break;
		case MENU_ABOUT:
			play.setVisible(false);
			options.setVisible(false);
			rec_black.setColor(Color.BLACK);
			rec_black.setAlpha(0.8f);
			scene_about();
			break;
		case MENU_SOUND:

			if (Game.getInstance().engine.getEngineOptions().getAudioOptions()
					.needsSound() == true) {
				volume.setCurrentTileIndex(0);
			} else {

				volume.setCurrentTileIndex(1);
			}

			if (volume.getCurrentTileIndex() == 0) {

				volume.setCurrentTileIndex(1);
				Game.getInstance().engine.getEngineOptions().getAudioOptions()
						.setNeedsSound(false);

			} else {

				volume.setCurrentTileIndex(0);

				Game.getInstance().engine.getEngineOptions().getAudioOptions()
						.setNeedsSound(true);

			}

			break;
		case MENU_close_about:
			rec_black.setAlpha(0.0f);
			hud.detachChild(nen_kt2);
			play.setVisible(true);
			options.setVisible(true);
			break;
		}

	}
}
