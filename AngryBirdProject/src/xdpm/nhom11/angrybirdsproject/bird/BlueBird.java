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
 * Chim xanh
 * 
 * @author Hoa Phat
 * 
 */
public class BlueBird extends Bird {

    /**
     * @param pX
     *            vị trí x
     * @param pY
     *            vị trí y
     * @param fixturedef
     *            fixture
     */
    public BlueBird(float pX, float pY, FixtureDef fixturedef) {
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
                TexturePackerHelper.BLUE_BIRD_TILEDTEXTURE,
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

        this.mBody = physicseditor.createBody("BLUE BIRD", this.mSprite,
                physicsworld, this.mFixture);
        super.loadBody(physicseditor, physicsworld);
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.Bird#collide(float)
     */
    @Override
    public void collide(float force) {
        // TODO Auto-generated method stub
        super.collide(force);
        if (force > 700) {

            EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                    this.mSprite.getY(), "blue");
            SoundHelper.bluebird_collision.play();
            this.mSprite.setCurrentTileIndex(3);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.Bird#UseSkill()
     */
    @Override
    public void UseSkill() {

        BlueBird bird1 = null;
        BlueBird bird2 = null;
        if (isUsedSkill == false && isFlying == true) {
            if (bird1 == null) {
                Vector2 t1 = new Vector2(mSprite.getX(), mSprite.getY());
                bird1 = new BlueBird(t1.x + new Random().nextInt(3), t1.y
                        + new Random().nextInt(3), this.mFixture);
                bird1.onAttached(SceneManager.getInstance().getCurrentScene());
                bird1.Shoot(new Vector2(mBody.getLinearVelocity().x
                        + new Random().nextInt(3), mBody.getLinearVelocity().y
                        + new Random().nextInt(3)));
            }
            if (bird2 == null) {
                Vector2 t2 = new Vector2(mSprite.getX() - mSprite.getWidth(),
                        mSprite.getY() - mSprite.getHeight());
                bird2 = new BlueBird(t2.x - new Random().nextInt(3), t2.y
                        - new Random().nextInt(3), this.mFixture);
                bird2.onAttached(SceneManager.getInstance().getCurrentScene());
                bird2.Shoot(new Vector2(mBody.getLinearVelocity().x
                        - new Random().nextInt(3), mBody.getLinearVelocity().y
                        - new Random().nextInt(3)));
                isUsedSkill = true;
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.Bird#checkState()
     */
    @Override
    public void checkState() {

        super.checkState();
        this.mSprite.setCurrentTileIndex(new Random().nextInt(2));
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#destroy()
     */
    @Override
    public void destroy() {

        super.destroy();

        EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                this.mSprite.getY(), "blue");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * xdpm.nhom11.angrybirdsproject.entities.Bird#Shoot(com.badlogic.gdx.math
     * .Vector2)
     */
    @Override
    public void Shoot(Vector2 force) {

        super.Shoot(force);
        this.mSprite.setCurrentTileIndex(2);
    }

}
