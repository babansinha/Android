package com.wintechs.chitraguptaapp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wintech.chitraguptapp.R;
import com.wintechs.chitraguptaapp.navdata.NavMenuItem;

public class NavAdapter extends BaseAdapter {

	private Context context;
	private List<NavMenuItem> menuItems;

	public NavAdapter(Context context, List<NavMenuItem> menuItems) {
		this.context = context;
		this.menuItems = menuItems;

	}

	@Override
	public int getCount() {
		return menuItems.size();
	}

	@Override
	public Object getItem(int position) {
		return menuItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = LayoutInflater.from(context);

			if (position == 0) {
				view = inflater
						.inflate(R.layout.nav_item_header, parent, false);
			} else {
				view = inflater.inflate(R.layout.item_nav_list, null);
				TextView textView = (TextView) view
						.findViewById(R.id.txt_nav_title);
				textView.setText(menuItems.get(position).getTitle());

				if (position == 6) {
					View dividerView = (View) view
							.findViewById(R.id.view_divider);
					dividerView.setVisibility(View.VISIBLE);
				}
			}
		}

		return view;
	}

}
