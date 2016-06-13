package com.mnnit.culrav.util;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Vishal Raj on 3/16/2015.
 */
public class ListAda extends BaseAdapter {
    final LayoutInflater infalter;
    private int[] photo;


    public ListAda(Activity c, int[] photo) {
        this.infalter = c.getLayoutInflater();
        this.photo = photo;
    }

    @Override
    public int getCount() {
        return photo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null)
//            convertView = infalter.inflate(R.layout.event_card, null);
//
//        ImageView iv = (ImageView) convertView.findViewById(R.id.icon);
//        iv.setBackgroundResource(photo[position]);
        return convertView;
    }
}
