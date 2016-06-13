package com.mnnit.culrav.events;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mnnit.culrav.home.R;


@SuppressLint("ValidFragment")
public class Fragments extends Fragment {

    private String tab;
    private int color;
    ListView lv1;

    String[] subEvents;
    String[] contactName;
    String[] eventDesc;
    String[] phone;
    String[] email;
    String event;
    int pos;

    @SuppressLint("ValidFragment")
    public Fragments(String[] subEvents, String[] contact, String[] phone, String[] email, String[] eventDesr, int num, String evnt) {
        this.subEvents = subEvents;
        this.contactName = contact;
        this.eventDesc = eventDesr;
        this.phone = phone;
        this.email = email;
        pos = num;
        event = evnt;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        View view = null;
        view = inflater.inflate(R.layout.tab1, container, false);
        lv1 = (ListView) view.findViewById(R.id.list1);
        if (pos == 0) {
            lv1.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, subEvents));
            final Dialog dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.dialog_about_dtu);
            final TextView tv = (TextView) dialog.findViewById(R.id.aboutdetails);
            System.getProperty("line.separator");
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.setTitle(subEvents[position]);
                    tv.setText(Html.fromHtml(eventDesc[position]));
                    dialog.show();
                }
            });
        } else {
            Adap adapter = new Adap(getActivity(), LayoutInflater.from(getActivity()), contactName, email, phone);
            lv1.setAdapter(adapter);
        }
        return view;
    }
}
