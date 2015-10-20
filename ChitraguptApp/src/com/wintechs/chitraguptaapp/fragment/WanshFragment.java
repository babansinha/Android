package com.wintechs.chitraguptaapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.wintech.chitraguptapp.R;

public class WanshFragment extends BaseFragment {
	private View view;

	private Integer[] imageIDs = { R.drawable.chitragupta, R.drawable.chitragupt_vanshavali, R.drawable.chitragupta };
	private Gallery gallery;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.wansh, null);
		initViews();
		initValues();
		initListeners();
		return view;
	}

	@Override
	public void initViews() {
		gallery = (Gallery) view.findViewById(R.id.gallery_wansh);
		MarginLayoutParams mlp = (MarginLayoutParams) gallery.getLayoutParams();
		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
		// mlp.setMargins((int) -(metrics.widthPixels / 2 + gallery.getWidth()),
		// mlp.topMargin, mlp.rightMargin, mlp.bottomMargin);
		ImageAdapter adapter = new ImageAdapter(getActivity());
		gallery.setAdapter(adapter);

	}

	@Override
	public void initValues() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;
		private int itemBackground;

		public ImageAdapter(Context c) {
			context = c;
			// sets a grey background; wraps around the images
			// TypedArray a = obtainStyledAttributes(R.styleable.MyGallery);
			// itemBackground =
			// a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground,
			// 0);
			// a.recycle();
		}

		// returns the number of images
		public int getCount() {
			return imageIDs.length;
		}

		// returns the ID of an item
		public Object getItem(int position) {
			return position;
		}

		// returns the ID of an item
		public long getItemId(int position) {
			return position;
		}

		// returns an ImageView view
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(context);
			imageView.setImageResource(imageIDs[position]);
			imageView.setPadding(20, 0, 20, 0);
			imageView.setScaleType(ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(gallery.getWidth() - 10, gallery.getHeight() - 10));
			imageView.setBackgroundResource(itemBackground);
			return imageView;
		}
	}

}
