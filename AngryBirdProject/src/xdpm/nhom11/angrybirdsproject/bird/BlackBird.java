package xdpm.nhom11.angrybirdsproject.bird;

import java.util.Random;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import xdpm.nhom11.angrybirdsproject.entities.Bird;
import xdpm.nhom11.angrybirdsproject.entities.Map;
import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

/**
 * Chim đen
 * 
 * @author Hoa Phat
 * 
 */
public class BlackBird extends Bird {

    /**
     * @param pX
     *            vị trí x
     * @param pY
     *            vị trí y
     * @param fixturedef
     */
    public BlackBird(float pX, float pY, FixtureDef fixturedef) {
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
                TexturePackerHelper.BLACK_BIRD_TILEDTEXTURE,
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

        this.mBody = physicseditor.createBody("BLACK BIRD", this.mSprite,
                physicsworld, this.mFixture);
        super.loadBody(physicseditor, physicsworld);
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.Bird#UseSkill()
     */
    @Override
    public void UseSkill() {

        if (isUsedSkill == false && isFlying == true) {
            this.mSprite.setCurrentTileIndex(6);
            float t = 0;
            if (mSprite.getHeight() > mSprite.getWidth()) {
                t = mSprite.getHeight();
            } else
                t = mSprite.getWidth();

            for (int i = 0; i < 360; i += 15) {
                double ra = Math.toRadians(i);
                Vector2 temp = new Vector2((float) Math.cos(ra),
                        (float) Math.sin(ra)).mul(t);

                Rectangle a = new Rectangle(mSprite.getX() + temp.x,
                        mSprite.getY() + temp.y, 2, 2,
                        new VertexBufferObjectManager());
                a.setAlpha(0);
                SceneManager.getInstance().getCurrentScene().attachChild(a);
                Body b = PhysicsFactory.createCircleBody(Map.mPhysicsWorld, a,
                        BodyType.DynamicBody,
                        PhysicsFactory.createFixtureDef(100, 0.1f, 0.5f));
                Map.mPhysicsWorld
                        .registerPhysicsConnector(new PhysicsConnector(a, b));
                b.applyForce(temp.mul(11000), mBody.getWorldCenter());
            }

            mBody.setLinearVelocity(0, 0);

            this.destroy();

            isUsedSkill = true;
        }

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

            EffectManager.getInstance().showBirdFeather(this.mSprite.getX(),
                    this.mSprite.getY(), "black");
            SoundHelper.bluebird_collision.play();
            this.mSprite.setCurrentTileIndex(2);
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
        this.mSprite.setCurrentTileIndex(new Random().nextInt(3));
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
                this.mSprite.getY(), "black");
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
        this.mSprite.setCurrentTileIndex(3);
    }

}
