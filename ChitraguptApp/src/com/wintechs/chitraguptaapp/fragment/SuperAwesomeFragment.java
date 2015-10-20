package com.wintechs.chitraguptaapp.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;

public class SuperAwesomeFragment extends BaseFragment {

	private static final String ARG_POSITION = "position";

	private TextView textView;
	private View rootView;

	private int position;

	public static SuperAwesomeFragment newInstance(int position) {
		SuperAwesomeFragment f = new SuperAwesomeFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_card, container, false);
		initViews();
		initValues();
		initListeners();

		return rootView;
	}

	@Override
	public void initViews() {
		textView = (TextView) rootView.findViewById(R.id.textView);
	}

	@Override
	public void initValues() {
		ViewCompat.setElevation(rootView, 50);
		textView.setText("CARD " + position);
	}

	@Override
	public void initListeners() {

	}
}
