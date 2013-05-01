package xdpm.nhom11.angrybirdsproject.effectmanager;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.graphics.drawable.Animatable;

import xdpm.nhom11.angrybirdsproject.resourcemanager.ResourcesManager;
import xdpm.nhom11.angrybirdsproject.scene.SceneManager;

public class EffectManager {

	private static final EffectManager INSTANCE = new EffectManager();

	public static EffectManager getInstance() {
		return INSTANCE;
	}

	// MẪU
	public static void PigDead(float x, float y, Scene scene) {
		AnimatedSprite a = new AnimatedSprite(
				x,
				y,
				ResourcesManager.getInstance().texturepackerhelper.explode_whitesmoke_TiledTexture,
				ResourcesManager.getInstance().vbom);
		a.animate(25, false);
		scene.attachChild(a);
	}
}
