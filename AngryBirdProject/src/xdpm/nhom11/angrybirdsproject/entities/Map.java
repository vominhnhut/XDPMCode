package xdpm.nhom11.angrybirdsproject.entities;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;

import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.JumpModifier;
import org.andengine.entity.modifier.RotationModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.PinchZoomDetector;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.PinchZoomDetector.IPinchZoomDetectorListener;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.input.touch.detector.SurfaceScrollDetector;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.color.Color;
import org.xml.sax.SAXException;

import android.content.Context;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;

import xdpm.nhom11.angrybirdsproject.bird.BlackBird;
import xdpm.nhom11.angrybirdsproject.bird.BlueBird;
import xdpm.nhom11.angrybirdsproject.bird.RedBird;
import xdpm.nhom11.angrybirdsproject.bird.WhiteBird;
import xdpm.nhom11.angrybirdsproject.bird.YellowBird;
import xdpm.nhom11.angrybirdsproject.entities.GameEntity.ObjectType;
import xdpm.nhom11.angrybirdsproject.manager.DataManager;
import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DAOWorld;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOWorld;

public class Map implements IOnSceneTouchListener, IUpdateHandler,
        IScrollDetectorListener, IPinchZoomDetectorListener {

    // PhysicsWorld của một map
    public static PhysicsWorld mPhysicsWorld;

    // biến tạm tạo fixturedef cho toàn bộ object;
    static boolean isPause = false;
    static boolean isResume = false;
    FixtureDef fx;

    float maxWidth = 3000;
    float maxHeight = 4000;
    // danh sách chim
    ArrayList<Bird> ListBird;

    // danh sách vật cản
    ArrayList<Block> ListObject;

    ArrayList<Pig> ListPig;

    // cây ná
    Slingshot mSlingshot;

    MapBackground background;

    Earth mEarth;
    // mặt đất tạm
    Rectangle staticRect;
    SmoothCamera camera;
    boolean startDelay = false;
    // camera
    float mPinchZoomStartedCameraZoomFactor = 0;
    static PinchZoomDetector mPinchZoomDetector;
    static SurfaceScrollDetector mScrollDetector;

    static int BirdIndex = -1;

    ArrayList<Sprite> earth;
    ArrayList<Sprite> sky;
    ArrayList<Sprite> earthsurface1;
    ArrayList<Sprite> earthsurface2;

    public Map(Context context, VertexBufferObjectManager vbo) {

        Map.mPhysicsWorld = new PhysicsWorld(new Vector2(0, -10), false);
        fx = PhysicsFactory.createFixtureDef(50, 0.2f, 0.3f);
        Map.mPhysicsWorld.setContactListener(createContactListener());

        ListBird = new ArrayList<Bird>();

        ListObject = new ArrayList<Block>();

        ListPig = new ArrayList<Pig>();

    }

    public void Load() {

        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(this);
        SceneManager.getInstance().getCurrentScene()
                .setOnSceneTouchListener(this);
        SceneManager.getInstance().getCurrentScene()
                .registerUpdateHandler(Map.mPhysicsWorld);

        CreateMapScene();
        CreateMapFromData();
        CreateBackground();
        CreateEarthSurface();

        startDelay = true;
    }

    public void CreateMapFromData() {
        ArrayList<DTOWorld> world = DataManager.getInstance().DTOListWorld;
        ListObject = world.get(DataManager.getInstance().currentWorldChoosed).chapters
                .get(DataManager.getInstance().currentChapterChoosed).levels
                .get(DataManager.getInstance().currentLevelChoosed)
                .getListBlock();
        ListBird = world.get(DataManager.getInstance().currentWorldChoosed).chapters
                .get(DataManager.getInstance().currentChapterChoosed).levels
                .get(DataManager.getInstance().currentLevelChoosed)
                .getListBird();
        ListPig = world.get(DataManager.getInstance().currentWorldChoosed).chapters
                .get(DataManager.getInstance().currentChapterChoosed).levels
                .get(DataManager.getInstance().currentLevelChoosed)
                .getListPig();
        mSlingshot = world.get(DataManager.getInstance().currentWorldChoosed).chapters
                .get(DataManager.getInstance().currentChapterChoosed).levels
                .get(DataManager.getInstance().currentLevelChoosed)
                .getSlingshot();

        background = new MapBackground(
                world.get(DataManager.getInstance().currentWorldChoosed).backgroundID);
    }

    private void CreateMapScene() {
        //

        Game.getInstance().camera.setBounds(0, -100, maxWidth, maxHeight - 100);
        Game.getInstance().camera.setBoundsEnabled(true);
        Game.getInstance().camera.setCenterDirect(0, 0);
        Game.getInstance().camera.setChaseEntity(null);
        Game.getInstance().camera.setMaxVelocity(1000, 1000);

        mPinchZoomDetector = new PinchZoomDetector(this);
        mScrollDetector = new SurfaceScrollDetector(this);
    }

    private void CreateBackground() {
        SceneManager.getInstance().getCurrentScene()
                .setBackground(new Background(background.getColor()));

        // EARTH
        earth = new ArrayList<Sprite>();

        int n = (int) (maxWidth / background.getEarthBackground().getWidth() + 1);
        float widthTexture = background.getEarthBackground().getWidth();
        float heightTexture = background.getEarthBackground().getHeight();
        for (int i = 0; i < n; i++) {

            final Sprite sp1 = new Sprite(widthTexture / 2 + i * widthTexture,
                    -(heightTexture / 2), background.getEarthBackground(),
                    Game.getInstance().vbom);
            sp1.setZIndex(-2);
            earth.add(sp1);

        }

        // EARTHSURFACE1
        n = (int) (maxWidth
                / background.getEarthSurface1Background().getWidth() + 1);
        widthTexture = background.getEarthSurface1Background().getWidth();
        heightTexture = background.getEarthSurface1Background().getHeight();
        earthsurface1 = new ArrayList<Sprite>();

        for (int i = 0; i < n; i++) {

            final Sprite sp1 = new Sprite(0, 0,
                    background.getEarthSurface1Background(),
                    Game.getInstance().vbom);

            sp1.setAnchorCenter(0, 0);
            sp1.setScale(1);
            sp1.setPosition(i * widthTexture * sp1.getScaleX(), -7);

            sp1.setZIndex(2);
            earthsurface1.add(sp1);

        }

        // EARTHSURFACE2
        n = (int) (maxWidth
                / background.getEarthSurface2Background().getWidth() + 1);
        widthTexture = background.getEarthSurface2Background().getWidth();
        heightTexture = background.getEarthSurface2Background().getHeight();
        earthsurface2 = new ArrayList<Sprite>();

        for (int i = 0; i < n; i++) {

            final Sprite sp1 = new Sprite(0, 0,
                    background.getEarthSurface2Background(),
                    Game.getInstance().vbom);

            sp1.setAnchorCenter(0, 0);
            sp1.setScale(2.5f);
            sp1.setPosition(i * widthTexture * sp1.getScaleX(), -10);

            sp1.setZIndex(-3);
            earthsurface2.add(sp1);

        }

        // SKY
        n = (int) (maxWidth / background.getSkyBackground().getWidth() + 1);
        widthTexture = background.getSkyBackground().getWidth();
        heightTexture = background.getSkyBackground().getHeight();
        sky = new ArrayList<Sprite>();

        for (int i = 0; i < n; i++) {

            final Sprite sp1 = new Sprite(0, 0, background.getSkyBackground(),
                    Game.getInstance().vbom);

            sp1.setScale(2);
            sp1.setPosition(
                    (sp1.getWidth() * sp1.getScaleX()) / 2 + i * sp1.getWidth()
                            * sp1.getScaleX(),
                    sp1.getHeight() / 2 * sp1.getScaleY() - 23);

            sp1.setZIndex(-5);
            sky.add(sp1);

        }

    }

    public void CreateEarthSurface() {
        mEarth = new Earth(0);

    }

    public void Attached(Scene scene) {
        // attach cho chim

        for (Bird bird : ListBird) {
            bird.onAttached(scene);

        }
        for (Block bird : ListObject) {
            bird.onAttached(scene);
        }
        for (Pig pig : ListPig) {
            pig.onAttached(scene);
        }
        if (mSlingshot != null)
            mSlingshot.onAttached(scene);

        for (Sprite spr : earth) {
            scene.attachChild(spr);
        }
        for (Sprite spr : sky) {
            scene.attachChild(spr);
        }
        for (Sprite spr : earthsurface1) {
            scene.attachChild(spr);
        }
        for (Sprite spr : earthsurface2) {
            scene.attachChild(spr);
        }
        scene.sortChildren();

    }

    private void ChangeBird() {

        if (BirdIndex < ListBird.size() - 1) {
            BirdIndex++;
            if (mSlingshot != null) {
                RotationModifier rota = new RotationModifier(2, 0, 1800);
                rota.setAutoUnregisterWhenFinished(true);
                JumpModifier jump = new JumpModifier(2, ListBird.get(BirdIndex)
                        .getSprite().getX(), mSlingshot.getPosition().x,
                        ListBird.get(BirdIndex).getSprite().getY(),
                        mSlingshot.getPosition().y,
                        -(mSlingshot.getPosition().y + 20)) {
                    @Override
                    protected void onModifierFinished(IEntity pItem) {
                        // TODO Auto-generated method stub
                        mSlingshot.ReadyShoot(ListBird.get(BirdIndex));
                    }

                };

                jump.setAutoUnregisterWhenFinished(true);
                ListBird.get(BirdIndex).getSprite()
                        .registerEntityModifier(rota);
                ListBird.get(BirdIndex).getSprite()
                        .registerEntityModifier(jump);

            }

        }

    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        // TODO Auto-generated method stub

        if (!isPause) {
            if (isStarted) {

                // Runaway.Remove_line();

                // UnloadResource();
                // gán indexmove con chim đang ở trên ná và đưa camera v�? lại
                // vị
                // trí
                // ban
                // đầu

                // camera2D.mSmoothCamera.set(0,0,800,480);

                // đảm bảo lúc này con chim ko bay
                // isMove = false;
                //
                // //nếu con chim ko bay cho phép scroll và zoom
                // if(!isMove)
                // {
                // camera2D.mPinchZoomDetector.onSceneTouchEvent(pScene,
                // pSceneTouchEvent);
                // if (camera2D.mPinchZoomDetector.isZooming())
                // {
                // camera2D.mScrollDetector.setEnabled(false);
                // } else
                // {
                // camera2D.mScrollDetector.onSceneTouchEvent(pScene,
                // pSceneTouchEvent);
                // }
                // }

                if (ListBird != null)
                    if (ListBird.size() > 0)

                        ListBird.get(BirdIndex).UseSkill();

                Map.mPinchZoomDetector.onSceneTouchEvent(pScene,
                        pSceneTouchEvent);

                if (Map.mPinchZoomDetector.isZooming()) {
                    Map.mScrollDetector.setEnabled(false);
                } else {
                    if (pSceneTouchEvent.isActionDown())
                        Map.mScrollDetector.setEnabled(true);
                    Map.mScrollDetector.onTouchEvent(pSceneTouchEvent);
                }
                //
                if (mSlingshot != null) {
                    mSlingshot.onSceneTouchEvent(pScene, pSceneTouchEvent);
                    if (mSlingshot.isBirdTouch == true) {
                        Map.mScrollDetector.setEnabled(false);
                    }
                }
                if (mSlingshot != null)
                    mSlingshot.onSceneTouchEvent(pScene, pSceneTouchEvent);

                // this.mScrollDetector
                // .onSceneTouchEvent(pScene, pSceneTouchEvent);
            }
        }

        return false;
    }

    public boolean isStarted = false;

    public void Start() {

        isStarted = true;
        for (Block ob : ListObject) {
            ob.mBody.setActive(true);

        }
        for (Pig opig : ListPig) {
            opig.mBody.setActive(true);

        }

        if (mSlingshot != null)
            ChangeBird();

        SoundHelper.level_start_military.play();

    }

    int count = 0;

    @Override
    public void onUpdate(float pSecondsElapsed) {
        // TODO Auto-generated method stub
        //

        if (startDelay == true) {

            count++;
            if (count > 100) {
                Start();
                count = 0;
                startDelay = false;

            }

        }

        if (BirdIndex >= 0)
            if (ListBird.get(BirdIndex).isDead == true) {
                ChangeBird();
            }
        //
        // }

        // t++;
        // if (t % 3 == 0)
        // Runaway.Add_line(ListBird.get(BirdIndex).getSprite().getX(),
        // ListBird.get(BirdIndex).getSprite().getY());
        // if (ListBird.get(BirdIndex).getSprite().getY() > camera
        // .getBoundsHeight() && zoomed == false) {
        // camera.setZoomFactor(0.68f);
        // zoomed = true;
        //
        // } else if (ListBird.get(BirdIndex).getSprite().getY() <= camera
        // .getBoundsHeight() && zoomed == true) {
        // camera.setZoomFactor(1f);
        // zoomed = false;
        // }
        // for (int i = 0; i < ListObject.size(); i++) {
        // ListObject.get(i).onUpdate(pSecondsElapsed);
        //
        // }
        // for (int i = 0; i < ListPig.size(); i++) {
        // ListPig.get(i).onUpdate(pSecondsElapsed);
        //
        // }
        // for (int i = 0; i < ListBird.size(); i++) {
        // ListBird.get(i).onUpdate(pSecondsElapsed);
        //
        // }
        // if(isMove)
        // {
        // //đặt con chim tiếp theo vào vị trí bắn
        // if( mSlingshot.birdShooted == null &&
        // ListBird.get(indexmove).getSprite().getY() +
        // ListBird.get(indexmove).getSprite().getHeight()*2 >
        // mSlingshot.mPosition.y)
        // {
        // mSlingshot.ReadyShoot(ListBird.get(index));
        // }
        //

    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

    public void UnloadResource() {

        SoundHelper.StopAll();
        SceneManager.getInstance().getCurrentScene()
                .unregisterUpdateHandler(this);
        SceneManager.getInstance().getCurrentScene()
                .setOnSceneTouchListener(null);

        SceneManager.getInstance().getCurrentScene()
                .unregisterUpdateHandler(Map.mPhysicsWorld);
        for (Bird bird : ListBird)
            bird.unload();
        for (Block object : ListObject)
            object.unload();
        for (Pig pig : ListPig)
            pig.unload();
        if (mSlingshot != null)
            mSlingshot.unload();
        if (mEarth != null)
            mEarth.unload();

        for (Sprite spr : earth) {
            SceneManager.getInstance().getCurrentScene().detachChild(spr);

        }
        for (Sprite spr : sky) {
            SceneManager.getInstance().getCurrentScene().detachChild(spr);

        }

        ListBird.clear();
        ListObject.clear();
        ListPig.clear();

        startDelay = true;

        isStarted = false;
        count = 0;
        isPause = false;
        BirdIndex = -1;

        Game.getInstance().camera.setZoomFactorDirect(1);
        Game.getInstance().camera.setCenterDirect(0, 0);
        Game.getInstance().camera.setBounds(0, 0,
                Game.getInstance().camera.getWidth(),
                Game.getInstance().camera.getHeight());
        Game.getInstance().camera.setBoundsEnabled(false);

        //

    }

    float maxImpulse;
    Vector2 birdForce;
    float aguForce;

    private ContactListener createContactListener() {

        ContactListener contactListener = new ContactListener() {

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
                // TODO Auto-generated method stub
                final Body x1 = contact.getFixtureA().getBody();
                final Body x2 = contact.getFixtureB().getBody();
                if (x1.getUserData() != null && x2.getUserData() != null) {

                    if (((GameEntity) x1.getUserData()).getType() == ObjectType.BIRD
                            && ((GameEntity) x2.getUserData()).getType() != ObjectType.BIRD) {
                        birdForce = x1.getLinearVelocity();
                        aguForce = x1.getAngularVelocity();
                    }

                    if (((GameEntity) x2.getUserData()).getType() == ObjectType.BIRD
                            && ((GameEntity) x1.getUserData()).getType() != ObjectType.BIRD) {
                        birdForce = x2.getLinearVelocity();
                        aguForce = x2.getAngularVelocity();
                    }

                }
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

                maxImpulse = impulse.getNormalImpulses()[0];
                // for (int i = 1; i < impulse.getNormalImpulses().length; i++)
                // maxImpulse = Math.max(impulse.getNormalImpulses()[i],
                // maxImpulse);
                final Body x1 = contact.getFixtureA().getBody();
                final Body x2 = contact.getFixtureB().getBody();

                if (x1.getUserData() != null && x2.getUserData() != null) {
                    if (maxImpulse >= ((GameEntity) x1.getUserData())
                            .getCurrentLifeValue()) {
                        if (((GameEntity) x1.getUserData()).getType() != ObjectType.BIRD
                                && ((GameEntity) x2.getUserData()).getType() == ObjectType.BIRD) {
                            ((GameEntity) x1.getUserData()).destroy();
                            x2.setLinearVelocity(birdForce.mul(0.6f));
                            x2.setAngularVelocity(aguForce / 6);
                        }

                    } else if (maxImpulse >= ((GameEntity) x2.getUserData())
                            .getCurrentLifeValue()) {
                        if (((GameEntity) x2.getUserData()).getType() != ObjectType.BIRD
                                && ((GameEntity) x1.getUserData()).getType() == ObjectType.BIRD) {
                            ((GameEntity) x1.getUserData()).destroy();
                            x1.setLinearVelocity(birdForce.mul(0.6f));
                            x1.setAngularVelocity(aguForce / 6);
                        }
                    }

                }
                if (x1.getUserData() != null) {

                    ((GameEntity) x1.getUserData()).collide(maxImpulse);
                }
                if (x2.getUserData() != null) {
                    ((GameEntity) x2.getUserData()).collide(maxImpulse);
                }

            }

            @Override
            public void endContact(Contact contact) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beginContact(Contact contact) {
                // TODO Auto-generated method stub

            }
        };
        return contactListener;
    }

    // xác định 1 body va chạm đầu tiên

    public void Reset() {
        SoundHelper.StopAll();
        startDelay = true;

        isStarted = false;
        count = 0;
        isPause = false;
        BirdIndex = -1;
        for (Bird bird : ListBird) {

            bird.resetSeft();
            bird.onAttached(SceneManager.getInstance().getCurrentScene());

        }
        for (Pig pig : ListPig) {

            pig.resetSeft();
            pig.onAttached(SceneManager.getInstance().getCurrentScene());
        }
        for (Block object : ListObject) {

            object.resetSeft();
            object.onAttached(SceneManager.getInstance().getCurrentScene());
        }
        mSlingshot.birdShooted = null;

        SceneManager.getInstance().getCurrentScene().sortChildren();

        // UnloadResource();
        // Load();
        // Attached(SceneManager.getInstance().getCurrentScene());

    }

    public void Pause() {
        if (!isPause) {
            for (int i = 0; i < ListBird.size(); i++) {
                ListBird.get(i).mBody.setActive(false);
            }
            for (int i = 0; i < ListObject.size(); i++)
                ListObject.get(i).mBody.setActive(false);

            for (int i = 0; i < ListPig.size(); i++)
                ListPig.get(i).mBody.setActive(false);
            isPause = true;
        }
    }

    public void Resume() {
        if (isPause) {
            for (int i = BirdIndex; i >= 0; i--)
                if (ListBird.get(i).isFlying == true)
                    ListBird.get(i).mBody.setActive(true);

            for (int i = 0; i < ListObject.size(); i++)
                ListObject.get(i).mBody.setActive(true);

            for (int i = 0; i < ListPig.size(); i++)
                ListPig.get(i).mBody.setActive(true);
            isPause = false;
        }
    }

    public int Check_win() {
        int isDead = 1;
        for (int i = 0; i < ListPig.size(); i++) {
            if (ListPig.get(i).isDead == false) {
                isDead = -1;
                break;
            }
        }
        if (isDead == -1) {
            for (int i = 0; i < ListBird.size(); i++) {
                if (ListBird.get(i).isDead == false) {

                    return 0;
                }
            }
            return isDead;
        }
        return isDead;
    }

    // SCROLL
    float tscoll = 0;

    @Override
    public void onScroll(ScrollDetector pScollDetector, int pPointerID,
            float pDistanceX, float pDistanceY) {
        // TODO Auto-generated method stub

        final float zoomFactor = Game.getInstance().camera.getZoomFactor();
        Game.getInstance().camera.setCenterDirect(
                (int) (-pDistanceX / zoomFactor)
                        + Game.getInstance().camera.getCenterX(),
                Game.getInstance().camera.getCenterY());
        tscoll = (int) (-pDistanceX / zoomFactor);
    }

    @Override
    public void onScrollFinished(ScrollDetector pScollDetector, int pPointerID,
            float pDistanceX, float pDistanceY) {
        // TODO Auto-generated method stub
        final float zoomFactor = Game.getInstance().camera.getZoomFactor();
        Game.getInstance().camera.setChaseEntity(null);

        if (!isPause) {
            if ((int) (-pDistanceX / zoomFactor) > tscoll) {
                Game.getInstance().camera.setCenter(mSlingshot.getPosition().x,
                        mSlingshot.getPosition().y);
            } else {
                // Vector2 temp = getPigPosition();
                Game.getInstance().camera.setCenter(1500,
                        mSlingshot.getPosition().y);
            }
        }
    }

    // ZOOM
    @Override
    public void onPinchZoomStarted(PinchZoomDetector pPinchZoomDetector,
            TouchEvent pSceneTouchEvent) {
        // TODO Auto-generated method stub
        mPinchZoomStartedCameraZoomFactor = Game.getInstance().camera
                .getZoomFactor();
    }

    float tzoom = 0;

    @Override
    public void onPinchZoomFinished(PinchZoomDetector pPinchZoomDetector,
            TouchEvent pTouchEvent, float pZoomFactor) {
        // TODO Auto-generated method stub

        float temp = pZoomFactor;

        if (tzoom <= temp)
            Game.getInstance().camera.setCenter(mSlingshot.getPosition().x,
                    mSlingshot.getPosition().y);
        if (tzoom > temp)
            Game.getInstance().camera.setCenter(1500,
                    mSlingshot.getPosition().y);
        // Game.getInstance().camera.setCenter(Game.getInstance().camera.getCenterX(),mSlingshot.getPosition().y);
    }

    @Override
    public void onPinchZoom(PinchZoomDetector pPinchZoomDetector,
            TouchEvent pTouchEvent, float pZoomFactor) {
        // TODO Auto-generated method stub
        float temp = mPinchZoomStartedCameraZoomFactor * pZoomFactor;

        float scalex = 800 / maxWidth;
        float scaley = 480 / maxHeight;
        float maxzoom = 1;
        if (scalex < scaley)
            maxzoom = scaley;
        else
            maxzoom = scalex;

        if (temp <= 1 && temp >= maxzoom) {
            Game.getInstance().camera.setZoomFactor(temp);
        }
        tzoom = Game.getInstance().camera.getZoomFactor();
        // } else if (temp >= 1) {
        // Game.getInstance().camera.setZoomFactor(1);
        // } else {
        // Game.getInstance().camera.setZoomFactor(maxzoom);
        // }
    }

    @Override
    public void onScrollStarted(ScrollDetector pScollDetector, int pPointerID,
            float pDistanceX, float pDistanceY) {
        // TODO Auto-generated method stub

    }

}
