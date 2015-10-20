package com.wintechs.chitraguptaapp.common;

import com.wintech.chitraguptapp.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentHelper {

	public static void replaceFragment(FragmentActivity mainActivity,
			Fragment rFragment) {
		// Getting reference to FragmentManager
		FragmentManager fragmentManager = mainActivity
				.getSupportFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();

		// Adding a fragment to fragment transaction
		ft.replace(R.id.content_frame, rFragment);

		// Committing the transaction
		ft.commit();
	}

	public static void replaceFragment(FragmentActivity mainActivity,
			Fragment rFragment, int arg) {
		// Getting reference to FragmentManager
		FragmentManager fragmentManager = mainActivity
				.getSupportFragmentManager();

		// Creating a fragment transaction
		FragmentTransaction ft = fragmentManager.beginTransaction();
		Bundle b = new Bundle();
		b.putInt("navItem", arg);
		// b.putString(CHITRAGUPTA_ENUM, chitraguptaEnum);
		rFragment.setArguments(b);
		// Adding a fragment to fragment transaction
		ft.replace(R.id.content_frame, rFragment);

		// Committing the transaction
		ft.commit();
	}
}
