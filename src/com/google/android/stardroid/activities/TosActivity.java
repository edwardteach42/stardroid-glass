package com.google.android.stardroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.google.android.stardroid.R;

public class TosActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tos_view);

	}

	public void agreeClick(View view) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(DynamicStarMapActivity.READ_TOS_PREF, true);
		editor.commit();
		Intent intent = new Intent(this, DynamicStarMapActivity.class);
		startActivity(intent);
		super.finish();
	}

	public void disagreeClick(View view) {
		super.finish();
	}

}
