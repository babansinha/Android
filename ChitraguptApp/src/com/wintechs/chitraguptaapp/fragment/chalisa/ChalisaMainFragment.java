package com.wintechs.chitraguptaapp.fragment.chalisa;

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
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.enums.ChitraguptaEnum;
import com.wintechs.chitraguptaapp.fragment.BaseFragment;
import com.wintechs.chitraguptaapp.fragment.pujavidhi.TabFragment;

public class ChalisaMainFragment extends BaseFragment implements ActionBar.TabListener {

	private ViewPager mViewPager;
	private View view;
	private AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	private ActionBar actionBar;
	private static int navItemPosition;

	private static final List<String> chalisaTabs;
	static {
		chalisaTabs = new ArrayList<String>();
		chalisaTabs.add("CHALISA 1");
		chalisaTabs.add("CHALISA 2");
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
	}

	@Override
	public void initValues() {
		//actionBar = getActivity().getActionBar();
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

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
				 ((ActionBarActivity)getActivity()).getSupportActionBar().setSelectedNavigationItem(position);
				//actionBar.setSelectedNavigationItem(position);
			}
		});
		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter.
			// Also specify this Activity object, which implements the
			// TabListener interface, as the
			// listener for when this tab is selected.
			 ((ActionBarActivity)getActivity()).getSupportActionBar().addTab( ((ActionBarActivity)getActivity()).getSupportActionBar().newTab().setText(mAppSectionsPagerAdapter.getPageTitle(i)).setTabListener((TabListener) this));
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
			System.out.println("Position " + i);
			switch (i) {
			case 0:
				return TabFragment.newInstance(i, ChitraguptaEnum.CHALISA);
			case 1:
				return TabFragment.newInstance(i, ChitraguptaEnum.CHALISA);

			default:
				// The other sections of the app are dummy placeholders.
				return TabFragment.newInstance(0, ChitraguptaEnum.CHALISA);
			}
		}

		@Override
		public int getCount() {
			return chalisaTabs.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return chalisaTabs.get(position);
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
		 ((ActionBarActivity)getActivity()).getSupportActionBar().removeAllTabs();
		 ((ActionBarActivity)getActivity()).getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		super.onDestroy();
	}

}
