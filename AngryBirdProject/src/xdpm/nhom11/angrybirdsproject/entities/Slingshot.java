package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.math.MathUtils;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorContent;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

import com.badlogic.gdx.math.Vector2;

public class Slingshot extends GameEntity implements IUpdateHandler,
        IOnSceneTouchListener {

    VertexBufferObjectManager mVertexBufferObjectManager;
    static final float MAX_DISTANCE = 150f; // khoảng cách tối đa
    static final float MAX_TOUCH_DISTANCE = 100f; // vùng có thể chạm
    static final float MIN_SHOT_DISTANCE = 50f;
    public Vector2 CenterPosition; // vị trí đặt chim

    AnimatedSprite mSprite;

    Vector2 mPosition;
    float radiusAreaTouch;

    Sprite RightBranch;
    Sprite LeftBranch;
    Sprite Rubber;
    Line String1;
    Line String2;

    // CHiM TRÃŠN NÃ�
    public float distance; // khoang cach tu chim den tam cua na.
    boolean isBirdTouch = false; // biáº¿n xÃ¡c nháº­n Ä‘ang cháº¡m
    boolean istouchScene = false;
    private Vector2 endPoint = new Vector2();

    Bird birdShooted = null;

    public Slingshot(float pX, float pY) {

        this.mPosition = new Vector2(pX, pY);
        this.loadResource();
        this.loadBody(PhysicsEditorContent.physicseditorbirdandpig,
                Map.mPhysicsWorld);
        CreateSlingshot();

    }

    // bắn con chim
    public void ShootBird() {

        if (birdShooted != null) {

            float Vx = (mPosition.x - birdShooted.getPosition().x) / 4.7f;
            float Vy = (mPosition.y - birdShooted.getPosition().y) / 4.7f;
            birdShooted.Shoot(new Vector2(Vx, Vy));
            birdShooted = null;
        }

    }

    // chuẩn bị chim , đưa chim lên ná
    public void ReadyShoot(Bird bird) {
        if (birdShooted == null) {
            this.birdShooted = bird;
            this.birdShooted.setTransform(mPosition, 0);
            Game.getInstance().camera.setCenter(this.mPosition.x,
                    this.mPosition.y);

        }
    }

    @Override
    public void unload() {
        // TODO Auto-generated method stub
        // super.Unload();
        Game.getInstance().engine.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                SceneManager.getInstance().getCurrentScene()
                        .detachChild(RightBranch);

                SceneManager.getInstance().getCurrentScene()
                        .detachChild(LeftBranch);

                SceneManager.getInstance().getCurrentScene()
                        .detachChild(Rubber);

                SceneManager.getInstance().getCurrentScene()
                        .detachChild(String1);

                SceneManager.getInstance().getCurrentScene()
                        .detachChild(String2);

            }
        });

    }

    public void CreateSlingshot() {

        // dây 1
        String2 = new Line(0, 0, 0, 0, 10, Game.getInstance().vbom);
        String2.setColor(0.4f, 0, 0); // Ä‘áº·t mÃ u cho dÃ¢y
        String2.setZIndex(-1); // Ä‘áº·t chiá»�u sÃ¢u cho line2

        // dây 2
        String1 = new Line(0, 0, 0, 0, 10, Game.getInstance().vbom);
        String1.setColor(0.4f, 0, 0); // Ä‘áº·t mÃ u
        String1.setZIndex(4); // Ä‘áº·t Ä‘á»™ sÃ¢u cho dÃ¢y nÃ¡

        // cái đế
        Rubber.setPosition(mPosition.x - 10, mPosition.y - 10);
        Rubber.setZIndex(3); // Ä‘áº·t chiá»�u sÃ¢u cho da nÃ¡

        // nhánh trái
        LeftBranch.setPosition(mPosition.x - 10, mPosition.y - 68);
        LeftBranch.setZIndex(5);

        // nhánh phải
        RightBranch.setPosition(mPosition.x + 19, mPosition.y - 67);
        RightBranch.setZIndex(-1);

    }

    @Override
    public void loadResource() {
        // TODO Auto-generated method stub

        this.LeftBranch = new Sprite(100, 100,
                TexturePackerHelper.SLINGSHOT_TILEDTEXTURE.getTextureRegion(0),
                Game.getInstance().vbom);
        this.RightBranch = new Sprite(0, 0,
                TexturePackerHelper.SLINGSHOT_TILEDTEXTURE.getTextureRegion(1),
                Game.getInstance().vbom);
        this.Rubber = new Sprite(0, 0,
                TexturePackerHelper.SLING_TILEDTEXTURE.getTextureRegion(0),
                Game.getInstance().vbom);

    }

    private int getPartition(Vector2 mousePos) {

        int result = -1;
        if (mousePos.x < mPosition.x) {
            if (mousePos.y < mPosition.y) {
                result = 3;
            } else {
                result = 2;
            }
        } else {
            if (mousePos.y < mPosition.y) {
                result = 4;
            } else {
                result = 1;
            }

        }

        return result;

    }

    @Override
    public Vector2 getPosition() {
        // TODO Auto-generated method stub
        return mPosition;
    }

    private void RotateRubber(Vector2 RubberPos) {
        int Rubberition = getPartition(new Vector2(RubberPos.x, RubberPos.y));
        float tanx = (RubberPos.y - mPosition.y) / (RubberPos.x - mPosition.x);
        float actanRad = (float) Math.atan(tanx);
        float actanxDeg = Math.abs(MathUtils.radToDeg(actanRad));

        switch (Rubberition) {
        case 1:
            Rubber.setRotation(180 - actanxDeg);
            break;

        case 2:
            Rubber.setRotation(actanxDeg);
            break;
        case 3:
            Rubber.setRotation(-actanxDeg);
            break;
        case 4:
            Rubber.setRotation(180 + actanxDeg);
            break;
        }
    }

    boolean isShoot = false;

    public boolean getisShoot() {
        return isShoot;
    }

    public void setisShoot(boolean is) {
        isShoot = is;
    }

    Vector2 touch = null;
    int oldPartition = 0;

    public void UpdateTouch(TouchEvent pSceneTouchEvent) {

    }

    //
    @Override
    public void onAttached(Scene scn) {
        // TODO Auto-generated method stub
        // super.AttachChild(scn);
        scn.attachChild(RightBranch);
        scn.attachChild(String2);
        scn.attachChild(String1);
        scn.attachChild(Rubber);
        scn.attachChild(LeftBranch);
        scn.sortChildren();
    }

    @Override
    public void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld) {
        // TODO Auto-generated method stub

    }

    @Override
    public ObjectType getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void collide(float force) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkState() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpdate(float pSecondsElapsed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        // TODO Auto-generated method stub

        if (birdShooted != null) {

            // khoảng cách điểm chạm với cái ná
            float touchDistance = (new Vector2(Rubber.getX(), Rubber.getY()))
                    .dst(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());

            distance = mPosition.dst(pSceneTouchEvent.getX(),
                    pSceneTouchEvent.getY());

            // xét khoảng cách điểm chạm với cái ná
            if (touchDistance <= MAX_TOUCH_DISTANCE) {
                isBirdTouch = true;

                // nếu đang chạm chim ko cho phép scroll và zoom
                // camera.mScrollDetector.setEnabled(false);
                // camera.mPinchZoomDetector.setEnabled(false);
            }
            if (isBirdTouch) {

                if (distance <= MAX_DISTANCE) {
                    endPoint.x = pSceneTouchEvent.getX();
                    endPoint.y = pSceneTouchEvent.getY();
                } else {
                    float rate = (distance - MAX_DISTANCE) / distance;

                    endPoint.x = (mPosition.x - pSceneTouchEvent.getX()) * rate
                            + pSceneTouchEvent.getX();
                    endPoint.y = (mPosition.y - pSceneTouchEvent.getY()) * rate
                            + pSceneTouchEvent.getY();
                }

                int eventaction = pSceneTouchEvent.getAction();

                // boolean flag = true;
                switch (eventaction) {
                // khi cháº¡m xuá»‘ng
                case TouchEvent.ACTION_DOWN:

                    String1.setPosition(mPosition.x - 22, mPosition.y,
                            endPoint.x, endPoint.y);
                    String2.setPosition(mPosition.x + 22, mPosition.y,
                            endPoint.x, endPoint.y);

                    // float birdPosY = (mPosition.y - endPoint.y) * 0.2f +
                    // endPoint.y;
                    touch = new Vector2((mPosition.x - endPoint.x) * 0.2f
                            + endPoint.x, (mPosition.y - endPoint.y) * 0.2f
                            + endPoint.y);
                    birdShooted.setTransform(touch, 0);

                    // !!!!!!!!!!

                    // startPositionS(bird, 0, birdPosX, birdPosY);
                    RotateRubber(endPoint);

                    break;
                // khi khÃ´ng cháº¡m ná»¯a
                case TouchEvent.ACTION_UP:

                    if (touch.dst(mPosition) <= MIN_SHOT_DISTANCE) {
                        touch = mPosition;
                        birdShooted.setTransform(mPosition, 0);
                        isShoot = false;
                    } else {
                        this.ShootBird();
                        isShoot = true;
                    }
                    String1.setPosition(mPosition.x, mPosition.y,
                            mPosition.x - 22, mPosition.y);
                    String2.setPosition(mPosition.x, mPosition.y,
                            mPosition.x + 22, mPosition.y);
                    Rubber.setPosition(mPosition.x - 10, mPosition.y);

                    isBirdTouch = false;

                    // xÃ©t khi báº±n

                    break;
                // di chuyá»ƒn chá»— cháº¡m
                case TouchEvent.ACTION_MOVE:

                    if (Math.abs(endPoint.x - mPosition.x) <= 20
                            && (mPosition.y - endPoint.y) >= (MAX_DISTANCE - 20)) {
                        endPoint = new Vector2(mPosition.x, mPosition.y
                                - MAX_DISTANCE + 90);
                    }

                    Rubber.setPosition(endPoint.x, endPoint.y);

                    String1.setPosition(mPosition.x - 22, mPosition.y,
                            endPoint.x, endPoint.y);
                    String2.setPosition(mPosition.x + 22, mPosition.y,
                            endPoint.x, endPoint.y);

                    ;

                    touch = new Vector2((mPosition.x - endPoint.x) * 0.18f
                            + endPoint.x, (mPosition.y - endPoint.y) * 0.18f
                            + endPoint.y);
                    birdShooted.setTransform(touch, 0);

                    RotateRubber(endPoint);

                }

            }
        }
        return false;
    }

}
