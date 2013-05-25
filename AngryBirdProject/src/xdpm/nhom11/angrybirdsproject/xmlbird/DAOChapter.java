package xdpm.nhom11.angrybirdsproject.xmlbird;

import java.io.IOException;
import java.util.ArrayList;

import org.andengine.entity.IEntity;
import org.andengine.util.SAXUtils;
import org.andengine.util.level.EntityLoader;
import org.andengine.util.level.IEntityLoader;
import org.andengine.util.level.IEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelEntityLoaderData;
import org.andengine.util.level.simple.SimpleLevelLoader;
import org.xml.sax.Attributes;

import android.util.Log;

public class DAOChapter {
	public final static String TAG_CHAPTER = "CHAPTER";
	public final static String KEY_ID = "id";

	public static ArrayList<DTOChapter> load(final SimpleLevelLoader loader) {

		final ArrayList<DTOChapter> ListChapter = new ArrayList<DTOChapter>();

		loader.registerEntityLoader(new EntityLoader<SimpleLevelEntityLoaderData>(
				TAG_CHAPTER) {
			@Override
			public IEntity onLoadEntity(String pEntityName, IEntity pParent,
					Attributes pAttributes,
					SimpleLevelEntityLoaderData pEntityLoaderData)
					throws IOException {
				// TODO Auto-generated method stub
				DTOChapter dtochapter = new DTOChapter();
				dtochapter.id = SAXUtils.getAttributeOrThrow(pAttributes,
						KEY_ID);

		
				dtochapter.levels = DAOLevel.load(loader);
				ListChapter.add(dtochapter);
				return null;
			}
		});

		return ListChapter;

	}

}
