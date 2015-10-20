package com.wintechs.chitraguptaapp.fragment;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.utils.Constants;
import com.wintechs.chitraguptaapp.utils.Preferences;

public class SettingsFragment extends BaseFragment {

	private View view;
	private Spinner spinnerTheme, spinnerFont;
	private SeekBar brightessBar;
	private String[] textSizeItems = { "Small(15)", "Medium(20)", "Large(25)" };
	private String[] fontItems = { "Normal", "Sans", "Serif", "Monospace" };
	private String[] themeItems = { "Black", "White" };

	public SettingsFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.settings_layout, null);
		initViews();
		initValues();
		initListeners();
		return view;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Apply theme
		Preferences.onActivityCreateSetTheme(getActivity());
		/**if(Preferences.cTheme == 0){
			brightessBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.blue), PorterDuff.Mode.MULTIPLY));
		}*/

	}

	@Override
	public void initViews() {
		spinnerTheme = (Spinner) view.findViewById(R.id.spinner_theme);
		spinnerFont = (Spinner) view.findViewById(R.id.spinner_font);
		brightessBar = (SeekBar) view.findViewById(R.id.brightness_bar);
	}

	@Override
	public void initValues() {

		ArrayAdapter fontAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, fontItems);
		fontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerFont.setAdapter(fontAdapter);

		ArrayAdapter themeAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, themeItems);
		themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTheme.setAdapter(themeAdapter);

		spinnerFont.setSelection(searchString(fontItems, Constants.FONT));
		spinnerTheme.setSelection(Preferences.cTheme);
	}

	private int getTextFontSize(int sTextSize) {
		if (sTextSize == 15) {
			return 0;
		} else if (sTextSize == 20) {
			return 1;
		} else {
			return 2;
		}
	}

	private int searchString(String[] items, String value) {
		for (int index = 0; index < items.length; index++)
			if (items[index].equalsIgnoreCase(value))
				return index;
		return 0;
	}

	@Override
	public void initListeners() {

		spinnerFont.setOnItemSelectedListener(new OnItemSelectedListener() {

			// @Override
			public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {
				Constants.FONT = fontItems[position];

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		spinnerTheme.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {

				if (position != Preferences.cTheme) {
					Preferences.changeToTheme(getActivity(), position);
				}

				System.out.println("position >> " + position);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

}
