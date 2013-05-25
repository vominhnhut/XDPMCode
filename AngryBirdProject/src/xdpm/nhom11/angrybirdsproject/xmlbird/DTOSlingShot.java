package xdpm.nhom11.angrybirdsproject.xmlbird;

import xdpm.nhom11.angrybirdsproject.entities.Slingshot;

public class DTOSlingShot {
	public float x;
	public float y;

	public Slingshot getSlingshot() {
		return new Slingshot(x-19, y+67);
	}
	
}
