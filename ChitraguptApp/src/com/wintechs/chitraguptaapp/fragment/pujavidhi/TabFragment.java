package com.wintechs.chitraguptaapp.fragment.pujavidhi;

import java.io.IOException;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.enums.ChitraguptaEnum;
import com.wintechs.chitraguptaapp.fragment.BaseFragment;
import com.wintechs.chitraguptaapp.utils.FileUtils;

public class TabFragment extends BaseFragment {

	private View view;
	private static final String ARG_POSITION = "position";
	//private static final String CHITRAGUPTA_ENUM = "chitraguptaEnum";

	private int position;
	private static ChitraguptaEnum chitraguptaEnum;
	private TextView tvphone;

	public static TabFragment newInstance(final int position, final ChitraguptaEnum chitraguptaEnum) {
		TabFragment f = new TabFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		//b.putString(CHITRAGUPTA_ENUM, chitraguptaEnum);
		f.setArguments(b);
		TabFragment.chitraguptaEnum = chitraguptaEnum;
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.pujavidhi_layout, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		//initValues();
	}

	@Override
	public void initViews() {
		
	    tvphone = (TextView) view.findViewById(R.id.txt_puja_head);
		
		// webView_aarti_hindi
		String fileName = getFileName();
		

		try {
			String contents = FileUtils.getAssets(fileName, getActivity());
			if (contents.length() > 0) {
				tvphone.setText(contents);
				tvphone.setMovementMethod(new ScrollingMovementMethod());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getFileName() {
		String fileName;
		if (TabFragment.chitraguptaEnum == ChitraguptaEnum.PUJA_VIDHI) {//For PUJA VIDHI
			switch (position) {
			case 0:
				fileName = FileUtils.PUJA_ITEMS;
				break;
			case 1:
				fileName = FileUtils.BEFORE_PUJA;
				break;
			case 2:
				fileName = FileUtils.DURING_PUJA;
				break;
			case 3:
				fileName = FileUtils.AFTER_PUJA;
				break;
			default:
				fileName = FileUtils.BEFORE_PUJA;
				break;
			}
		} else if (TabFragment.chitraguptaEnum == ChitraguptaEnum.CHALISA) {//For Chalisa
			Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
					"fonts/DroidHindi.ttf");
			tvphone.setTypeface(face, Typeface.NORMAL);
			switch (position) {
			case 0:
				fileName = FileUtils.CHALISA1_HINDI;
				break;
			case 1:
				fileName = FileUtils.CHALISA2_HINDI;
				break;
			default:
				fileName = FileUtils.CHALISA1_HINDI;
				break;
			}
		}else {//For Chalisa
			switch (position) {
			case 0:
				Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
						"fonts/DroidHindi.ttf");
				tvphone.setTypeface(face, Typeface.NORMAL);
				fileName = FileUtils.WANSH1_HINDI;
				break;
			case 1:
				fileName = FileUtils.WANSH2_HINDI;
				break;
			default:
				fileName = FileUtils.WANSH1_HINDI;
				break;
			}
		}
		return fileName;
	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

}
