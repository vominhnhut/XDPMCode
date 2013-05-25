package xdpm.nhom11.angrybirdsproject.scene;

import java.io.IOException;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.MoveXModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.color.Color;

import android.util.Log;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;

import xdpm.nhom11.angrybirdsproject.entities.Map;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager.SceneType;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class GameScene extends BaseScene implements IUpdateHandler, ITouchArea,
        OnClickListener {

    private final int MENU_backto = 0;
    private final int MENU_resume = 1;
    private final int MENU_help = 2;
    private final int MENU_replayinmenu = 3;
    private final int MENU_pause = 4;
    private final int MENU_replay = 5;
    private final int MENU_volume = 6;
    private final int MENU_backto_endgame = 7;
    private final int MENU_replay_endgame = 8;

    Map mMap;
    Sound mSound;

    HUD gameHUD;
    ButtonSprite pause, replay;

    // tao popup
    Rectangle popup, rec_black;
    // button in popup
    ButtonSprite backto, resume, help, replayinmenu;

    ButtonSprite backto_endgame, replay_endgame;

    ButtonSprite volume;

    Sprite nen_kt1, nen_kt2;
    Text hightscore_txt, score_txt;
    Text hightscore, score;
    Text txt_point;
    Text txt_name, txt_manchoi;

    MoveXModifier open, close;

    @Override
    public void createScene() {

        CreateBackground();
        CreateGameHuD();

        setActionPopup();

        CreateMapGame();

    }

    private void CreateMapGame() {

        mMap = new Map(Game.getInstance().activity, Game.getInstance().vbom);

        this.mMap.Load();

        this.mMap.Attached(this);

    }

    @Override
    public void onBackKeyPressed() {

    }

    @Override
    public SceneType getSceneType() {
        // TODO Auto-generated method stub
        return SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene() {
        this.detachChildren();
        if (mMap != null)
            mMap.UnloadResource();

        super.disposeScene();

    }

    @Override
    public void CreateBackground() {

    }

    @Override
    public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
        return super.onSceneTouchEvent(pSceneTouchEvent);
    }

    private void CreateGameHuD() {
        gameHUD = new HUD();
        Game.getInstance().camera.setHUD(gameHUD);
        setPoint();
        AlphaScene();
        // man hinh xanh goc trai

        // ################################################################################
        popup = new Rectangle(0, 0, Game.getInstance().camera.getWidth() / 3,
                Game.getInstance().camera.getHeight(), Game.getInstance().vbom);
        popup.setAnchorCenter(0, 0);

        popup.setColor(new Color((float) 97 / 255, (float) 212 / 255,
                (float) 187 / 255));
        popup.setAlpha(0.8f);
        popup.setPosition(-Game.getInstance().camera.getWidth() / 3 - 40, 0);
        // ################################################################################
        Sprite vien_popup = new Sprite(0, 0, TexturePackerHelper.Popup_ID_1,
                Game.getInstance().vbom);

        vien_popup.setPosition(popup.getWidth() - vien_popup.getWidth() / 2,
                popup.getHeight() / 2);
        vien_popup.setHeight(popup.getHeight());

        popup.attachChild(vien_popup);

        // ################################################################################
        // button pause (nut goi man hinh xanh goc trai)
        pause = new ButtonSprite(0, 0,
                TexturePackerHelper.pause_btn_TiledTexture,
                Game.getInstance().vbom);
        pause.setTag(MENU_pause);

        // choi lai man choi (goc tren ben trai)
        replay = new ButtonSprite(0, 0,
                TexturePackerHelper.replayingame_btn_TiledTexture,
                Game.getInstance().vbom);
        replay.setTag(MENU_replay);

        // set positison
        pause.setScale(1f);
        pause.setPosition(pause.getWidth() / 2 + 5,
                Game.getInstance().camera.getHeight() - pause.getHeight() / 2
                        - 5);

        replay.setScale(1f);
        replay.setPosition(replay.getWidth() / 2 + pause.getWidth() + 10,
                Game.getInstance().camera.getHeight() - replay.getHeight() / 2
                        - 5);

        // ################################################################################
        // ve man hinh chon level (nam trong man hinh xanh)
        backto = new ButtonSprite(0, 0,
                TexturePackerHelper.backtoepisode_btn_TiledTexture,
                Game.getInstance().vbom);
        backto.setTag(MENU_backto);

        replayinmenu = new ButtonSprite(0, 0,
                TexturePackerHelper.replayinmenu_btn_TiledTexture,
                Game.getInstance().vbom);
        replayinmenu.setTag(MENU_replayinmenu);

        help = new ButtonSprite(0, 0,
                TexturePackerHelper.tutorial_btn_TiledTexture,
                Game.getInstance().vbom);
        help.setTag(MENU_help);

        volume = new ButtonSprite(0, 0,
                TexturePackerHelper.volumeinmenu_btn_TiledTexture,
                Game.getInstance().vbom);

        // kiem tra volume da tat hay chua
        if (Game.getInstance().engine.getEngineOptions().getAudioOptions()
                .getSoundOptions().needsSound() == true) {
            volume.setCurrentTileIndex(0);
        } else {
            volume.setCurrentTileIndex(1);
        }

        volume.setTag(MENU_volume);

        // dong mo popup (dong man hinh xanh)
        resume = new ButtonSprite(0, 0,
                TexturePackerHelper.resume_btn_TiledTexture,
                Game.getInstance().vbom);
        resume.setTag(MENU_resume);

        // set positison
        backto.setPosition(popup.getWidth() / 2, 2 * popup.getHeight() / 4);
        replayinmenu.setPosition(popup.getWidth() / 2,
                3 * popup.getHeight() / 4);

        volume.setPosition(popup.getWidth() / 2, 1 * popup.getHeight() / 4);
        volume.setSize(backto.getWidth(), backto.getHeight());

        resume.setPosition(popup.getWidth(), popup.getHeight() / 2);

        // TEXT
        hightscore_txt = new Text(0, 0, ResourcesManager.getInstance().font,
                "hightscore", Game.getInstance().vbom);

        // hightscore_txt.setPosition(Game.getInstance().camera.getWidth() - 5,
        // Game.getInstance().camera.getHeight() - 5);
        hightscore_txt.setPosition(
                Game.getInstance().camera.getWidth()
                        - hightscore_txt.getWidth() / 2 - 5,
                Game.getInstance().camera.getHeight()
                        - hightscore_txt.getHeight() / 2);
        hightscore_txt.setScale(1f);

        // add vao popup
        popup.attachChild(volume);
        popup.attachChild(backto);
        popup.attachChild(replayinmenu);
        popup.attachChild(resume);
        // ################################################################################

        // add vao game HUD
        gameHUD.attachChild(pause);
        gameHUD.attachChild(replay);
        gameHUD.attachChild(popup);
        gameHUD.attachChild(hightscore_txt);

        // dang ky click
        pause.setOnClickListener(this);
        gameHUD.registerTouchArea(pause);

        replay.setOnClickListener(this);
        gameHUD.registerTouchArea(replay);

        resume.setOnClickListener(this);
        gameHUD.registerTouchArea(resume);

        backto.setOnClickListener(this);
        gameHUD.registerTouchArea(backto);

        replayinmenu.setOnClickListener(this);
        gameHUD.registerTouchArea(replayinmenu);

        volume.setOnClickListener(this);
        gameHUD.registerTouchArea(volume);

    }

    private void setPoint() {

        txt_point = new Text(0, 0, ResourcesManager.getInstance().font, "0",
                Game.getInstance().vbom);
        txt_point.setScale(0.3f);
        txt_point.setPosition(800 - txt_point.getWidth() / 4, 480 - 20);

        gameHUD.attachChild(txt_point);
    }

    private void updatePoint(String point) {
        gameHUD.detachChild(txt_point);
        txt_point = new Text(0, 0, ResourcesManager.getInstance().font, "0",
                Game.getInstance().vbom);
        txt_point.setScale(0.3f);
        txt_point.setPosition(800 - txt_point.getWidth() / 4, 480 - 20);
        txt_point.setZIndex(-200);
        gameHUD.attachChild(txt_point);
    }

    // ################################################################################
    private void setActionPopup() {

    }

    // ################################################################################
    // Tao man hinh den phu len scene
    public void AlphaScene() {
        rec_black = new Rectangle(Game.getInstance().camera.getCenterX(),
                Game.getInstance().camera.getCenterY(),
                Game.getInstance().camera.getWidth(),
                Game.getInstance().camera.getHeight(), Game.getInstance().vbom);

        rec_black.setColor(Color.BLACK);
        rec_black.setAlpha(0.8f);
        rec_black.setVisible(false);
        gameHUD.attachChild(rec_black);

    }

    // ################################################################################
    // Tao man hinh ket thuc game
    public void EndGameScene(String name, String manchoi) {

        // man hinh den mo

        // nen ket thuc game
        nen_kt1 = new Sprite(0, 0, TexturePackerHelper.Ketthuc_ID_1,
                Game.getInstance().vbom);

        nen_kt2 = new Sprite(0, 0, TexturePackerHelper.Ketthuc_ID_2,
                Game.getInstance().vbom);

        backto_endgame = new ButtonSprite(0, 0,
                TexturePackerHelper.backtoepisode_btn_TiledTexture,
                Game.getInstance().vbom);
        backto_endgame.setTag(MENU_backto_endgame);
        replay_endgame = new ButtonSprite(0, 0,
                TexturePackerHelper.replayinmenu_btn_TiledTexture,
                Game.getInstance().vbom);
        replay_endgame.setTag(MENU_replay_endgame);

        // text name
        txt_name = new Text(0, 0, ResourcesManager.getInstance().font, name,
                Game.getInstance().vbom);
        txt_manchoi = new Text(0, 0, ResourcesManager.getInstance().font,
                manchoi, Game.getInstance().vbom);

        // chieu cao nen ket thuc
        nen_kt1.setHeight(nen_kt2.getHeight() / 2);
        // text man choi

        txt_manchoi.setScale(1f);

        // set potision
        txt_manchoi.setPosition(nen_kt1.getWidth() / 2,
                nen_kt1.getHeight() / 2 + 20);

        nen_kt2.attachChild(txt_name);
        nen_kt1.attachChild(txt_manchoi);

        txt_name.setScale(0.8f);

        txt_name.setPosition(nen_kt2.getWidth() / 2, nen_kt2.getHeight() / 2);

        // set vi tri hinh nen
        nen_kt2.setPosition(400, 240);
        nen_kt1.setPosition(Game.getInstance().camera.getCenterX(),
                nen_kt2.getY() + nen_kt2.getHeight() / 2);

        nen_kt2.attachChild(backto_endgame);
        nen_kt2.attachChild(replay_endgame);

        backto_endgame.setPosition(nen_kt2.getWidth() / 4, 0);
        replay_endgame.setPosition(3 * nen_kt2.getWidth() / 4, 0);

        gameHUD.attachChild(nen_kt1);
        gameHUD.attachChild(nen_kt2);

        backto_endgame.setOnClickListener(this);
        replay_endgame.setOnClickListener(this);

        gameHUD.registerTouchArea(backto_endgame);
        gameHUD.registerTouchArea(replay_endgame);

    }

    public void DeleteEndGameScene() {
        gameHUD.unregisterTouchArea(backto_endgame);
        gameHUD.unregisterTouchArea(replay_endgame);
        gameHUD.detachChild(nen_kt1);
        gameHUD.detachChild(nen_kt2);

    }

    @Override
    public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
            float pTouchAreaLocalY) {
        switch (pButtonSprite.getTag()) {
        case MENU_pause:
            open = new MoveXModifier(0.3f,
                    -Game.getInstance().camera.getWidth() / 3 - 40, 0) {
                @Override
                protected void onModifierStarted(IEntity pItem) {
                    // TODO Auto-generated method stub
                    super.onModifierStarted(pItem);
                    pause.setEnabled(false);
                    replay.setEnabled(false);
                    rec_black.setVisible(true);
                    mMap.Pause();
                }

            };
            open.setAutoUnregisterWhenFinished(true);
            // pause game

            popup.registerEntityModifier(open);

            break;

        case MENU_replay:
            // mMap.Pause();
            // mMap.Reset();
            // mMap.Resume();

            EndGameScene("1", "a");

            break;
        case MENU_resume:
            close = new MoveXModifier(0.3f, 0,
                    -Game.getInstance().camera.getWidth() / 3 - 40) {
                @Override
                protected void onModifierFinished(IEntity pItem) {
                    // TODO Auto-generated method stub
                    super.onModifierFinished(pItem);
                    pause.setEnabled(true);
                    replay.setEnabled(true);
                    mMap.Resume();
                    rec_black.setVisible(false);

                }
            };
            close.setAutoUnregisterWhenFinished(true);
            popup.registerEntityModifier(close);
            break;
        case MENU_backto:
            // tat update handler

            // unload gameHUD
            Game.getInstance().camera.setHUD(null);

            // unload resource
            mMap.UnloadResource();

            // quay ve level scene
            SceneManager.getInstance().setScene(SceneType.SCENE_LEVEL);
            SceneManager.getInstance().getCurrentScene();

            break;
        case MENU_replayinmenu:
            // tat popup
            close = new MoveXModifier(0.3f, 0,
                    -Game.getInstance().camera.getWidth() / 3 - 40) {
                @Override
                protected void onModifierFinished(IEntity pItem) {
                    // TODO Auto-generated method stub
                    super.onModifierFinished(pItem);
                    pause.setEnabled(true);
                    replay.setEnabled(true);
                    mMap.Reset();
                    mMap.Resume();
                    rec_black.setVisible(false);
                }
            };
            close.setAutoUnregisterWhenFinished(true);
            popup.registerEntityModifier(close);
            break;

        case MENU_volume:

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
        case MENU_replay_endgame:
            DeleteEndGameScene();
            mMap.Resume();
            mMap.Reset();
            break;
        case MENU_backto_endgame:
            // tat update handler

            // unload gameHUD
            Game.getInstance().camera.setHUD(null);

            // unload resource
            mMap.UnloadResource();

            // quay ve level scene
            SceneManager.getInstance().setScene(SceneType.SCENE_LEVEL);
            SceneManager.getInstance().getCurrentScene();

            break;

        }

    }

}
