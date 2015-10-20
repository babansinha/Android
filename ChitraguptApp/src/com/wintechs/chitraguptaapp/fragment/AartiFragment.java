/**
 * 
 */
package com.wintechs.chitraguptaapp.fragment;

import java.io.IOException;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.utils.FileUtils;

/**
 * @author admin
 * 
 */
public class AartiFragment extends BaseFragment {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.aarti_layout, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void initViews() {
		Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DroidHindi.ttf");

		final TextView tvphone = (TextView) view.findViewById(R.id.txt_aarti_head);
		tvphone.setTypeface(face, Typeface.NORMAL);
		// webView_aarti_hindi

		try {
			String history = FileUtils.getAssets("aarti_hindi", getActivity());
			if (history.length() > 0) {
				tvphone.setText(history);
				tvphone.setMovementMethod(new ScrollingMovementMethod());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
