package xdpm.nhom11.angrybirdsproject.physicseditor;

import android.content.Context;

public class PhysicsEditorContent {
	public static final PhysicsEditorShapeLibrary physicseditorbirdandpig = new PhysicsEditorShapeLibrary();;
	public static final PhysicsEditorShapeLibrary physicseditorblock = new PhysicsEditorShapeLibrary();;

	public PhysicsEditorContent(Context context) {
		// physicseditorbirdandpig = new PhysicsEditorShapeLibrary();
		physicseditorbirdandpig.open(context, "gfx/body/BIRDANDPIG_BODY.xml");
		// physicseditorblock = new PhysicsEditorShapeLibrary();
		physicseditorblock.open(context, "gfx/body/BLOCK_BODY.xml");

	}
}
