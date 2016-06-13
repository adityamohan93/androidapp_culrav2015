package com.mnnit.culrav.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import com.mnnit.culrav.custom.AboutCustomListAdapter;
import com.mnnit.culrav.home.R;
import com.nirhart.parallaxscroll.views.ParallaxListView;

public class ImpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Bundle extra = getIntent().getExtras();
        int position = extra.getInt("position");
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        String[] name = {"", "", ""};
        int[] photo;
        if (position == 0) {
            tb.setTitle("Kavya Sandhya");
            int[] phot = {R.drawable.kavya1, R.drawable.kavya2, R.drawable.kavya3};
            photo = phot;
        } else if (position == 1) {
            tb.setTitle("Gno Talks");
            int[] phot = {R.drawable.gno1, R.drawable.gno2, R.drawable.gno3};
            photo = phot;
        } else {
            tb.setTitle("Schedule");
            int[] phot = {R.drawable.day1, R.drawable.day2, R.drawable.day3, R.drawable.day4};
            String[] n = {"", "", "", ""};
            name = n;
            photo = phot;
        }
        tb.setTitleTextColor(Color.WHITE);
        ParallaxListView listView = (ParallaxListView) findViewById(R.id.aboutlist);
        AboutCustomListAdapter adapter = new AboutCustomListAdapter(LayoutInflater.from(this), photo, name);
        listView.setAdapter(adapter);
    }


}
