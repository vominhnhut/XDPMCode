package xdpm.nhom11.angrybirdsproject.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.SmoothCamera;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import xdpm.nhom11.angrybirdsproject.GameActivity;

/**
 * Lớp Game, lớp lớn nhất chứa các giá trị cần thiết cho một game
 * 
 * @author Hoa Phat
 * 
 */
public class Game {

    /**
     * mẫu singleton
     */
    private static final Game INSTANCE = new Game();

    /**
     * engine của game
     */
    public Engine engine;

    /**
     * activity chính chạy game
     */
    public GameActivity activity;
    /**
     * Camera chính trong game
     */
    public SmoothCamera camera;
    /**
     * Buffer lưu trữ hình ảnh
     */
    public VertexBufferObjectManager vbom;

    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     */
    public void prepareGame(Engine engine, GameActivity activity,
            SmoothCamera camera, VertexBufferObjectManager vbom) {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }

    public static Game getInstance() {
        return INSTANCE;
    }
}
