package com.niharikakhanna.app.quiz;

/**
 * Created by Khanna on 27/12/16.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class LogoAdapter extends BaseAdapter {
    private Context mContext;

    // Store all Image Res IDs in an array
    public Integer[] mThumbIds = QuestionDatabase.getImages();
    // Constructor
    public LogoAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(190, 190));
        return imageView;
    }

}
