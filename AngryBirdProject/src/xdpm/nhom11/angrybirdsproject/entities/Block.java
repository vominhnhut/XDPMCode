package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import xdpm.nhom11.angrybirdsproject.manager.EffectManager;
import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;

import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;
import xdpm.nhom11.angrybirdsproject.resourcemanager.SoundHelper;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

/**
 * Vật cản trong một màn chơi
 * 
 * @author Hoa Phat
 * 
 * 
 */
public class Block extends GameEntity {

    /**
     * Loại vật cản (ICE, WOOD, ROCK,...)
     * 
     * @author Hoa Phat
     * 
     */
    public enum BlockType {
        ICE, WOOD, ROCK
    }

    /**
     * Loại vật cản
     */
    BlockType type;
    /**
     * ID của vật cản
     */
    String id;

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
    public Block(String id, BlockType type, float pX, float pY, float rotation,
            float lifevalue, FixtureDef fixturedef) {
        super(pX, pY, rotation, lifevalue, fixturedef);
        this.id = id;
        this.type = type;
        // load resource
        this.loadResource();
        // load body
        this.loadBody(ResourcesManager.getInstance().physicseditorblock,
                Map.mPhysicsWorld);
        // thay đổi vị trí
        this.setTransform(mPosition, mRotation);

        // tạo kết nối giữa sprite và body
        this.mPhysicsConnector = new PhysicsConnector(mSprite, mBody);

        // đăng ký kết nới vối physicsworld
        Map.mPhysicsWorld.registerPhysicsConnector(this.mPhysicsConnector);

        this.mBody.setUserData(this);

        // đăng ký update cho đối tượng
        this.mSprite.registerUpdateHandler(this);

    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#getType()
     */
    @Override
    public ObjectType getType() {

        return ObjectType.BLOCK;

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

        this.mBody = physicseditor.createBody(id, mSprite, physicsworld,
                mFixture);

        this.mBody.setActive(false);

    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#collide(float)
     */
    @Override
    public void collide(float force) {

        if (force > 700f) {
            currentlifeValue -= force;
            switch (type) {
            case ICE:
                // SoundHelper.ice_collision.play();
                break;
            case ROCK:
                // SoundHelper.rock_collision.play();
                break;
            case WOOD:
                // SoundHelper.wood_collision.play();
                break;
            }

        }

    }

    /**
     * kiểm tra ID của vật cản để lấy sprite tương ứng
     */
    public ITextureRegion getTextureByID() {

        if (id.equalsIgnoreCase("RECEMPTY_WOOD")) {
            return TexturePackerHelper.RecEmpty_wood_TiledTexture;

        } else if (id.equalsIgnoreCase("RECEMPTY_ROCK")) {
            return TexturePackerHelper.RecEmpty_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("RECEMPTY_ICE")) {
            return TexturePackerHelper.RecEmpty_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAEMPTY_WOOD")) {
            return TexturePackerHelper.TriaEmpty_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAEMPTY_ROCK")) {
            return TexturePackerHelper.TriaEmpty_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAEMPTY_ICE")) {
            return TexturePackerHelper.TriaEmpty_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAFULL_WOOD")) {
            return TexturePackerHelper.TriaFull_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAFULL_ROCK")) {
            return TexturePackerHelper.TriaFull_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("TRIAFULL_ICE")) {
            return TexturePackerHelper.TriaFull_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("RECFULL_WOOD")) {
            return TexturePackerHelper.RecFull_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("RECFULL_ROCK")) {
            return TexturePackerHelper.RecFull_roc_TiledTexture;
        } else if (id.equalsIgnoreCase("RECFULL_ICE")) {
            return TexturePackerHelper.RecFull_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("RECLONG_WOOD")) {
            return TexturePackerHelper.RecLong_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("RECLONG_ROCK")) {
            return TexturePackerHelper.RecLong_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("RECLONG_ICE")) {
            return TexturePackerHelper.RecLong_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("RECMEDIUM_WOOD")) {
            return TexturePackerHelper.RecMedium_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("RECMEDIUM_ROCK")) {
            return TexturePackerHelper.RecMedium_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("RECMEDIUM_ICE")) {
            return TexturePackerHelper.RecMedium_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORT_WOOD")) {
            return TexturePackerHelper.RecShort_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORT_ROCK")) {
            return TexturePackerHelper.RecShort_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORT_ICE")) {
            return TexturePackerHelper.RecShort_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORTEST_WOOD")) {
            return TexturePackerHelper.RecShortest_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORTEST_ROCK")) {
            return TexturePackerHelper.RecShortest_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("RECSHORTEST_ICE")) {
            return TexturePackerHelper.RecShortest_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUAREMEDIUM_WOOD")) {
            return TexturePackerHelper.SquareMedium_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUAREMEDIUM_ROCK")) {
            return TexturePackerHelper.SquareMedium_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUAREMEDIUM_ICE")) {
            return TexturePackerHelper.SquareMedium_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUARESMALL_WOOD")) {
            return TexturePackerHelper.SquareSmall_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUARESMALL_ROCK")) {
            return TexturePackerHelper.SquareSmall_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("SQUARESMALL_ICE")) {
            return TexturePackerHelper.SquareSmall_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRBIG_WOOD")) {
            return TexturePackerHelper.CirBig_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRBIG_ROCK")) {
            return TexturePackerHelper.CirBig_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRBIG_ICE")) {
            return TexturePackerHelper.CirBig_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRMEDIUM_WOOD")) {
            return TexturePackerHelper.CirMedium_wood_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRMEDIUM_ROCK")) {
            return TexturePackerHelper.CirMedium_rock_TiledTexture;
        } else if (id.equalsIgnoreCase("CIRMEDIUM_ICE")) {
            return TexturePackerHelper.CirMedium_ice_TiledTexture;
        } else if (id.equalsIgnoreCase("OTHER_1")) {
            return TexturePackerHelper.other_1_TiledTexture;
        } else if (id.equalsIgnoreCase("OTHER_2")) {
            return TexturePackerHelper.other_2_TiledTexture;
        } else if (id.equalsIgnoreCase("OTHER_3")) {
            return TexturePackerHelper.other_3_TiledTexture;
        } else if (id.equalsIgnoreCase("TNT")) {
            return TexturePackerHelper.TNT_TiledTexture;
        } else if (id.equalsIgnoreCase("WHEEL")) {
            return TexturePackerHelper.Wheel_TiledTexture;
        } else if (id.equalsIgnoreCase("WATERMELON")) {
            return TexturePackerHelper.Watermelon_TiledTexture;
        } else if (id.equalsIgnoreCase("LEMON")) {
            return TexturePackerHelper.Lemon_TiledTexture;
        } else if (id.equalsIgnoreCase("FLAG")) {
            return TexturePackerHelper.Flag_TiledTexture;
        } else if (id.equalsIgnoreCase("FLAG_VN")) {
            return TexturePackerHelper.Flag_VN_TiledTexture;
        } else if (id.equalsIgnoreCase("DIAMOND")) {
            return TexturePackerHelper.Diamond_TiledTexture;
        } else if (id.equalsIgnoreCase("WHEELSMALL")) {
            return TexturePackerHelper.Wheelsmall_TiledTexture;
        } else if (id.equalsIgnoreCase("WHEELMEDIUM")) {
            return TexturePackerHelper.Wheelmedium_TiledTexture;
        } else if (id.equalsIgnoreCase("BERRY")) {
            return TexturePackerHelper.Berry_TiledTexture;
        } else if (id.equalsIgnoreCase("EGG")) {
            return TexturePackerHelper.Egg_TiledTexture;
        } else if (id.equalsIgnoreCase("BALLRED")) {
            return TexturePackerHelper.Ballred_TiledTexture;
        } else if (id.equalsIgnoreCase("BALLBLACK")) {
            return TexturePackerHelper.Ballblack_TiledTexture;
        } else if (id.equalsIgnoreCase("CUP")) {
            return TexturePackerHelper.Cup_TiledTexture;
        } else if (id.equalsIgnoreCase("EGGGOLDEN")) {
            return TexturePackerHelper.Egggolden_TiledTexture;
        } else if (id.equalsIgnoreCase("GROUNDBIG")) {
            return TexturePackerHelper.groundbig_TiledTexture;
        } else if (id.equalsIgnoreCase("GROUNDSMALL")) {
            return TexturePackerHelper.groundsmall_TiledTexture;
        } else if (id.equalsIgnoreCase("GROUNDLONG")) {
            return TexturePackerHelper.groundlong_TiledTexture;
        } else if (id.equalsIgnoreCase("GROUNDMEDIUM")) {
            return TexturePackerHelper.groundmedium_TiledTexture;
        } else if (id.equalsIgnoreCase("GROUNDSHORT")) {
            return TexturePackerHelper.groundshort_TiledTexture;
        } else if (id.equalsIgnoreCase("BANANA")) {
            return TexturePackerHelper.Banana_TiledTexture;
        } else if (id.equalsIgnoreCase("CHEST")) {
            return TexturePackerHelper.Chest_TiledTexture;
        }
        return TexturePackerHelper.Banana_TiledTexture;
    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#destroy()
     */
    @Override
    public void destroy() {

        if (mBody.isActive() == true) {
            switch (type) {
            case ICE:
                SoundHelper.ice_destroyed.play();
                EffectManager.getInstance()
                        .showBlockFragment(this.getSprite().getX(),
                                this.getSprite().getY(), "ice");
                break;
            case ROCK:
                SoundHelper.rock_destroyed.play();
                EffectManager.getInstance().showBlockFragment(
                        this.getSprite().getX(), this.getSprite().getY(),
                        "rock");
                break;
            case WOOD:
                SoundHelper.wood_destroyed.play();
                EffectManager.getInstance().showBlockFragment(
                        this.getSprite().getX(), this.getSprite().getY(),
                        "wood");
                break;
            }

            super.destroy();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see xdpm.nhom11.angrybirdsproject.entities.GameEntity#checkState()
     */
    @Override
    public void checkState() {

        if (isDead == false && lifeValue > 0) {

            if (currentlifeValue > 0) {
                // phần trăm lượng máu tồn tại
                float percent = (currentlifeValue / lifeValue) * 100;

                // trong khoảng từ 50% -> 75%
                if (percent > 50 && percent <= 75) {
                    if (this.mSprite.getTileCount() > 1) {
                        this.mSprite.setCurrentTileIndex(1);

                    }

                }
                // trong khoảng từ 25% -> 50%
                else if (percent > 25 && percent <= 50) {
                    if (this.mSprite.getTileCount() > 2) {
                        this.mSprite.setCurrentTileIndex(2);

                    }

                }
                // trong khoảng từ 0% -> 25%
                else if (percent > 0 && percent <= 25) {
                    if (this.mSprite.getTileCount() > 3) {
                        this.mSprite.setCurrentTileIndex(3);

                    }

                }

            } else {

                this.destroy();
            }
        }
    }
}
