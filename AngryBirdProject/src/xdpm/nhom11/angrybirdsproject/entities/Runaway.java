package xdpm.nhom11.angrybirdsproject.entities;

import java.util.ArrayList;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import android.util.Log;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.manager.SceneManager;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;

public class Runaway {

	public static ArrayList<Sprite> line = new ArrayList<Sprite>();

	public static void Add_line(float x, float y) {

		if (line == null) {
			line = new ArrayList<Sprite>();
		}
		AnimatedSprite sp = new AnimatedSprite(x, y,
				TexturePackerHelper.smoke_fagment_TiledTexture,
				Game.getInstance().vbom);

		sp.setZIndex(-1);
		sp.setScale(0.5f);
		SceneManager.getInstance().getCurrentScene().attachChild(sp);
		SceneManager.getInstance().getCurrentScene().sortChildren();
		Log.i("line", "sferhytre");
		sp.setCurrentTileIndex(1);
		line.add(sp);
	}

	public static void Remove_line() {
		if (line != null) {
			for (int i = 0; i < line.size(); i++) {
				SceneManager.getInstance().getCurrentScene()
						.detachChild(line.get(i));
			}

			line.clear();
			line = null;
		}
	}
}
