package xdpm.nhom11.angrybirdsproject.scene;

import java.util.ArrayList;
import java.util.List;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
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

import android.provider.ContactsContract.Contacts.Data;
import android.util.Log;

import xdpm.nhom11.angrybirdsproject.data.World;
import xdpm.nhom11.angrybirdsproject.manager.DataManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOWorld;

public class WorldScene extends BaseScene implements IOnMenuItemClickListener,
        IScrollDetectorListener, IOnSceneTouchListener, IClickDetectorListener,
        OnClickListener {

    ArrayList<World> ListWorld;

    private final int WORLD_LEFT = 0;
    private final int WORLD_RIGHT = 1;
    private final int WORLD_BACK = 2;

    List<ButtonSprite> ListObjectInScene;

    ButtonSprite left, right, back;

    boolean iBack = true;

    HUD gameHUD;
    // Scrolling
    private SurfaceScrollDetector mScrollDetector;
    private ClickDetector mClickDetector;

    @Override
    public void createScene() {
        Game.getInstance().camera.setMaxVelocityX(800);
        CreateWorld();

        CreateGameHUD();
        CreateObjectInScene();

        CreateBackground();

        this.mScrollDetector = new SurfaceScrollDetector(this);
        this.mClickDetector = new ClickDetector(this);

        this.setOnSceneTouchListener(this);
        this.setTouchAreaBindingOnActionDownEnabled(true);
        this.setTouchAreaBindingOnActionMoveEnabled(true);
        this.setOnSceneTouchListenerBindingOnActionDownEnabled(true);

    }

    private void CreateWorld() {

        ListWorld = new ArrayList<World>();
        for (DTOWorld dtoworld : DataManager.getInstance().DTOListWorld) {

            ListWorld.add(new World(dtoworld));

        }

    }

    @Override
    public void onBackKeyPressed() {
        // TODO Auto-generated method stub

    }

    @Override
    public SceneType getSceneType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void disposeScene() {
        super.disposeScene();
        this.detachChildren();
    }

    @Override
    public void CreateBackground() {
        Sprite temp = new Sprite(Game.getInstance().camera.getWidth() / 2,
                Game.getInstance().camera.getHeight() / 2,
                TexturePackerHelper.BACKGROUNDS_LS_ID, Game.getInstance().vbom);
        temp.setScale(Game.getInstance().camera.getHeight() / temp.getHeight());
        this.setBackground(new SpriteBackground(temp));
    }

    private void CreateObjectInScene() {
        ListObjectInScene = new ArrayList<ButtonSprite>();
        float spritesX = left.getWidth() + 20;
        float spritesY = Game.getInstance().camera.getHeight() / 2;
        int i = 0;
        float space = 20;
        for (World world : ListWorld) {

            ButtonSprite worldSprite = new ButtonSprite(0, 0,
                    world.getTextureOfWorld(), Game.getInstance().vbom);
            worldSprite.setScaleX(1.2f);
            worldSprite
                    .setPosition(
                            i
                                    * (worldSprite.getWidth()
                                            * worldSprite.getScaleX() + space)
                                    + spritesX + worldSprite.getWidth() / 2,
                            Game.getInstance().camera.getCenterY());

            if (world.isLocked()) {
                worldSprite.setTag(1);
                ButtonSprite lock = new ButtonSprite(
                        worldSprite.getWidth() / 2,
                        worldSprite.getHeight() / 5,
                        TexturePackerHelper.lockworld_TiledTexture,
                        Game.getInstance().vbom);
                lock.setScale(0.8f);

                worldSprite.attachChild(lock);

            } else {
                worldSprite.setTag(0);
                ButtonSprite star = new ButtonSprite(
                        worldSprite.getWidth() / 2,
                        worldSprite.getHeight() / 5 + 30,
                        TexturePackerHelper.starworld_TiledTexture,
                        Game.getInstance().vbom);

                Text numstar = new Text(0, 0,
                        ResourcesManager.getInstance().font,
                        world.getCurrentStar() + "/" + world.getTotalStar(),
                        Game.getInstance().vbom);
                numstar.setColor(Color.WHITE);
                numstar.setScale(0.2f);
                numstar.setPosition(star.getWidth() / 2, 13);

                star.attachChild(numstar);

                ButtonSprite point = new ButtonSprite(
                        worldSprite.getWidth() / 2, worldSprite.getHeight() / 5
                                - star.getHeight() / 2 - 10,
                        TexturePackerHelper.scoreworld_TiledTexture,
                        Game.getInstance().vbom);

                worldSprite.attachChild(star);
                worldSprite.attachChild(point);

            }

            this.attachChild(worldSprite);
            ListObjectInScene.add(worldSprite);
            i++;

        }

        if (ListObjectInScene.size() > 0)
            if (ListObjectInScene.size()
                    * (ListObjectInScene.get(0).getWidth() + space) > Game
                        .getInstance().camera.getWidth()) {
                Game.getInstance().camera
                        .setBounds(0, 0,
                                ListObjectInScene.size()
                                        * (ListObjectInScene.get(0).getWidth()
                                                * ListObjectInScene.get(0)
                                                        .getScaleX() + space)
                                        + spritesX
                                        + ListObjectInScene.get(0).getWidth()
                                        / 2,
                                Game.getInstance().camera.getHeight());

            } else {
                Game.getInstance().camera.setBounds(0, 0,
                        Game.getInstance().camera.getWidth(),
                        Game.getInstance().camera.getHeight());
            }

        Game.getInstance().camera.setBoundsEnabled(true);

    }

    private void CreateGameHUD() {

        // Get button Left
        gameHUD = new HUD();
        Game.getInstance().camera.setHUD(gameHUD);
        left = new ButtonSprite(0, 0,
                TexturePackerHelper.left_btn_TiledTexture.getTextureRegion(0),
                Game.getInstance().vbom);
        left.setTag(WORLD_LEFT);
        // Get button right
        right = new ButtonSprite(0, 0,
                TexturePackerHelper.right_btn_TiledTexture.getTextureRegion(0),
                Game.getInstance().vbom);
        right.setTag(WORLD_RIGHT);
        // get button back
        back = new ButtonSprite(0, 0,
                TexturePackerHelper.back_btn_TiledTexture.getTextureRegion(0),
                Game.getInstance().vbom);

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
    }

    @Override
    public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
            float pTouchAreaLocalY) {
        switch (pButtonSprite.getTag()) {
        case WORLD_BACK:
            Game.getInstance().camera.setHUD(null);

            SceneManager.getInstance().setScene(SceneType.SCENE_MENU);
            break;

        case WORLD_LEFT:
            Game.getInstance().camera.offsetCenter(-200, 0);
            break;
        case WORLD_RIGHT:
            Game.getInstance().camera.offsetCenter(200, 0);
            break;
        }

    }

    @Override
    public void onClick(ClickDetector pClickDetector, int pPointerID,
            float pSceneX, float pSceneY) {

        if (isScrolling == false)
            for (int i = 0; i < ListObjectInScene.size(); i++)
                if (ListObjectInScene.get(i).contains(pSceneX, pSceneY)
                        && ListObjectInScene.get(i).getTag() == 0) {

                    DataManager.getInstance().currentWorldChoosed = i;
                    DataManager.getInstance().currentChapterChoosed = 0;
                    SceneManager.getInstance().setScene(SceneType.SCENE_LEVEL);
                    break;
                }

    }

    boolean isScrolling = false;

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

    int tscoll = 0;

    @Override
    public void onScroll(ScrollDetector pScollDetector, int pPointerID,
            float pDistanceX, float pDistanceY) {
        final float zoomFactor = Game.getInstance().camera.getZoomFactor();
        Game.getInstance().camera.setCenterDirect(
                -pDistanceX * 1.5f + Game.getInstance().camera.getCenterX(),
                Game.getInstance().camera.getCenterY());
        tscoll = (int) (-pDistanceX / zoomFactor);
    }

    @Override
    public void onScrollFinished(ScrollDetector pScollDetector, int pPointerID,
            float pDistanceX, float pDistanceY) {
        final float zoomFactor = Game.getInstance().camera.getZoomFactor();

        if ((int) (-pDistanceX / zoomFactor) > tscoll) {
            Game.getInstance().camera.offsetCenter(-200,
                    Game.getInstance().camera.getCenterY());
        } else {
            // Vector2 temp = getPigPosition();
            Game.getInstance().camera.offsetCenter(200,
                    Game.getInstance().camera.getCenterY());
        }

        isScrolling = false;
    }

    @Override
    public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
            float pMenuItemLocalX, float pMenuItemLocalY) {

        return false;
    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {
        // TODO Auto-generated method stub
        super.onManagedUpdate(pSecondsElapsed);

        for (ButtonSprite bt : ListObjectInScene) {

            bt.setScaleY(1 - Math.abs(bt.getX()
                    - Game.getInstance().camera.getCenterX()) / 2000);
            bt.setScaleX(1.2f - Math.abs(bt.getX()
                    - Game.getInstance().camera.getCenterX()) / 2000);

        }
    }
}
