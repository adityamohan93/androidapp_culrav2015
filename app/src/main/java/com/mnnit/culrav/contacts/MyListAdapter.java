/*
 * Copyright 2014 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mnnit.culrav.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mnnit.culrav.home.R;

public class MyListAdapter extends ArrayAdapter<String> implements UndoAdapter, StickyListHeadersAdapter {

    private final Context mContext;
    LayoutInflater inflater;
    private final String[] name;
    private final String[] email;
    private final String[] phone;

    public MyListAdapter(final Context context, LayoutInflater a, String[] name, String[] email, String[] phone) {
        mContext = context;
        inflater = a;
        this.name = name;
        this.email = email;
        this.phone = phone;
        for (int i = 0; i < 30; i++)
            add(mContext.getString(R.string.row_number, i));
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
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

    @NonNull
    @Override
    public View getUndoView(final int position, View convertView, @NonNull final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.undo_row, parent, false);
        }
        return view;
    }

    @NonNull
    @Override
    public View getUndoClickView(@NonNull final View view) {
        return view.findViewById(R.id.undo_row_undobutton);
    }

    @Override
    public View getHeaderView(final int position, final View convertView, final ViewGroup parent) {
        TextView view = (TextView) convertView;
        if (view == null) {
            view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.list_header, parent, false);
        }

        view.setText(getTitle(position));

        return view;
    }

    private String getTitle(int position) {
        if (position >= 0 && position < 6)
            return "Festival Secretary";
        else if (position >= 6 && position < 29)
            return "Public Relation Secretary";
        else
            return "Design Team";
    }

    @Override
    public long getHeaderId(final int position) {

        if (position >= 0 && position < 6)
            return 0;
        else if (position >= 6 && position < 29)
            return 1;
        else
            return 2;
    }
}