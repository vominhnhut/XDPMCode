package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Lớp trừu tượng các thực thể (Chim, heo,....)
 * 
 * @author Hoa Phat
 * 
 * 
 */
public abstract class GameEntity implements IUpdateHandler {

    /**
     * Loại thực thể
     * 
     * @author Hoa Phat
     * 
     */
    public static enum ObjectType {
        PIG, BIRD, BLOCK;

    }

    /**
     * Đã chết
     */
    protected boolean isDead = false;
    /**
     * Đã va chạm
     */
    protected boolean collided = false;
    /**
     * Độ bền ban đầu
     */
    protected float lifeValue = 0;
    /**
     * Độ bền hiện tại
     */
    protected float currentlifeValue = 0;
    /**
     * Sprite của đối tượng
     */
    protected AnimatedSprite mSprite;

    /**
     * Fixture của đối tượng (nặng, ma sát, đàn hồi)
     */
    protected FixtureDef mFixture;

    /**
     * Body của vật thể
     */
    protected Body mBody;

    /**
     * PhysicConnector
     */
    protected PhysicsConnector mPhysicsConnector;

    // /////////////////////////////////////////////////////////////////////////
    /**
     * Vị trí ban đầu
     */
    protected Vector2 mOriginalPosition;
    /**
     * Vị trí hiện tại
     */
    protected Vector2 mPosition;

    // /////////////////////////////////////////////////////////////////////////
    /**
     * Góc xoay ban đầu
     */
    protected float mOriginalRotation = 0;
    /**
     * Góc xoay hiện tại
     */
    protected float mRotation = 0;

    // CONTRUCTOR
    public GameEntity() {

    }

    /**
     * @param pX
     *            vị trí x.
     * @param pY
     *            vị trí y.
     * @param rotation
     *            góc xoay.
     * @param fixturedef
     *            fixturedef.
     */
    public GameEntity(float pX, float pY, float rotation, FixtureDef fixturedef) {

        this.mPosition = new Vector2(pX, pY);
        this.mOriginalPosition = new Vector2(pX, pY);
        this.mOriginalRotation = rotation;
        this.mRotation = rotation;
        this.mFixture = fixturedef;

    }

    /**
     * @param pX
     *            vị trí x
     * @param pY
     *            vị trí y
     * @param rotation
     *            góc xoay
     * @param lifevalue
     *            độ bền ban đầu
     * @param fixturedef
     *            fixture
     */
    public GameEntity(float pX, float pY, float rotation, float lifevalue,
            FixtureDef fixturedef) {

        this.mPosition = new Vector2(pX, pY);
        this.mOriginalPosition = new Vector2(pX, pY);
        this.mRotation = rotation;
        this.mOriginalRotation = rotation;
        this.mFixture = fixturedef;
        this.lifeValue = lifevalue;
        this.currentlifeValue = lifevalue;

    }

    /**
     * Lấy loại của thực thể
     * 
     * @return loại thực thể (BLOCK, PIG, BIRD,...)
     */
    public abstract ObjectType getType();

    /**
     * Load tài nguyên cho thực thể (sprite,..)
     */
    public abstract void loadResource();

