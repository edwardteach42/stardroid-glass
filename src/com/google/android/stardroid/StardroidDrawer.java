package com.google.android.stardroid;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;

public class StardroidDrawer implements SurfaceHolder.Callback {
	private static final String TAG = "StardroidDrawer";
	private SurfaceHolder mHolder;

	public StardroidDrawer(Context context) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mHolder = holder;
		// mChronometerView.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// mChronometerView.stop();
		mHolder = null;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

		// Measure and layout the view with the canvas dimensions.
		int measuredWidth = View.MeasureSpec.makeMeasureSpec(width,
				View.MeasureSpec.EXACTLY);
		int measuredHeight = View.MeasureSpec.makeMeasureSpec(height,
				View.MeasureSpec.EXACTLY);
	}
}
