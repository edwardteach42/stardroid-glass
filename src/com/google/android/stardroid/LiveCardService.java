package com.google.android.stardroid;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.google.android.glass.timeline.TimelineManager;

public class LiveCardService extends Service {
	private static final String TAG = "LiveCardService";

	private static final String LIVE_CARD_TAG = "stardroid";

	private StardroidDrawer mCallback;

	private TimelineManager mTimelineManager;
	private LiveCard mLiveCard;

	@Override
	public void onCreate() {
		super.onCreate();

		mTimelineManager = TimelineManager.from(this);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (mLiveCard == null) {
			Log.i(TAG, "Publishing WAVE LiveCard");
			mLiveCard = mTimelineManager.createLiveCard(LIVE_CARD_TAG);

			// Keep track of the callback to remove it before unpublishing.
			mCallback = new StardroidDrawer(this);
			mLiveCard.setDirectRenderingEnabled(true).getSurfaceHolder()
					.addCallback(mCallback);

			Intent menuIntent = new Intent(this, LiveCardMenuActivity.class);
			menuIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_CLEAR_TASK);
			mLiveCard.setAction(PendingIntent.getActivity(this, 0, menuIntent,
					0));

			mLiveCard.publish(PublishMode.REVEAL);
			Log.i(TAG, "Done publishing WAVE LiveCard");

			// TODO:(pv) Attempt to log in using previous WavePreferences
		} else {
			// TODO(pv): Jump to the LiveCard when API is available.
		}

		return START_NOT_STICKY;
	}

	@Override
	public void onDestroy() {
		if (mLiveCard != null && mLiveCard.isPublished()) {
			Log.i(TAG, "Unpublishing WAVE LiveCard");
			mLiveCard.setViews(null);
			mLiveCard.unpublish();
			mLiveCard = null;
			Log.i(TAG, "Done unpublishing WAVE LiveCard");
		}
		super.onDestroy();
	}
}
