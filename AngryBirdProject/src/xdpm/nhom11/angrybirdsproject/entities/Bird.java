package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.DelayModifier;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Chim trong game
 * 
 * @author Hoa Phat
 * 
 */
public abstract class Bird extends GameEntity {

    /**
     * Chim đang bay
     */
    protected boolean isFlying = false;

    /**
     * Đã sử dụng skill
     */
    protected boolean isUsedSkill = false;

    /**
     * @param pX
     *            vị trí x
     * @param pY
     *            vị trí y
     * @param fixturedef
     *            fixture
     */
    public Bird(float pX, float pY, FixtureDef fixturedef) {
        super(pX, pY, 0, fixturedef);
        // load resource
        this.loadResource();
        // load body
        this.loadBody(ResourcesManager.getInstance().physicseditorbirdandpig,
                Map.mPhysicsWorld);
        // kết nối body và sprite
        this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);

        // đăng ký
        Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

        this.mBody.setUserData(this);
        // đăng ký update
        this.mSprite.registerUpdateHandler(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#getType()
     */
    @Override
    public ObjectType getType() {

        return ObjectType.BIRD;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * xdpm.nhom11.angrybirdsproject.entities.GameEntity#loadBody(xdpm.nhom11
     * .angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary,
     * org.andengine.extension.physics.box2d.PhysicsWorld)
     */
    @Override
    public void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld) {

        this.mBody.setActive(false);
    }

    /**
     * bắn con chim
     * 
     * @param force
     *            lực bắn chim
     */
    public void Shoot(Vector2 force) {

        this.mBody.setActive(true);
        this.mBody.setLinearVelocity(force);

        Game.getInstance().camera.setChaseEntity(mSprite);

        isFlying = true;

        this.mSprite.clearEntityModifiers();
        this.mSprite.clearUpdateHandlers();
    }

    /**
     * Sử dụng skill
     */

    public abstract void UseSkill();

    // va chạm

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#collide(float)
     */
    @Override
    public void collide(float force) {
        // TODO Auto-generated method stub
        if (collided == false) {
            DelayModifier delay = new DelayModifier(5f) {
                @Override
                protected void onModifierFinished(IEntity pItem) {
                    // TODO Auto-generated method stub
                    super.onModifierFinished(pItem);
                    if (collided)
                        destroy();

                }
            };
            delay.setAutoUnregisterWhenFinished(true);

            SceneManager.getInstance().getCurrentScene()
                    .registerEntityModifier(delay);

        }
        Game.getInstance().camera.setChaseEntity(null);
        isUsedSkill = true;
        collided = true;

    }

    @Override
    public void checkState() {
        // TODO Auto-generated method stub

    }

    int count = 0;
    int count2 = 0;

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#onUpdate(float)
     */
    @Override
    public void onUpdate(float pSecondsElapsed) {

        if (mBody.isActive() == false) {

            count2++;
            count++;
            if (count > 100) {
                count = 0;
                checkState();

            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#resetSeft()
     */
    @Override
    public void resetSeft() {
        // TODO Auto-generated method stub
        super.resetSeft();
        isUsedSkill = false;
        isDead = false;
        collided = false;
        isFlying = false;

    }

    /**
     * đang bay
     * 
     * @return
     */
    public boolean isFlying() {
        return isFlying;
    }

    /**
     * đã sử dụng skill
     * 
     * @return
     */
    public boolean isUsedSkill() {
        return isUsedSkill;
    }
}
