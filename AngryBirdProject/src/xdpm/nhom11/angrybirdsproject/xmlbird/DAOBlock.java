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

public class DAOBlock{
	static final String KEY_ID = "id";
	static final String KEY_LIFEVALUE = "lifevalue";
	static final String KEY_SCORE = "score";

	public ArrayList<DTOBlock> load(ContextWrapper contextwrapper) throws IOException,
			ParserConfigurationException, SAXException {

		ArrayList<DTOBlock> ListBlock = new ArrayList<DTOBlock>();
		AssetManager assetManager = contextwrapper.getAssets();

		InputStream in = assetManager.open("gfx/dataxml/BLOCK.xml");

		DocumentBuilder builder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = builder.parse(in, null);
		NodeList blocks = doc.getElementsByTagName("BLOCK");

		for (int i = 0; i < blocks.getLength(); i++) {
			DTOBlock block = new DTOBlock();
			block.id = Integer.parseInt(blocks.item(i).getAttributes()
					.getNamedItem(KEY_ID).getNodeValue().toString());
			
			block.lifevalue = Integer.parseInt(blocks.item(i).getAttributes()
					.getNamedItem(KEY_LIFEVALUE).getNodeValue().toString());
			
			block.score = Double.parseDouble(blocks.item(i).getAttributes()
					.getNamedItem(KEY_SCORE).getNodeValue().toString());
			
			ListBlock.add(block);
		}

		return ListBlock;
	}
}
