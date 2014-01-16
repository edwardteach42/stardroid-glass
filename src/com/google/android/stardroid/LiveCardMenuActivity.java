package com.google.android.stardroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Activity showing the options menu.
 */

public class LiveCardMenuActivity extends Activity {
	private static final String TAG = "LiveCardMenuActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		openOptionsMenu();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.livecard, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		super.onPrepareOptionsMenu(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		try {
			Log.i(TAG, "+onOptionsItemSelected(...)");

			switch (item.getItemId()) {
			case R.id.action_stop: {
				stopService(new Intent(this, LiveCardService.class));
				finish();
				return true;
			}
			default: {
				return super.onOptionsItemSelected(item);
			}
			}
		} finally {
			Log.i(TAG, "+onOptionsItemSelected(...)");
		}
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		super.onOptionsMenuClosed(menu);
		finish();
	}
}
