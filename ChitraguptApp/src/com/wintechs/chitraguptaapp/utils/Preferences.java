package com.wintechs.chitraguptaapp.utils;

import android.app.Activity;
import android.content.Intent;

import com.wintech.chitraguptapp.R;

public class Preferences {

	/** public static void applyTheme(ContextThemeWrapper contextThemeWrapper) {
		if (Preferences.darkThemeEnabled(contextThemeWrapper)) {
			contextThemeWrapper.setTheme(R.style.AppTheme_Black);
		}
	}

	private static boolean darkThemeEnabled(Context context) {
		return PreferenceManager
				.getDefaultSharedPreferences(context)
				.getString(context.getString(R.string.app_name),
						context.getString(R.string.pref_theme_black))
				.equals(context.getString(R.string.pref_theme_white));
	} **/

	// /////

	public static int cTheme = 0;

	public final static int BLACK = 0;

	public final static int WHITE = 1;

	public static void changeToTheme(Activity activity, int theme) {

		cTheme = theme;

		activity.finish();

		activity.startActivity(new Intent(activity, activity.getClass()));

	}

	public static void onActivityCreateSetTheme(Activity activity) {

		switch (cTheme) {
		case BLACK:
			activity.setTheme(R.style.AppTheme_Black);
			break;

		case WHITE:
			activity.setTheme(R.style.AppTheme_White);
			break;

		}

	}

}
