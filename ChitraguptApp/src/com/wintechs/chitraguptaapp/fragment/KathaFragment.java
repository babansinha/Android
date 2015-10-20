/**
 * 
 */
package com.wintechs.chitraguptaapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wintech.chitraguptapp.R;

/**
 * @author admin
 * 
 */
public class KathaFragment extends BaseFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.katha_layout, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void initViews() {

	}

	@Override
	public void initListeners() {

	}

	@Override
	public void initValues() {

	}

}
