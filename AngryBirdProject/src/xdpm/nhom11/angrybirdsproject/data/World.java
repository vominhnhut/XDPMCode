package xdpm.nhom11.angrybirdsproject.data;

import java.util.ArrayList;

import org.andengine.opengl.texture.region.TiledTextureRegion;

import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOChapter;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOWorld;

public class World {

	String id = "";
	String backgroundID = "";
	boolean locked = true;

	ArrayList<Chapter> ListChapter;

	public World() {
		ListChapter = new ArrayList<Chapter>();
	}

	public World(DTOWorld dto) {
		ListChapter = new ArrayList<Chapter>();
		this.id = dto.id;
		this.locked = dto.locked;

		for (DTOChapter chapterdto : dto.chapters) {
			ListChapter.add(new Chapter(chapterdto));
		}
	}

	public String getID() {
		return id;
	}

	public boolean isLocked() {
		return locked;
	}

	public ArrayList<Chapter> getListChapter() {
		return ListChapter;
	}

	public void setListChapter(ArrayList<Chapter> list) {

		ListChapter = list;
	}

	public void setWorldByDTO(DTOWorld dto) {
		this.id = dto.id;
		this.locked = dto.locked;
		for (DTOChapter chapterdto : dto.chapters) {
			ListChapter.add(new Chapter(chapterdto));
		}
	}

	public TiledTextureRegion getTextureOfWorld() {
		TiledTextureRegion temp = null;

		if (this.id.equalsIgnoreCase("WORLD1")) {
			temp = TexturePackerHelper.world1_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD2")) {
			temp = TexturePackerHelper.world2_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD3")) {
			temp = TexturePackerHelper.world3_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD4")) {
			temp = TexturePackerHelper.world4_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD5")) {
			temp = TexturePackerHelper.world5_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD6")) {
			temp = TexturePackerHelper.world6_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD7")) {
			temp = TexturePackerHelper.world7_TiledTexture;

		} else if (this.id.equalsIgnoreCase("WORLD8")) {
			temp = TexturePackerHelper.world8_TiledTexture;

		} else {
			temp = TexturePackerHelper.world1_TiledTexture;

		}

		return temp;

	}

	public void addChapter(Chapter temp) {
		this.ListChapter.add(temp);

	}

	public int getTotalStar() {
		int temp = 0;
		for (Chapter ch : ListChapter)
			temp += ch.getTotalStar();

		return temp;

	}

	public int getCurrentStar() {
		int temp = 0;
		for (Chapter ch : ListChapter)
			temp += ch.getCurrentStar();

		return temp;

	}
}
