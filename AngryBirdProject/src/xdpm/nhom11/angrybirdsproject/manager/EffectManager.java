package xdpm.nhom11.angrybirdsproject.manager;

import java.util.Random;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.AnimatedSprite.IAnimationListener;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.util.modifier.IModifier;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

/**
 * Lớp quản lý hiệu ứng
 * 
 * @author Hoa Phat
 * 
 */
public class EffectManager implements IAnimationListener,
        IEntityModifierListener {

    private static final EffectManager INSTANCE = new EffectManager();

    public static EffectManager getInstance() {
        return INSTANCE;
    }

    /**
     * hiển thị hiệu ứng khi heo chết
     * 
     * @param x
     *            vị trí x của heo
     * @param y
     *            vị trí y của heo
     */
    public void showPigDead(float x, float y) {
        AnimatedSprite sp = new AnimatedSprite(x, y,
                TexturePackerHelper.explode_whitesmoke_TiledTexture,
                Game.getInstance().vbom);
        SceneManager.getInstance().getCurrentScene().attachChild(sp);
        sp.animate(80, false, this);
    }

    /**
     * hiển thị hiệu ứng nổ
     * 
     * @param x
     *            vị trí x xảy ra hiệu ứng
     * @param y
     *            vị trí y xảy ra hiệu ứng
     */
    public void showExplode(float x, float y) {
        AnimatedSprite sp = new AnimatedSprite(x, y,
                TexturePackerHelper.explode_blacksmoke_TiledTexture,
                Game.getInstance().vbom);
        SceneManager.getInstance().getCurrentScene().attachChild(sp);
        sp.animate(80, false, this);

    }

    /**
     * @param x
     *            vị trí x hiệu ứng
     * @param y
     *            vị trí y hiệu ứng
     * @param type
     *            loại chim (red,blue,black,white)
     */
    public void showBirdFeather(float x, float y, String type) {

        final AnimatedSprite smoke[] = new AnimatedSprite[5];
        final AnimatedSprite feather[] = new AnimatedSprite[5];
        for (int i = 0; i < 4; i++) {
            int te1 = new Random().nextInt(25) - 15;
            int te2 = new Random().nextInt(25) - 15;
            int te = new Random().nextInt(360);

            smoke[i] = new AnimatedSprite(x + te1, y + te2,
                    TexturePackerHelper.explode_whitesmoke_TiledTexture,
                    Game.getInstance().vbom);
            smoke[i].setCurrentTileIndex(1);
            SceneManager.getInstance().getCurrentScene().attachChild(smoke[i]);

            if (type.equals("red")) {
                feather[i] = new AnimatedSprite(x - te1, y - te2,
                        TexturePackerHelper.red_feather_TiledTexture,
                        Game.getInstance().vbom);
            } else if (type.equals("blue")) {
                feather[i] = new AnimatedSprite(x - te1, y - te2,
                        TexturePackerHelper.blue_feather_TiledTexture,
                        Game.getInstance().vbom);
            } else if (type.equals("black")) {
                feather[i] = new AnimatedSprite(x - te1, y - te2,
                        TexturePackerHelper.black_feather_TiledTexture,
                        Game.getInstance().vbom);
            } else {
                feather[i] = new AnimatedSprite(x - te1, y - te2,
                        TexturePackerHelper.yellow_feather_TiledTexture,
                        Game.getInstance().vbom);
            }
            feather[i].setCurrentTileIndex(1);
            feather[i].setRotation(te);
            SceneManager.getInstance().getCurrentScene()
                    .attachChild(feather[i]);
        }

        // RotationModifier rotation = new RotationModifier(5, 1f, 100f,this);
        // ScaleModifier scale_bird = new ScaleModifier(5, 1.4f, 0f,this);
        // ScaleModifier scale_smoke = new ScaleModifier(5, 0.7f, 0f,this);
        //
        // for (int i = 0; i < 5; i++) {
        // feather[i].registerEntityModifier(rotation);
        // feather[i].registerEntityModifier(scale_bird);
        //
        // smoke[i].registerEntityModifier(rotation);
        // smoke[i].registerEntityModifier(scale_smoke);
        // }

        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub
                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;
                        float s = 0.02f;

                        if (0.7f - t * s > 0) {
                            for (int i = 0; i < 4; i++) {
                                feather[i].setScale(1.4f - t * s * 1.5f);
                                feather[i].setRotation(feather[i].getRotation()
                                        + t * 0.01f);

                                smoke[i].setScale(0.7f - t * s);
                                smoke[i].setRotation(t);
                            }
                        } else {
                            for (int i = 0; i < 4; i++) {
                                SceneManager.getInstance().getCurrentScene()
                                        .detachChild(feather[i]);
                                SceneManager.getInstance().getCurrentScene()
                                        .detachChild(smoke[i]);
                                feather[i].dispose();
                                smoke[i].dispose();
                            }
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                        }
                    }
                });
    }

    /**
     * @param x
     *            vị trí x hiệu ứng
     * @param y
     *            vị trí y hiệu ứng
     * @param type
     *            loại hiệu ứng (wood,ice,rock)
     */
    public void showBlockFragment(float x, float y, final String type) {

        final AnimatedSprite feather[] = new AnimatedSprite[10];
        for (int i = 0; i < 8; i++) {
            int te1 = new Random().nextInt(40) - 20;
            int te2 = new Random().nextInt(30) - 15;
            int te = new Random().nextInt(360);

            if (type.equals("ice")) {
                feather[i] = new AnimatedSprite(x - te1, y - te2 + 10,
                        TexturePackerHelper.ice_feather_TiledTexture,
                        Game.getInstance().vbom);
            } else if (type.equals("wood")) {
                feather[i] = new AnimatedSprite(x - te1, y - te2 + 10,
                        TexturePackerHelper.wood_feather_TiledTexture,
                        Game.getInstance().vbom);
            } else {
                feather[i] = new AnimatedSprite(x - te1, y - te2 + 10,
                        TexturePackerHelper.rock_feather_TiledTexture,
                        Game.getInstance().vbom);
            }

            feather[i].setCurrentTileIndex(i % 3);
            feather[i].setRotation(te);
            SceneManager.getInstance().getCurrentScene()
                    .attachChild(feather[i]);
        }

        // ScaleModifier scale_bird = new ScaleModifier(2, 1.4f, 0f,this);
        // ScaleModifier scale_smoke = new ScaleModifier(2, 1f, 0f,this);
        // for (int i = 0; i < 10; i++) {
        // if (S.equals("wood")) {
        // feather[i].registerEntityModifier(scale_bird);
        // } else
        // feather[i].registerEntityModifier(scale_smoke);
        // }

        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub
                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;

                        if (1f - t * 0.02f > 0) {
                            for (int i = 0; i < 8; i++) {
                                if (type.equals("wood")) {
                                    feather[i].setScale(1.4f - t * 0.02f);
                                } else
                                    feather[i].setScale(1f - t * 0.02f);
                                feather[i].setPosition(feather[i].getX(),
                                        feather[i].getY() - t * 0.05f);
                            }
                            feather[0].setPosition(feather[0].getX() - t
                                    * 0.05f, feather[0].getY());
                            feather[1].setPosition(feather[1].getX() + t
                                    * 0.03f, feather[1].getY());
                            feather[2].setPosition(feather[2].getX() + t
                                    * 0.03f, feather[2].getY());
                            feather[3].setPosition(feather[3].getX() + t
                                    * 0.01f, feather[3].getY() + 0.06f);
                            feather[4].setPosition(feather[4].getX() - t
                                    * 0.02f, feather[4].getY());
                            feather[5].setPosition(feather[3].getX() + t
                                    * 0.01f, feather[5].getY() + 0.06f);
                            feather[6].setPosition(feather[4].getX() - t
                                    * 0.02f, feather[6].getY());
                        } else {
                            for (int i = 0; i < 8; i++) {
                                SceneManager.getInstance().getCurrentScene()
                                        .detachChild(feather[i]);
                                feather[i].dispose();
                            }
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                        }
                    }
                });
    }

    /**
     * @param x
     *            vị trí x hiệu ứng
     * @param y
     *            vị trí y hiệu ứng
     * @param type
     *            loại hiệu ứng (red, black, white, yellow, blue, green, orange,
     *            pink)
     */
    public static void showScore10k(float x, float y, String type) {
        final Sprite sp;
        if (type.equals("red"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_red_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("black"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_black_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("white"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_white_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("yellow"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_yellow_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("blue"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_blue_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("green"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_green_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("orange"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_orange_TiledTexture,
                    Game.getInstance().vbom);
        else
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_10k_pink_TiledTexture,
                    Game.getInstance().vbom);

        SceneManager.getInstance().getCurrentScene().attachChild(sp);
        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub

                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;
                        if (0.8 - t * 0.02 > 0) {
                            sp.setScale(0.8f - t * 0.02f);
                        } else {
                            SceneManager.getInstance().getCurrentScene()
                                    .detachChild(sp);
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                            sp.dispose();
                        }
                    }
                });
    }

    /**
     * @param x
     *            vị trí x hiệu ứng
     * @param y
     *            vị trí y hiệu ứng
     * @param type
     *            loại hiệu ứng (red, pink, purple, yellow)
     */
    public static void showScore3k(float x, float y, String type) {
        final Sprite sp;
        if (type.equals("red"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_3k_red_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("pink"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_3k_pink_TiledTexture,
                    Game.getInstance().vbom);
        else if (type.equals("purple"))
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_3k_purple_TiledTexture,
                    Game.getInstance().vbom);
        else
            sp = new Sprite(x, y,
                    TexturePackerHelper.score_3k_yellow_TiledTexture,
                    Game.getInstance().vbom);

        SceneManager.getInstance().getCurrentScene().attachChild(sp);
        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub

                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;
                        if (0.8 - t * 0.02 > 0) {
                            sp.setScale(0.8f - t * 0.02f);
                        } else {
                            SceneManager.getInstance().getCurrentScene()
                                    .detachChild(sp);
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                            sp.dispose();
                        }
                    }
                });
    }

    /**
     * @param x
     *            vị trí x hiệu ứng
     * @param y
     *            vị trí y hiệu ứng
     */
    public static void showScore5k(float x, float y) {
        final Sprite sp;
        sp = new Sprite(x, y, TexturePackerHelper.score_5k_green_TiledTexture,
                Game.getInstance().vbom);

        SceneManager.getInstance().getCurrentScene().attachChild(sp);
        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub

                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;
                        if (0.8 - t * 0.02 > 0) {
                            sp.setScale(0.8f - t * 0.02f);
                        } else {
                            SceneManager.getInstance().getCurrentScene()
                                    .detachChild(sp);
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                            sp.dispose();
                        }
                    }
                });
    }

    public static void Show_string(float x, float y, String S) {
        final Text text;
        text = new Text(x, y, ResourcesManager.getInstance().font, S,
                Game.getInstance().vbom);
        SceneManager.getInstance().getCurrentScene().attachChild(text);
        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(new IUpdateHandler() {

                    @Override
                    public void reset() {
                        // TODO Auto-generated method stub

                    }

                    float t = 0;

                    @Override
                    public void onUpdate(float pSecondsElapsed) {
                        // TODO Auto-generated method stub
                        t++;
                        if (0.3 - t * 0.01 > 0) {
                            text.setScale(0.3f - t * 0.01f);
                        } else {
                            SceneManager.getInstance().getCurrentScene()
                                    .detachChild(text);
                            SceneManager.getInstance().getCurrentScene()
                                    .unregisterUpdateHandler(this);
                            text.dispose();

                        }
                    }
                });
    }

    @Override
    public void onAnimationStarted(AnimatedSprite pAnimatedSprite,
            int pInitialLoopCount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationFrameChanged(AnimatedSprite pAnimatedSprite,
            int pOldFrameIndex, int pNewFrameIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationLoopFinished(AnimatedSprite pAnimatedSprite,
            int pRemainingLoopCount, int pInitialLoopCount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationFinished(final AnimatedSprite pAnimatedSprite) {
        // TODO Auto-generated method stub

        Game.getInstance().engine.runOnUpdateThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                pAnimatedSprite.setVisible(false);
                SceneManager.getInstance().getCurrentScene()
                        .detachChild(pAnimatedSprite);
                pAnimatedSprite.dispose();

            }
        });
    }

    @Override
    public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onModifierFinished(final IModifier<IEntity> pModifier,
            final IEntity pItem) {
        // TODO Auto-generated method stub
        Game.getInstance().engine.runOnUpdateThread(new Runnable() {

            @Override
            public void run() {
                pItem.clearEntityModifiers();
                SceneManager.getInstance().getCurrentScene().detachChild(pItem);
                pItem.dispose();
            }
        });
    }
}
