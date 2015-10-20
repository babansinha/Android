package com.wintechs.chitraguptaapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;

public class AboutUsFragment extends BaseFragment {
	private View view;

	public AboutUsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.aboutus_layout, null);
		initViews();
		initValues();
		initListeners();

		return view;
	}

	@Override
	public void initViews() {
		TextView tvphone = (TextView) view.findViewById(R.id.txt_aboutus_head);
		// tvphone.setText(getActivity().getResources().getString(R.string.about));

	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}
}
