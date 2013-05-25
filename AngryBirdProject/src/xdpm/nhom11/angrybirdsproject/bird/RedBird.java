package xdpm.nhom11.angrybirdsproject.bird;

import java.util.Random;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import xdpm.nhom11.angrybirdsproject.entities.Bird;
import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

/**
 * Chim đỏ
 * 
 * @author Hoa Phat
 * 
 */
public class RedBird extends Bird {

    /**
     * @param pX
     *            vị trí x
     * @param pY
     *            vị trí y
     * @param fixturedef
     *            fixture
     */
    public RedBird(float pX, float pY, FixtureDef fixturedef) {
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
                TexturePackerHelper.RED_BIRD_TILEDTEXTURE,
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

        this.mBody = physicseditor.createBody("RED BIRD", this.mSprite,
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

        super.collide(force);
        if (force > 700) {
            EffectManager eff = new EffectManager();
            EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                    this.mSprite.getY(), "red");
            SoundHelper.redbird_collision.play();
            this.mSprite.setCurrentTileIndex(4);
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

    @Override
    public void destroy() {

        super.destroy();

        EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                this.mSprite.getY(), "red");
    }

    @Override
    public void UseSkill() {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        super.Shoot(force);
        this.mSprite.setCurrentTileIndex(3);
    }
}
