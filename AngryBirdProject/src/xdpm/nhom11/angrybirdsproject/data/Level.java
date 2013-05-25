package xdpm.nhom11.angrybirdsproject.data;

import java.util.ArrayList;

import org.andengine.opengl.texture.region.ITextureRegion;

import xdpm.nhom11.angrybirdsproject.entities.Bird;
import xdpm.nhom11.angrybirdsproject.entities.Block;
import xdpm.nhom11.angrybirdsproject.entities.Map;
import xdpm.nhom11.angrybirdsproject.entities.Pig;
import xdpm.nhom11.angrybirdsproject.entities.Slingshot;

import xdpm.nhom11.angrybirdsproject.resourcemanager.TexturePackerHelper;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOChapter;
import xdpm.nhom11.angrybirdsproject.xmlbird.DTOLevel;

public class Level {
    String id = "";
    // level có bị khóa chưa
    boolean locked;
    // điểm cao nhất của level
    int highscore;
    // số sao đạt dc của level đó
    int numstar;
    // chiều rộng của map trong level
    float width;
    // chiều cao của map trong level
    float height;
    // màu nền của map trong level
    String bgcolor;

    Slingshot slingshot;
    ArrayList<Bird> ListBird;
    ArrayList<Pig> ListPig;
    ArrayList<Block> ListBlock;

    public Level() {
        ListBird = new ArrayList<Bird>();
        ListPig = new ArrayList<Pig>();
        ListBlock = new ArrayList<Block>();
    }

    public Level(DTOLevel dto) {

        ListBird = new ArrayList<Bird>();
        ListPig = new ArrayList<Pig>();
        ListBlock = new ArrayList<Block>();

        id = dto.id;
        locked = dto.locked;
        highscore = dto.highscore;
        numstar = dto.numstar;
        width = dto.width;
        height = dto.height;
        bgcolor = dto.bgcolor;

    }

    public String getID() {
        return id;
    }

    public boolean isLocked() {
        return locked;
    }

    public int getHighscore() {
        return highscore;
    }

    public int getNumberOfStar() {
        return numstar;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getColorBG() {
        return bgcolor;
    }

    public int getTotalStar() {
        return 3;

    }

    public int getCurrentStar() {

        return numstar;
    }

    public void setLevelByDTO(DTOLevel dto) {

        id = dto.id;
        locked = dto.locked;
        highscore = dto.highscore;
        numstar = dto.numstar;
        width = dto.width;
        height = dto.height;
        bgcolor = dto.bgcolor;
    }

    public void addBird(Bird bird) {
        ListBird.add(bird);
    }

    public void addPig(Pig pig) {
        ListPig.add(pig);

    }

    public void addBlock(Block block) {
        ListBlock.add(block);
    }

    public void setSlingshot(Slingshot slingshot) {
        this.slingshot = slingshot;

    }

    public ArrayList<Bird> getListBird() {
        return this.ListBird;
    }

    public ArrayList<Pig> getListPig() {
        return this.ListPig;
    }

    public ArrayList<Block> getListBlock() {
        return this.ListBlock;
    }

    public Slingshot getSlingshot() {
        return this.slingshot;
    }

    public ITextureRegion getTextureRegion() {
        if (locked)
            return TexturePackerHelper.locklevel_TiledTexture;
        return TexturePackerHelper.chooselevel_btn_TiledTexture;
    }

}
