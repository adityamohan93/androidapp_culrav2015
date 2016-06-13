package com.mnnit.culrav.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mnnit.culrav.home.R;

public class AboutCustomListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    String[] name;
    int[] photo;


    public AboutCustomListAdapter(LayoutInflater inflater, int[] photo, String[] name) {
        this.inflater = inflater;
        this.photo = photo;
        this.name = name;

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
        if (convertView == null)
            convertView = inflater.inflate(R.layout.about_list, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.about_image);
        TextView tv = (TextView) convertView.findViewById(R.id.about_name);
        iv.setBackgroundResource(photo[position]);
        tv.setText(name[position]);


        return convertView;
    }
}
