package entities.pack;

import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.detector.PinchZoomDetector;
import org.andengine.input.touch.detector.PinchZoomDetector.IPinchZoomDetectorListener;
import org.andengine.input.touch.detector.ScrollDetector;
import org.andengine.input.touch.detector.ScrollDetector.IScrollDetectorListener;
import org.andengine.input.touch.detector.SurfaceScrollDetector;

import android.widget.ZoomButton;

import com.badlogic.gdx.math.Vector2;

public class Camera2D implements IPinchZoomDetectorListener, IScrollDetectorListener {

	public ZoomCamera mSmoothCamera;
	private float mPinchZoomStartedCameraZoomFactor;
	public SurfaceScrollDetector mScrollDetector;
	public PinchZoomDetector mPinchZoomDetector;
	
	static final int CAMERA_WIDTH = 800;
	static final int CAMERA_HEIGHT = 480;
	
	public Camera2D(){
		this.mSmoothCamera = new ZoomCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.mSmoothCamera.setBounds(0, -30, 1850, 1080);
		this.mSmoothCamera.setBoundsEnabled(true);
		this.mSmoothCamera.set(0,0,800,480);
		
		mScrollDetector = new SurfaceScrollDetector(this);
		mPinchZoomDetector = new PinchZoomDetector(this);	
	}

	public void FollowBird(boolean isMove, boolean iszoom1, Vector2 bird)
	{
		if(isMove)
		{	
			// khi bay phóng to
			if(!iszoom1)
			{							
				if(bird.y>=0) 
				{	
					float temp = mSmoothCamera.getYMax() + bird.y/2 - mSmoothCamera.getYMin();
					if(temp < 1080 && mSmoothCamera.getXMin()+ bird.y/2 + mSmoothCamera.getYMax()*800/480 < 1850)
					{						
						mSmoothCamera.setYMax(temp);
						mSmoothCamera.setYMin(mSmoothCamera.getYMin()-0.6f);
						mSmoothCamera.setXMax(mSmoothCamera.getXMin()+ mSmoothCamera.getYMax()*800/480);
					}
					else
					{
						mSmoothCamera.setYMin(-30);
						mSmoothCamera.setYMax(1080);
						mSmoothCamera.setXMin(0);
						mSmoothCamera.setXMax(1850);
						iszoom1 = true;
					}
				}	
				else
				{
					iszoom1 = true;
				}	
			}
			
			//thu nhỏ -- t chịu thua
			if(iszoom1)
			{
			}			
		}
	}

	@Override
	public void onScrollStarted(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {
		// TODO Auto-generated method stub
		final float zoomFactor = this.mSmoothCamera.getZoomFactor();
		this.mSmoothCamera.offsetCenter((int) (-pDistanceX / zoomFactor), 0);
	}

	@Override
	public void onScroll(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {
		// TODO Auto-generated method stub
		final float zoomFactor = this.mSmoothCamera.getZoomFactor();
		this.mSmoothCamera.offsetCenter((int) (-pDistanceX / zoomFactor), 0);
	}

	@Override
	public void onScrollFinished(ScrollDetector pScollDetector, int pPointerID,
			float pDistanceX, float pDistanceY) {
		// TODO Auto-generated method stub
		final float zoomFactor = this.mSmoothCamera.getZoomFactor();
		this.mSmoothCamera.offsetCenter((int) (-pDistanceX / zoomFactor), 0);
	}

	@Override
	public void onPinchZoomStarted(PinchZoomDetector pPinchZoomDetector,
			TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		this.mPinchZoomStartedCameraZoomFactor = this.mSmoothCamera.getZoomFactor();
	}

	@Override
	public void onPinchZoom(PinchZoomDetector pPinchZoomDetector,
			TouchEvent pTouchEvent, float pZoomFactor) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void onPinchZoomFinished(PinchZoomDetector pPinchZoomDetector,
			TouchEvent pTouchEvent, float pZoomFactor) {
		// TODO Auto-generated method stub
		
		float temp = this.mPinchZoomStartedCameraZoomFactor * pZoomFactor;
		
		if(pTouchEvent.getX() < mSmoothCamera.getCenterX())
		{
			//zoom phía bên trái
			Zoomleft(pTouchEvent,temp);
		}
		else
		{
			//zoom về phía bên phải
			Zoomright(pTouchEvent,temp);
		}
		mPinchZoomDetector.setEnabled(false);
	}
	
	//zoom phía bên trái
	private void Zoomleft(TouchEvent pTouchEvent,float Zoom)
	{
		if (Zoom > 1) 
		{
			mSmoothCamera.set(0,0,800,480);
		}
		else
		if (Zoom <= 1 && Zoom > 0.85f) 
		{
				mSmoothCamera.set(0, -10, 1150, 680);
		} 
		else
		if (Zoom <= 0.85 && Zoom > 0.65f) 
		{
			mSmoothCamera.set(0,-20,1667,880);
		} 
		else
		if (Zoom < 0.65f)
		{
			mSmoothCamera.set(0,-30,1850,1080);
		}
	}
	
	//zoom về phía bên phải
	private void Zoomright(TouchEvent pTouchEvent,float Zoom)
	{
		if (Zoom > 1) 
		{
			mSmoothCamera.set(1000,0,1850,480);
		}
		else
		if (Zoom <= 1 && Zoom > 0.85f) 
		{
			mSmoothCamera.set(650, -10, 1850, 680);
		} 
		else
		if (Zoom <= 0.85 && Zoom > 0.65f) 
		{
			mSmoothCamera.set(134,-20,1850,880);
		} 
		else
		if (Zoom < 0.65f) 
		{
			mSmoothCamera.set(0,-30,1850,1080);
		}
	}
}
