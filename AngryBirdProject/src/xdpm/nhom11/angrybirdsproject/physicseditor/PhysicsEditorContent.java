package xdpm.nhom11.angrybirdsproject.physicseditor;

import android.content.Context;

public class PhysicsEditorContent {
	public static PhysicsEditorShapeLibrary physicseditorbirdandpig;
	public static PhysicsEditorShapeLibrary physicseditorblock;
	
	public PhysicsEditorContent(Context context)
	{
		physicseditorbirdandpig = new PhysicsEditorShapeLibrary();
		physicseditorbirdandpig.open(context, "gfx/body/BIRDANDPIG_BODY.xml");
		physicseditorblock = new PhysicsEditorShapeLibrary();
		physicseditorblock.open(context, "gfx/body/BLOCK_BODY.xml");
		
	}
}
