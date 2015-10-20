/**
 * 
 */
package com.wintechs.chitraguptaapp.fragment;

import java.io.IOException;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.utils.FileUtils;
import com.wintechs.chitraguptaapp.utils.Preferences;

/**
 * @author admin
 * 
 */
public class HistoryFragment extends BaseFragment {
	private View view;

	public HistoryFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.history_layout, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Apply theme
		Preferences.onActivityCreateSetTheme(getActivity());
	}

	@Override
	public void initViews() {
		final TextView tvphone = (TextView) view.findViewById(R.id.txt_history_head);

		try {
			String history = FileUtils.getAssets("history_english", getActivity());
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
	}

	@Override
	public void initValues() {
	}

}
