package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Heo trong game
 * 
 * @author Hoa Phat
 * 
 * 
 */
public class Pig extends GameEntity {

    /**
     * Loại heo
     * 
     * @author Hoa Phat
     * 
     */
    public enum PigType {
        KING, OLD, NORMAL, HELMET
    }

    /**
     * Loại heo
     */
    private PigType type;
    /**
     * ID
     */
    private String id;

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
    public Pig(String id, PigType type, float pX, float pY, float rotation,
            float lifevalue, FixtureDef fixturedef) {
        super(pX, pY, rotation, lifevalue, fixturedef);

        this.id = id;
        this.type = type;
        // load resource
        this.loadResource();
        // load body
        this.loadBody(ResourcesManager.getInstance().physicseditorbirdandpig,
                Map.mPhysicsWorld);
        // thay đổi vị trí
        this.setTransform(mPosition, mRotation);

        // kết nối sprite và body
        this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);

        // đăng kí kết nối
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

        return ObjectType.PIG;
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#loadResource()
     */
    @Override
    public void loadResource() {

        this.mSprite = new AnimatedSprite(this.mPosition.x, this.mPosition.y,
                (ITiledTextureRegion) getTextureByID(), Game.getInstance().vbom);
    }

    @Override
    public void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld) {

        this.mBody = physicseditor.createBody(id, mSprite, physicsworld,
                mFixture);
        this.mBody.setActive(false);

    }

    private ITextureRegion getTextureByID() {

        if (id.equalsIgnoreCase("KING PIG")) {
            return TexturePackerHelper.KING_PIG_TILEDTEXTURE;
        } else if (id.equalsIgnoreCase("SMALL PIG")) {
            return TexturePackerHelper.SMALL_PIG_TILEDTEXTURE;
        } else if (id.equalsIgnoreCase("LARGE PIG")) {
            return TexturePackerHelper.LARGE_PIG_TILEDTEXTURE;
        } else if (id.equalsIgnoreCase("MEDIUM PIG")) {
            return TexturePackerHelper.MEDIUM_PIG_TILEDTEXTURE;
        } else if (id.equalsIgnoreCase("HELMET PIG")) {
            return TexturePackerHelper.HELMET_PIG_TILEDTEXTURE;
        } else if (id.equalsIgnoreCase("OLD PIG")) {
            return TexturePackerHelper.OLD_PIG_TILEDTEXTURE;
        }
        return TexturePackerHelper.KING_PIG_TILEDTEXTURE;
    }

    @Override
    public void destroy() {

        super.destroy();
        SoundHelper.pig_destroyed.play();
        EffectManager.getInstance().showPigDead(this.mSprite.getX(),
                this.mSprite.getY());
    }

    @Override
    public void collide(float force) {

        if (force > 500f) {
            currentlifeValue -= force;
            SoundHelper.pig_collision.play();
        }

    }

    @Override
    public void checkState() {

        if (isDead == false && lifeValue > 0) {

            float percent = (currentlifeValue / lifeValue) * 100;
            if (currentlifeValue > 0) {

                if (percent > 30 && percent <= 60) {
                    if (this.mSprite.getTileCount() > 3) {
                        this.mSprite.setCurrentTileIndex(3);

                    }

                } else if (percent > 0 && percent <= 30) {
                    if (this.mSprite.getTileCount() > 6) {
                        this.mSprite.setCurrentTileIndex(6);

                    }

                }

            } else {
                this.destroy();
            }
        }

    }
}
