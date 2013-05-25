package xdpm.nhom11.angrybirdsproject.bird;

import java.util.Random;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import xdpm.nhom11.angrybirdsproject.entities.Bird;
import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 * Chim vàng
 * 
 * @author Hoa Phat
 * 
 */
public class YellowBird extends Bird {

    /**
     * @param pX
     *            vị trí X
     * @param pY
     *            vị trí Y
     * @param fixturedef
     *            fixture
     */
    public YellowBird(float pX, float pY, FixtureDef fixturedef) {
        super(pX, pY, fixturedef);

    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#loadResource()
     */
    @Override
    public void loadResource() {

        mSprite = new AnimatedSprite(mPosition.x, mPosition.y,
                TexturePackerHelper.YELLOW_BIRD_TILEDTEXTURE,
                Game.getInstance().vbom);
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.Bird#loadBody(xdpm.nhom11.
     * angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary,
     * org.andengine.extension.physics.box2d.PhysicsWorld)
     */
    @Override
    public void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld) {

        this.mBody = physicseditor.createBody("YELLOW BIRD", this.mSprite,
                physicsworld, this.mFixture);
        super.loadBody(physicseditor, physicsworld);
    }

    @Override
    public void collide(float force) {

        super.collide(force);
        if (force > 700) {

            EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                    this.mSprite.getY(), "yellow");
            SoundHelper.yellowbird_collision.play();
            this.mSprite.setCurrentTileIndex(5);
        }

    }

    @Override
    public void Shoot(Vector2 force) {

        super.Shoot(force);
        this.mSprite.setCurrentTileIndex(3);

    }

    @Override
    public void UseSkill() {

        if (isUsedSkill == false && isFlying == true) {
            this.mSprite.setCurrentTileIndex(4);

            float aaa = mBody.getLinearVelocity().x
                    / mBody.getLinearVelocity().y;
            float x = mBody.getLinearVelocity().x;
            float y = mBody.getLinearVelocity().y;

            if (x <= 0) {
                x -= 7 * Math.abs(aaa);
            } else {
                x += 7 * Math.abs(aaa);
            }
            if (y <= 0) {
                y -= 7;
            } else {
                y += 7;
            }
            mBody.setLinearVelocity(x, y);
            isUsedSkill = true;
        }
    }

    @Override
    public void checkState() {
        super.checkState();
        this.mSprite.setCurrentTileIndex(new Random().nextInt(3));
    }

    @Override
    public void destroy() {
        super.destroy();
        EffectManager.getInstance().showBirdFeather(mSprite.getX(),
                mSprite.getY(), "yellow");

    }
}
