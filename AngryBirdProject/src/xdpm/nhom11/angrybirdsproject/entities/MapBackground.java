package xdpm.nhom11.angrybirdsproject.entities;

import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.util.adt.color.Color;
import org.andengine.util.debug.Debug;

import android.util.Log;

import xdpm.nhom11.angrybirdsproject.manager.Game;
import xdpm.nhom11.angrybirdsproject.resourcemanager.MapBackground1;
import xdpm.nhom11.angrybirdsproject.resourcemanager.MapBackground2;
import xdpm.nhom11.angrybirdsproject.resourcemanager.MapBackground3;
import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOBackground;

public class MapBackground {

	ITextureRegion earth;
	ITextureRegion sky;
	ITextureRegion earth1;
	ITextureRegion earth2;
	Color colorBG;

	public MapBackground(String id) {

		loadBackground(id);
	}

	public ITextureRegion getSkyBackground() {
		return sky;
	}

	public ITextureRegion getEarthBackground() {
		return earth;
	}

	public ITextureRegion getEarthSurface1Background() {
		return earth1;
	}

	public ITextureRegion getEarthSurface2Background() {
		return earth2;
	}

	public Color getColor() {
		return colorBG;
	}

	private void loadBackground(String id) {

		try {
			TexturePackerHelper.texturePack = new TexturePackLoader(
					Game.getInstance().activity.getTextureManager(), "gfx/")
					.loadFromAsset(Game.getInstance().activity.getAssets(), id
							+ ".xml");
			Log.e("Page", id + ".xml");
			TexturePackerHelper.texturePack.loadTexture();
			TexturePackerHelper.texturePackLibrary = TexturePackerHelper.texturePack
					.getTexturePackTextureRegionLibrary();

		} catch (TexturePackParseException e) {
			Debug.e(e);
		}

		if (id.equalsIgnoreCase("MapBackground1")) {
			this.sky = TexturePackerHelper.getSpriteFromSheet(
					MapBackground1.SKY_ID, 1, 1);
			this.earth = TexturePackerHelper.getSpriteFromSheet(
					MapBackground1.EARTH_ID, 1, 1);
			this.earth1 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground1.EARTHSURFACE1_ID, 1, 1);
			this.earth2 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground1.EARTHSURFACE2_ID, 1, 1);
			colorBG = new Color((float) 149 / 255, (float) 205 / 255,
					(float) 223 / 255);

		} else if (id.equalsIgnoreCase("MapBackground2")) {
			this.sky = TexturePackerHelper.getSpriteFromSheet(
					MapBackground2.SKY_ID, 1, 1);
			this.earth = TexturePackerHelper.getSpriteFromSheet(
					MapBackground2.EARTH_ID, 1, 1);
			this.earth1 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground2.EATHSURFACE1_ID, 1, 1);
			this.earth2 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground2.EATHSURFACE2_ID, 1, 1);
			colorBG = new Color((float) 144 / 255, (float) 205 / 255,
					(float) 237 / 255);

		} else if (id.equalsIgnoreCase("MapBackground3")) {
			this.sky = TexturePackerHelper.getSpriteFromSheet(
					MapBackground3.SKY_ID, 1, 1);
			this.earth = TexturePackerHelper.getSpriteFromSheet(
					MapBackground3.EARTH_ID, 1, 1);
			this.earth1 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground3.EATHSURFACE_1_ID, 1, 1);
			this.earth2 = TexturePackerHelper.getSpriteFromSheet(
					MapBackground3.EATHSURFACE2_ID, 1, 1);
			colorBG = new Color((float) 211 / 255, (float) 247 / 255,
					(float) 254 / 255);

		}

	}
}
