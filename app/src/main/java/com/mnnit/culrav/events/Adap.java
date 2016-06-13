package com.mnnit.culrav.events;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mnnit.culrav.home.R;

/**
 * Created by Vishal Raj on 3/26/2015.
 */
public class Adap extends BaseAdapter {
    private final Context mContext;
    LayoutInflater inflater;
    private final String[] name;
    private final String[] email;
    private final String[] phone;

    public Adap(final Context context, LayoutInflater a, String[] name, String[] email, String[] phone) {
        mContext = context;
        inflater = a;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
        TextView n = (TextView) convertView.findViewById(R.id.frag_events_contact_name);
        ImageView b = (ImageView) convertView.findViewById(R.id.frag_events_contact_mobile);
        ImageView m = (ImageView) convertView.findViewById(R.id.frag_events_contact_email);
        n.setText(name[position]);
        if (phone[position].equals("")) {
            b.setVisibility(View.GONE);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:" + phone[position]);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                mContext.startActivity(callIntent);
            }
        });
        if (email[position].equals("")) {
            m.setVisibility(View.GONE);
        } else {
            final int pos = position;
            m.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String url = "mailto:" + email[pos];
                    Intent mailIntent = new Intent(Intent.ACTION_SENDTO, Uri
                            .parse(url));
                    mContext.startActivity(Intent.createChooser(mailIntent,
                            "Open email..."));
                }
            });
        }

        return convertView;
    }
}
