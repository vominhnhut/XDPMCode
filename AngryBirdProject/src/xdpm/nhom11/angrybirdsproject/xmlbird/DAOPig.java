package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.ContextWrapper;
import android.content.res.AssetManager;

public class DAOPig{
	static final String KEY_ID = "id";
	static final String KEY_LIFEVALUE = "lifevalue";
	static final String KEY_SCORE = "score";

	public ArrayList<DTOPig> load(ContextWrapper contextwrapper) throws IOException,
			ParserConfigurationException, SAXException {

		ArrayList<DTOPig> ListPig = new ArrayList<DTOPig>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/PIG.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList pigs = doc.getElementsByTagName("PIG");

		for (int i = 0; i < pigs.getLength(); i++) {
			DTOPig pig = new DTOPig();
			pig.id = Integer.parseInt(pigs.item(i).getAttributes()
					.getNamedItem(KEY_ID).getNodeValue().toString());

			pig.lifevalue = Integer.parseInt(pigs.item(i).getAttributes()
					.getNamedItem(KEY_LIFEVALUE).getNodeValue().toString());

			pig.score = Double.parseDouble(pigs.item(i).getAttributes()
					.getNamedItem(KEY_SCORE).getNodeValue().toString());

			ListPig.add(pig);
		}

		return ListPig;
	}
}
