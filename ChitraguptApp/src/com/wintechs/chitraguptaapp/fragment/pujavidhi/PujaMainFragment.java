package com.wintechs.chitraguptaapp.fragment.pujavidhi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.customviews.PagerSlidingTabStrip;
import com.wintechs.chitraguptaapp.enums.ChitraguptaEnum;
import com.wintechs.chitraguptaapp.fragment.BaseFragment;

public class PujaMainFragment extends BaseFragment {
	private View view;
	private PagerSlidingTabStrip tabStrip;
	private ViewPager viewPager;
	private MyPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.puja_vidhi_main, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void initViews() {
		tabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
		viewPager = (ViewPager) view.findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());

		viewPager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
		viewPager.setPageMargin(pageMargin);

		tabStrip.setViewPager(viewPager);
	}
	

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "Puja Items", "Before Puja", "During Puja", "After Puja" };

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
			
			return TabFragment.newInstance(position, ChitraguptaEnum.PUJA_VIDHI);

		/*	switch (position) {
			case 0:

				return SuperAwesomeCardFragment.newInstance(position);
			case 1:

				return SuperAwesomeCardFragment.newInstance(position);
			case 2:

				return SuperAwesomeCardFragment.newInstance(position);
			case 3:

				return SuperAwesomeCardFragment.newInstance(position);

			default:
				return SuperAwesomeCardFragment.newInstance(position);
			}*/

		}

	}
}
