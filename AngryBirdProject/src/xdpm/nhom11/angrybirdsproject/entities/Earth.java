package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.physicseditor.PhysicsEditorShapeLibrary;

public class Earth extends GameEntity {
    Rectangle staticRect;

    public Earth(float pY) {
        loadResource();
        loadBody(null, Map.mPhysicsWorld);
        Map.mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(
                staticRect, mBody));

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
    public ObjectType getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadResource() {
        // TODO Auto-generated method stub
        staticRect = new Rectangle(0f, 0f, 10000f, 1f, Game.getInstance().vbom);
        staticRect.setColor(0f, 0f, 0f);
        staticRect.setAlpha(0);

    }

    @Override
    public void loadBody(PhysicsEditorShapeLibrary physicseditor,
            PhysicsWorld physicsworld) {
        // TODO Auto-generated method stub
        mBody = PhysicsFactory.createBoxBody(physicsworld, staticRect,
                BodyType.StaticBody,
                PhysicsFactory.createFixtureDef(0.2f, 0.2f, 0.5f));
    }

    @Override
    public void collide(float force) {
        // TODO Auto-generated method stub

    }

    @Override
    public void checkState() {
        // TODO Auto-generated method stub

    }

}
