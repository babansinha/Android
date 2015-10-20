/**
 * 
 */
package com.wintechs.chitraguptaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * @author admin
 *
 */
public abstract class BaseFragment extends Fragment{
	
	public abstract void initViews();
	public abstract void initValues();
	public abstract void initListeners();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Preferences.onActivityCreateSetTheme(getActivity());
	}


}
