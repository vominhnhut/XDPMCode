package xdpm.nhom11.angrybirdsproject.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ClickDetector;
import org.andengine.input.touch.detector.ClickDetector.IClickDetectorListener;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.input.touch.detector.SurfaceScrollDetector;
import org.andengine.util.adt.color.Color;

import android.net.wifi.WpsInfo;
import android.util.Log;

import xdpm.nhom11.angrybirdsproject.data.Chapter;
import xdpm.nhom11.angrybirdsproject.data.Level;
import xdpm.nhom11.angrybirdsproject.manager.DataManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;

import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOChapter;

public class LevelScene extends BaseScene implements IScrollDetectorListener,
		IOnSceneTouchListener, IClickDetectorListener, OnClickListener {

	List<ButtonSprite> ListLevelSprite;
	HUD gameHUD;
	// Scrolling

	boolean isScrolling = false;
	private SurfaceScrollDetector mScrollDetector;
	private ClickDetector mClickDetector;

	private final int WORLD_LEFT = 0;
	private final int WORLD_RIGHT = 1;
	private final int WORLD_BACK = 2;
	private final Boolean[] LEVEL_ITEM = { true, false, false, false, false,
			false, false, false, false, false, false, false, false, false,
			false };
	ButtonSprite left, right, back;
	IUpdateHandler Key_Back;

	ArrayList<Chapter> ListChapter;

	ArrayList<Rectangle> PageChapter;

	int pageIndex = 0;

	int row = 3;
	int col = 5;

	float widItem;
	float HeiItem;

	float widSpace = 20;
	float heiSpace = 30;

	Rectangle bgColor;

	private void CreateLevel(int indexpage) {

		widItem = TexturePackerHelper.locklevel_TiledTexture.getWidth();
		HeiItem = TexturePackerHelper.locklevel_TiledTexture.getHeight();

		PageChapter.get(indexpage);

		int i = 0;
		for (Level lv : ListChapter.get(indexpage).getListLevel()) {

			ButtonSprite lvsprite = new ButtonSprite(0, 0,
					TexturePackerHelper.chooselevel_btn_TiledTexture
							.getTextureRegion(indexpage),
					Game.getInstance().vbom);

			if (lv.isLocked()) {
				lvsprite.setTag(1);
				lvsprite.attachChild(new Sprite(lvsprite.getWidth() / 2,
						lvsprite.getHeight() / 2 + 12,
						TexturePackerHelper.locklevel_TiledTexture, Game
								.getInstance().vbom));

			} else {
				Text num = new Text(lvsprite.getWidth() / 2,
						lvsprite.getHeight() / 2 + 12,
						ResourcesManager.getInstance().font, i + 1 + "",
						Game.getInstance().vbom);
				num.setScale(0.5f);
				lvsprite.attachChild(num);
				lvsprite.setTag(0);
			}
			float b = 0;

			if (i >= (ListChapter.get(indexpage).getListLevel().size() - ListChapter
					.get(indexpage).getListLevel().size()
					% col)) {

				b = ListChapter.get(indexpage).getListLevel().size()
						- ((i / col) * col);
			} else {
				b = col;
			}

			Log.e(i + "", b + "");
			float a = b * widItem + (b - 1) * widSpace;
			float c = ((ListChapter.get(indexpage).getListLevel().size() - 1)
					/ col + 1)
					* HeiItem
					+ (((ListChapter.get(indexpage).getListLevel().size() - 1)
							/ col + 1) - 1) * heiSpace;
			lvsprite.setPosition(
					(PageChapter.get(indexpage).getWidth() / 2 - (a / 2))
							+ (i % col) * (widItem) + widItem / 2 + (i % col)
							* widSpace, PageChapter.get(indexpage).getHeight()
							/ 2 + c / 2 - (i / col) * HeiItem - HeiItem / 2
							- (i / col) * heiSpace);
			PageChapter.get(indexpage).attachChild(lvsprite);
			ListLevelSprite.add(lvsprite);
			i++;

		}

	}

	private void CreateChapter() {
		ListLevelSprite = new ArrayList<ButtonSprite>();

		ListChapter = new ArrayList<Chapter>();
		PageChapter = new ArrayList<Rectangle>();
		for (DTOChapter dtochapter : DataManager.getInstance().DTOListWorld
				.get(DataManager.getInstance().currentWorldChoosed).chapters) {
			ListChapter.add(new Chapter(dtochapter));

		}

		int x = 0;
		for (Chapter chapter : ListChapter) {
			Rectangle page = new Rectangle(x
					* (Game.getInstance().camera.getWidth())
					+ (Game.getInstance().camera.getWidth() / 2),
					Game.getInstance().camera.getCenterY(),
					Game.getInstance().camera.getWidth(),
					Game.getInstance().camera.getHeight(),
					Game.getInstance().vbom);
			page.setAlpha(0);

			PageChapter.add(page);
			CreateLevel(x);
			x++;
			this.attachChild(page);

		}
		bgColor = new Rectangle(0, 0, ListChapter.size()
				* Game.getInstance().camera.getWidth(),
				Game.getInstance().camera.getHeight(), Game.getInstance().vbom);
		bgColor.setAnchorCenter(0, 0);
		bgColor.setColor(Color.RED);
		bgColor.setAlpha(0.2f);
		bgColor.setZIndex(-5);
		this.attachChild(bgColor);
		Game.getInstance().camera.setBounds(0, 0,
				ListChapter.size() * Game.getInstance().camera.getWidth(),
				Game.getInstance().camera.getHeight());
		Game.getInstance().camera.setBoundsEnabled(true);

	}

	@Override
	public void createScene() {

		Game.getInstance().camera.setMaxVelocityX(3000);

		// danh sach cac man choi qua

		CreateGameHUD();

		CreateBackground();
		CreateChapter();
		this.sortChildren();
		pageIndex = DataManager.getInstance().currentChapterChoosed;
		ChangePage(pageIndex);

		this.mScrollDetector = new SurfaceScrollDetector(this);
		this.mClickDetector = new ClickDetector(this);

		this.setOnSceneTouchListener(this);
		this.setTouchAreaBindingOnActionDownEnabled(true);
		this.setTouchAreaBindingOnActionMoveEnabled(true);
		this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);

	}

	@Override
	public void onBackKeyPressed() {

	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		this.detachChildren();
		super.disposeScene();

	}

	@Override
	public void onClick(ClickDetector pClickDetector, int pPointerID,
			float pSceneX, float pSceneY) {
		if (isScrolling == false)
			for (int i = 0; i < ListLevelSprite.size(); i++)
				if (ListLevelSprite.get(i).contains(pSceneX, pSceneY)
						&& ListLevelSprite.get(i).getTag() == 0) {
					Game.getInstance().camera.setHUD(null);
					DataManager.getInstance().currentLevelChoosed = getIndexLevel(i);
					SceneManager.getInstance().setScene(SceneType.SCENE_GAME);
				}

	}

	private int getIndexLevel(int x) {
		int temp = 0;
		for (int i = 0; i < DataManager.getInstance().currentChapterChoosed; i++) {

			temp += ListChapter.get(i).getListLevel().size();

		}
		return x - temp;
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {

		this.mClickDetector.onTouchEvent(pSceneTouchEvent);
		this.mScrollDetector.onTouchEvent(pSceneTouchEvent);

		return true;
	}

	@Override
	public void onScrollStarted(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {
		isScrolling = true;
	}

	float tscoll = 0;

	@Override
	public void onScroll(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {
		tscoll = pDistanceX;
	}

	@Override
	public void onScrollFinished(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {

		if (tscoll > 0) {

			if (pageIndex - 1 >= 0) {
				pageIndex--;
				ChangePage(pageIndex);

			}
		} else {
			if (pageIndex + 1 < PageChapter.size()) {
				pageIndex++;
				ChangePage(pageIndex);
			}
		}
		isScrolling = false;
	}

	@Override
	public void CreateBackground() {
		Sprite temp = new Sprite(Game.getInstance().camera.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2,
				TexturePackerHelper.BACKGROUNDS_LS_ID, Game.getInstance().vbom);
		temp.setScale(Game.getInstance().camera.getHeight() / temp.getHeight());
		this.setBackground(new SpriteBackground(temp));
	}

	private void ChangePage(int pageIndex) {

		if (pageIndex < PageChapter.size()) {
			DataManager.getInstance().currentChapterChoosed = pageIndex;
			Game.getInstance().camera.setCenter(PageChapter.get(pageIndex)
					.getX(), 0);
			ChangeColorPage();
		}

	}

	private void ChangeColorPage() {

		int ran = new Random().nextInt(5);
		Color color = null;
		switch (ran) {
		case 0:

			color = new Color(Color.RED);
			break;
		case 1:
			color = new Color(Color.BLUE);
			break;
		case 2:
			color = new Color(Color.PINK);
			break;
		case 3:
			color = new Color(Color.YELLOW);
			break;
		case 4:
			color = new Color(Color.CYAN);
			break;

		}

		bgColor.setColor(color);
		bgColor.setAlpha(0.05f);
	}

	private void CreateGameHUD() {
		gameHUD = new HUD();
		Game.getInstance().camera.setHUD(gameHUD);

		left = new ButtonSprite(0, 0,
				TexturePackerHelper.left_btn_TiledTexture,
				Game.getInstance().vbom);
		left.setTag(WORLD_LEFT);
		// Get button right
		right = new ButtonSprite(0, 0,
				TexturePackerHelper.right_btn_TiledTexture,
				Game.getInstance().vbom);
		right.setTag(WORLD_RIGHT);
		// get button back
		back = new ButtonSprite(0, 0,
				TexturePackerHelper.back_btn_TiledTexture,
				Game.getInstance().vbom)

		;
		back.setTag(WORLD_BACK);
		left.setScale(0.8f);
		right.setScale(0.8f);
		back.setScale(0.8f);

		left.setOnClickListener(this);
		right.setOnClickListener(this);
		back.setOnClickListener(this);
		// add vao HUD
		gameHUD.attachChild(left);
		gameHUD.attachChild(right);
		gameHUD.attachChild(back);

		// dang ky touch
		gameHUD.registerTouchArea(left);
		gameHUD.registerTouchArea(right);
		gameHUD.registerTouchArea(back);

		// set vi tri
		left.setPosition(left.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2);
		right.setPosition(
				Game.getInstance().camera.getWidth() - left.getWidth() / 2,
				Game.getInstance().camera.getHeight() / 2);
		back.setPosition(back.getWidth() / 2, back.getHeight() / 2);
		gameHUD.sortChildren();

	}

	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
			float pTouchAreaLocalY) {
		switch (pButtonSprite.getTag()) {
		case WORLD_BACK:

			Game.getInstance().camera.setHUD(null);
			SceneManager.getInstance().setScene(SceneType.SCENE_WORLD);

			break;

		case WORLD_LEFT:
			if (pageIndex - 1 >= 0) {
				pageIndex--;
				ChangePage(pageIndex);

			}
			break;
		case WORLD_RIGHT:
			if (pageIndex + 1 < PageChapter.size()) {
				pageIndex++;
				ChangePage(pageIndex);
			}
			break;

		}

	}

}