    /**
     * Load body cho thực thể
     * 
     * @param physicseditor
     *            đối tượng thực thi load body từ xml
     * @param physicsworld
     *            physicworld muốn kết nối với body
     */
    public abstract void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld);

    /**
     * vạ chạm
     * 
     * @param force
     *            lực va chạm
     */
    public abstract void collide(float force);

    /**
     * kiểm tra trạng thái thực thể
     */
    public abstract void checkState();

    // SET ///////
    /**
     * @param value
     *            lượng máu ban đầu
     */
    public final void setLifeValue(final float value) {
        this.lifeValue = value;

    }

    /**
     * @param sp
     *            Sprite của thực thể
     */
    public final void setSprite(final AnimatedSprite sp) {
        this.mSprite = sp;
    }

    /**
     * @param fx
     *            fixturedef của thực thể
     */
    public final void setFixtureDef(final FixtureDef fx) {
        this.mFixture = fx;
    }

    /**
     * @param bd
     *            body
     */
    public final void setBody(final Body bd) {
        this.mBody = bd;
    }

    /**
     * thay đổi vị trí, góc xoay thực thể
     * 
     * @param position
     *            vị trí (x,y)
     * @param angle
     *            góc xoay (độ)
     */
    public final void setTransform(final Vector2 position, final float angle) {

        this.mPosition = position;
        final Vector2 v2 = new Vector2(position.x
                / PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT, position.y
                / PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
        this.mBody.setTransform(v2, (float) Math.toRadians(angle));

    }

    /**
     * @param ps
     *            vị trí
     */
    public final void setPosition(final Vector2 ps) {
        this.mPosition = ps;
    }

    /**
     * @param rt
     *            góc xoay
     */
    public final void setRotation(final float rt) {
        this.mRotation = rt;
    }

    /**
     * @param pc
     *            physicsconnector
     */
    public final void setPhysicsConnector(final PhysicsConnector pc) {
        this.mPhysicsConnector = pc;
    }

    // GET ///////
    /**
     * @return sprite của thực thể
     */
    public final Sprite getSprite() {
        return this.mSprite;
    }

    /**
     * @return fixture
     */
    public final FixtureDef getFixtureDef() {
        return this.mFixture;
    }

    /**
     * @return body của thực thể
     */
    public final Body getBody() {
        return this.mBody;
    }

    /**
     * @return vị trí thực thể
     */
    public Vector2 getPosition() {
        return this.mPosition;
    }

    /**
     * @return góc xoay thực thể
     */
    public final float getRotation() {
        return this.mBody.getAngle();
    }

    /**
     * @return độ bền hiện tại của vật thể
     */
    public float getCurrentLifeValue() {
        return this.currentlifeValue;
    }

    /**
     * @return physicsconnector
     */
    public final PhysicsConnector getPhysicsConnector() {
        return this.mPhysicsConnector;
    }

    // ////////////////////////////////////////////////////////////////////////////
    /**
     * attach sprite của thực thể
     * 
     * @param scn
     *            Scene
     */
    public void onAttached(final Scene scn) {
        scn.attachChild(mSprite);

    }

    /**
     * Detach sprite của thực thể
     * 
     * @param scn
     *            SCene
     */
    public void onDetached(final Scene scn) {
        scn.detachChild(mSprite);
    }

    /**
     * Unload tài nguyên thực thể
     */
    public void unload() {
        final PhysicsConnector physicsConnector = Map.mPhysicsWorld
                .getPhysicsConnectorManager().findPhysicsConnectorByShape(
                        mSprite);

        Game.getInstance().engine.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {

                if (physicsConnector != null) {
                    Map.mPhysicsWorld
                            .unregisterPhysicsConnector(physicsConnector);
                    mBody.setActive(false);
                    Map.mPhysicsWorld.destroyBody(mBody);
                    SceneManager.getInstance().getCurrentScene()
                            .detachChild(mSprite);
                    mSprite.clearEntityModifiers();
                    mSprite.clearUpdateHandlers();
                    mSprite.dispose();

                }
            }
        });

    }

    /**
     * Đưa thực thể về trạng thái ban đầu khởi tạo
     */
    public void resetSeft() {

        this.mSprite.clearUpdateHandlers();
        this.mSprite.clearEntityModifiers();
        this.mSprite.detachSelf();
        this.mBody.setLinearVelocity(0, 0);
        this.mBody.setAngularVelocity(0);
        this.mBody.setActive(false);
        this.setTransform(mOriginalPosition, this.mOriginalRotation);
        this.mSprite.setCurrentTileIndex(0);
        currentlifeValue = lifeValue;
        this.mSprite.registerUpdateHandler(this);
        Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

    }

    /**
     * 
     * Hủy thực thể trong map
     */
    public void destroy() {
        final PhysicsConnector physicsConnector = Map.mPhysicsWorld
                .getPhysicsConnectorManager().findPhysicsConnectorByShape(
                        mSprite);
        Map.mPhysicsWorld.unregisterPhysicsConnector(physicsConnector);
        mBody.setActive(false);
        mSprite.detachSelf();
        isDead = true;

    }

    @Override
    public void onUpdate(float pSecondsElapsed) {
        // TODO Auto-generated method stub
        checkState();
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }
}
