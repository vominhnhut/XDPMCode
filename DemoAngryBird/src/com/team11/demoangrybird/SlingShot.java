package com.team11.demoangrybird;

import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.util.Vector2Pool;
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class SlingShot 
{
	static float px = 100;			
	static float py = 110;
	static final float MAX_DISTANCE = 150f;			//khoảng cách tối đa
	static final float MAX_TOUCH_DISTANCE = 100f;	//vùng có thể chạm
	static final float MIN_SHOT_DISTANCE = 50f;
	public static final Vector2 SLINGSHOT_CENTER = new Vector2(300 - px, 300 - py);	//tâm cái ná

	// CHiM TRÊN NÁ
	public float distance; 			// khoang cach tu chim den tam cua na.
	boolean isBirdTouch = false;	//biến xác nhận đang chạm
	boolean istouchScene = false;
	private Line line1, line2;		//sợi dây
	
	private Vector2 endPoint = new Vector2();	//vị trí chạm

	final Sprite tree_left; // phần ná bên trái
	final Sprite tree_right; // phần ná bên trái
	final Sprite part; // nơi đặt chim 
	
	
	// khởi tạo
	public SlingShot(ITextureRegion textureRegion1,ITextureRegion textureRegion2,ITextureRegion textureRegion3, 
					VertexBufferObjectManager Ver, Scene mScene)
	{
		tree_right= new Sprite(SLINGSHOT_CENTER.x + 19,	SLINGSHOT_CENTER.y - 67, textureRegion2, Ver);
		mScene.attachChild(tree_right); //Scene add tree_right vào
		tree_right.setZIndex(0); // đặt chiều sâu của tree_right
		
		line2 = new Line(0, 0, 0, 0, 10, Ver); // tạo mới dây ná2
		line2.setColor(0.4f, 0, 0); // đặt màu cho dây
		mScene.attachChild(line2); // thêm dây vào Scene
		line2.setZIndex(1);	 //đặt chiều sâu cho line2
		
		part = new Sprite(SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y + 2, textureRegion3, Ver); // da ná
		mScene.attachChild(part); // thêm da ná vào scene
		part.setZIndex(3); // đặt chiều sâu cho da ná
		
		line1 = new Line(0, 0, 0, 0, 10, Ver); // tạo mới dây ná1
		line1.setColor(0.4f, 0, 0); // đặt màu
		mScene.attachChild(line1); //thêm dây vào Scene
		line1.setZIndex(4);	 // đặt độ sâu cho dây ná
		
		tree_left = new Sprite(SLINGSHOT_CENTER.x - 10,	SLINGSHOT_CENTER.y - 68, textureRegion1, Ver);
		mScene.attachChild(tree_left);
		tree_left.setZIndex(5);					
		
		part.setRotation(-45); //xoay dây ná 1 góc 45 độ
		mScene.sortChildren(); // cập nhật lại độ sâu của các đối tượng trong scene
	}

	boolean isShoot=false;
	Vector2 touch= null;
	
	
	//vòng lặp xử lý sự kiện của ná
	public void setSlingShot(TouchEvent pSceneTouchEvent, Body bird, boolean isScene)
	{
				
				//khoảng cách từ điểm chạm đến da ná
				float touchDistance = (new Vector2(part.getX(), part.getY())).dst(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());
			
				distance = SLINGSHOT_CENTER.dst(pSceneTouchEvent.getX(), pSceneTouchEvent.getY());	
					//nếu khoảng cách từ điểm chạm đến da ná nằm trong vùng có bán kính cho phép thì có thể chạm vào da ná.
					if(touchDistance <= MAX_TOUCH_DISTANCE) 
					{
						isBirdTouch = true;
					}
					
					if(isBirdTouch)
					{
						
						if (distance <= MAX_DISTANCE) 
						{							
							endPoint.x = pSceneTouchEvent.getX();
							endPoint.y = pSceneTouchEvent.getY();
						} 
						else 
						{
							float rate = (distance - MAX_DISTANCE) / distance;

							endPoint.x = (SLINGSHOT_CENTER.x - pSceneTouchEvent.getX())
									* rate + pSceneTouchEvent.getX();
							endPoint.y = (SLINGSHOT_CENTER.y - pSceneTouchEvent.getY())
									* rate + pSceneTouchEvent.getY();
						}					
					
					int eventaction = pSceneTouchEvent.getAction();	//lấy sự kiện touch				
					switch (eventaction) {
					//khi chạm xuống
					case TouchEvent.ACTION_DOWN:
						
						line1.setPosition(SLINGSHOT_CENTER.x - 22,
								SLINGSHOT_CENTER.y, endPoint.x, endPoint.y);
						line2.setPosition(SLINGSHOT_CENTER.x + 22,
								SLINGSHOT_CENTER.y, endPoint.x, endPoint.y);
						part.setPosition(endPoint.x, endPoint.y);
						
						float birdPosX = (SLINGSHOT_CENTER.x - endPoint.x) * 0.2f
											+ endPoint.x;
						float birdPosY = (SLINGSHOT_CENTER.y - endPoint.y) * 0.2f
											+ endPoint.y;
						
						
						touch = new Vector2(birdPosX, birdPosY);
						startPositionS(bird, 0, birdPosX, birdPosY);
						break;
					//khi không chạm nữa
					case TouchEvent.ACTION_UP:						
						
						//đặt lại vị trí
						Log.i("yes","UPPPPPPPPPPPPPPPPPPPPPP");
						if(touch.dst(SLINGSHOT_CENTER) <= MIN_SHOT_DISTANCE) {
							Log.i("yes","");
							
							touch = SLINGSHOT_CENTER;
							startPositionS(bird, 0, SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y);
							isShoot = false;
						}
						else
							isShoot = true;
						
						line1.setPosition(SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y,
											SLINGSHOT_CENTER.x - 22, SLINGSHOT_CENTER.y);
						line2.setPosition(SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y,
											SLINGSHOT_CENTER.x + 22, SLINGSHOT_CENTER.y);
						part.setPosition(SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y);
						
						isBirdTouch = false;
						//xét khi bằn
							
						break;
					//di chuyển chỗ chạm
					case TouchEvent.ACTION_MOVE:
						Log.i("yes","MOVEEEEEEEEEEEEEEEEEEEE");
						if(touch.dst(SLINGSHOT_CENTER) <= MIN_SHOT_DISTANCE) {
							Log.i("MOVE"," <<<<<<<<<<<<<<<<<<<<<<");
						}
						
						if(Math.abs(endPoint.x  - SLINGSHOT_CENTER.x) <= 20 && (SLINGSHOT_CENTER.y - endPoint.y) >= (MAX_DISTANCE - 20))
						{
							endPoint = new Vector2(SLINGSHOT_CENTER.x, SLINGSHOT_CENTER.y - MAX_DISTANCE + 90);
						}
						
						part.setPosition(endPoint.x, endPoint.y);
						
						line1.setPosition(SLINGSHOT_CENTER.x - 22,
								SLINGSHOT_CENTER.y, endPoint.x, endPoint.y);
						line2.setPosition(SLINGSHOT_CENTER.x + 22,
								SLINGSHOT_CENTER.y, endPoint.x, endPoint.y);

						float birdPosX1 = (SLINGSHOT_CENTER.x - endPoint.x) * 0.2f
											+ endPoint.x;
						float birdPosY1 = (SLINGSHOT_CENTER.y - endPoint.y) * 0.2f
											+ endPoint.y;
							
						startPositionS(bird, 0, birdPosX1, birdPosY1);
						touch = new Vector2(birdPosX1, birdPosY1);
						
					}
					
		}
	}
	
	private void startPositionS(Body dynamicbodyline, int angle, float x, float y) {
		// TODO Auto-generated method stub
			dynamicbodyline.setActive(false);
			dynamicbodyline.setAngularVelocity(0);
			dynamicbodyline.resetMassData();
			dynamicbodyline.setLinearVelocity(0, 0);

			final Vector2 v2 = Vector2Pool.obtain((x)/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT, 
													(y)/ PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
			dynamicbodyline.setTransform(v2, angle);
			Vector2Pool.recycle(v2);
	}
}
