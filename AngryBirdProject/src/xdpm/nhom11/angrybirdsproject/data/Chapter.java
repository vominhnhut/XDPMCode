package xdpm.nhom11.angrybirdsproject.data;

import java.util.ArrayList;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;

import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOChapter;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOLevel;

public class Chapter {

	String id = "";

	ArrayList<Level> ListLevel;

	public Chapter() {

		ListLevel = new ArrayList<Level>();
	}

	public Chapter(DTOChapter dto) {
		ListLevel = new ArrayList<Level>();
		id = dto.id;

		for (DTOLevel leveldto : dto.levels) {
			ListLevel.add(new Level(leveldto));
		}
	}

	public String getID() {
		return id;
	}

	public ArrayList<Level> getListLevel() {
		return ListLevel;
	}

	public void setListLevel(ArrayList<Level> list) {

		ListLevel = list;
	}

	public void setChapterByDTO(DTOChapter dto) {

		id = dto.id;
		for (DTOLevel leveldto : dto.levels) {
			ListLevel.add(new Level(leveldto));
		}
	}

	public void addLevel(Level temp) {
		this.ListLevel.add(temp);
	}

	public int getTotalStar() {
		int temp = 0;
		for (Level lv : ListLevel)
			temp += lv.getTotalStar();

		return temp;

	}

	public int getCurrentStar() {
		int temp = 0;
		for (Level lv : ListLevel)
			temp += lv.getCurrentStar();

		return temp;

	}

	public ITextureRegion getTexture() {
		return TexturePackerHelper.chooselevel_btn_TiledTexture
				.getTextureRegion(0);
	}
}
