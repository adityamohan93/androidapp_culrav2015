package com.mnnit.culrav.custom;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mnnit.culrav.home.R;

public class CustomListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    String[] name;
    String[] desr;
    int[] photo;
    int[] color;

    public CustomListAdapter(LayoutInflater inflater, int[] photo, String[] name, String[] desr, int[] color) {
        this.inflater = inflater;
        this.photo = photo;
        this.name = name;
        this.desr = desr;
        this.color = color;
    }

    @Override
    public int getCount() {
        return name.length;
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
            convertView = inflater.inflate(R.layout.item, null);
        ImageView iv = (ImageView) convertView.findViewById(R.id.event_image);
        iv.setBackgroundResource(photo[position]);
        TextView tv = (TextView) convertView.findViewById(R.id.event_name);
        tv.setText(name[position]);
        tv.setTextColor(Color.WHITE);
        TextView tv1 = (TextView) convertView.findViewById(R.id.event_descr);
        LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.lay);
        ll.setBackgroundColor(color[position]);
        tv1.setText(desr[position]);
        tv1.setTextSize(12);
        return convertView;
    }
}
