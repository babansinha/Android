package com.wintechs.chitraguptaapp.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.customviews.PagerSlidingTabStrip;

public class PujaFragment1 extends BaseFragment {

	private View view;
	private ViewPager pager;
	private PagerSlidingTabStrip tabs;
	private MyPagerAdapter adapter;
	private Drawable oldBackground = null;
	private int currentColor;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.puja_layout, null);
		initViews();
		initValues();
		initListeners();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void initViews() {
		tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		pager = (ViewPager) view.findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);
		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
		pager.setPageMargin(pageMargin);
		pager.setCurrentItem(1);
		changeColor(getResources().getColor(R.color.green));

	}

	private void changeColor(int newColor) {
		tabs.setBackgroundColor(newColor);
		// mTintManager.setTintColor(newColor);
		// change ActionBar color just if an ActionBar is available
		Drawable colorDrawable = new ColorDrawable(newColor);
		Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
		LayerDrawable ld = new LayerDrawable(new Drawable[] { colorDrawable, bottomDrawable });

		/**if (oldBackground == null) {
			 ((ActionBarActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(ld);
			//getActivity().getActionBar().setBackgroundDrawable(ld);
		} else {
			TransitionDrawable td = new TransitionDrawable(new Drawable[] { oldBackground, ld });
			//getActivity().getActionBar().setBackgroundDrawable(td);
			 ((ActionBarActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(ld);
			td.startTransition(200);
		}
		*/

		oldBackground = ld;
		currentColor = newColor;
	}

	public void onColorClicked(View v) {
		int color = Color.parseColor(v.getTag().toString());
		changeColor(color);
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners() {
		tabs.setOnTabReselectedListener(new PagerSlidingTabStrip.OnTabReselectedListener() {
			@Override
			public void onTabReselected(int position) {
				Toast.makeText(getActivity(), "Tab reselected: " + position, Toast.LENGTH_SHORT).show();
			}
		});
	}

	public class MyPagerAdapter extends FragmentPagerAdapter  {

		private final String[] TITLES = { "Categories", "Home", "Top Paid", "Top Free", "Top Grossing", "Top New Paid", "Top New Free", "Trending" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeFragment.newInstance(position);
		}
	}

}
