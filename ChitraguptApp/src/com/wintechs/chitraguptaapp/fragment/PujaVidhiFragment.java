package com.wintechs.chitraguptaapp.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.enums.ChitraguptaEnum;
import com.wintechs.chitraguptaapp.fragment.pujavidhi.TabFragment;

public class PujaVidhiFragment extends BaseFragment implements ActionBar.TabListener {

	private ViewPager mViewPager;
	private View view;
	private AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	private ActionBar actionBar;
	private static int navItemPosition;

	private static final List<String> poojaVidhi;
	static {
		poojaVidhi = new ArrayList<String>();
		poojaVidhi.add("Puja Items");
		poojaVidhi.add("Befor Puja");
		poojaVidhi.add("During Puja");
		poojaVidhi.add("After Puja");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.test_main, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initValues() {
		actionBar = getActivity().getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Set up the ViewPager, attaching the adapter and setting up a listener
		// for when the
		// user swipes between sections.
		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getActivity().getSupportFragmentManager());
		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mViewPager.setAdapter(mAppSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// When swiping between different app sections, select the
				// corresponding tab.
				// We can also use ActionBar.Tab#select() to do this if we have
				// a reference to the
				// Tab.
				actionBar.setSelectedNavigationItem(position);
			}
		});
		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter.
			// Also specify this Activity object, which implements the
			// TabListener interface, as the
			// listener for when this tab is selected.
			actionBar.addTab(actionBar.newTab().setText(mAppSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mAppSectionsPagerAdapter != null)
			mAppSectionsPagerAdapter.notifyDataSetChanged();
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	public static class AppSectionsPagerAdapter extends FragmentStatePagerAdapter {

		public AppSectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			switch (i) {
			case 0:
				return TabFragment.newInstance(i, ChitraguptaEnum.PUJA_VIDHI);
			case 1:
				return TabFragment.newInstance(i, ChitraguptaEnum.PUJA_VIDHI);
			case 2:
				return TabFragment.newInstance(i, ChitraguptaEnum.PUJA_VIDHI);
			case 3:
				return TabFragment.newInstance(i, ChitraguptaEnum.PUJA_VIDHI);

			default:
				// The other sections of the app are dummy placeholders.
				return TabFragment.newInstance(0, ChitraguptaEnum.PUJA_VIDHI);
			}
		}

		@Override
		public int getCount() {
			return poojaVidhi.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return poojaVidhi.get(position);
		}

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		actionBar.removeAllTabs();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		super.onDestroy();
	}

}
