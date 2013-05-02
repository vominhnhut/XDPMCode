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

public class DAOBird{
	static final String KEY_ID = "id";
	static final String KEY_FINALSCORE = "finalscore";

	public ArrayList<DTOBird> load(ContextWrapper contextwrapper) throws IOException,
			ParserConfigurationException, SAXException {

		ArrayList<DTOBird> ListBird = new ArrayList<DTOBird>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/BIRD.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList birds = doc.getElementsByTagName("BIRD");

		for (int i = 0; i < birds.getLength(); i++) {
			DTOBird bird = new DTOBird();
			bird.id = Integer.parseInt(birds.item(i).getAttributes()
					.getNamedItem(KEY_ID).getNodeValue().toString());
			bird.finalscore = Double.parseDouble(birds.item(i).getAttributes()
					.getNamedItem(KEY_FINALSCORE).getNodeValue().toString());
			ListBird.add(bird);
		}

		return ListBird;
	}
}
