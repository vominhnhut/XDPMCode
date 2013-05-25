package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.util.ArrayList;

public class DTOWorld {

	public String id;
	public boolean locked;
	public String backgroundID;
	public ArrayList<DTOChapter> chapters;

	public DTOWorld() {
		chapters = new ArrayList<DTOChapter>();
	}

}
