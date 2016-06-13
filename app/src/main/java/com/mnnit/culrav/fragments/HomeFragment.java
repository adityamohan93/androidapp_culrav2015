package com.mnnit.culrav.fragments;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.mnnit.culrav.about.AboutActivity;
import com.mnnit.culrav.contacts.ContactActivity;
import com.mnnit.culrav.events.EventsActivity;
import com.mnnit.culrav.home.R;
import com.mnnit.culrav.main.HighActivity;
import com.mnnit.culrav.main.ImpActivity;

import java.util.Random;

//import com.mnnit.culrav.events.EventsActivity;

public class HomeFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {

    int[] photos = {R.drawable.raazmatazz, R.drawable.anu, R.drawable.loktarang,
            R.drawable.pic4, R.drawable.pic5, R.drawable.photo6};
    KenBurnsView imageView;
    ImageView newsfeed, events, nites, gallery, schedule, contactus, logo;
    private boolean isInFront;
    TextView title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.home_layout, container, false);

        imageView = (KenBurnsView) v.findViewById(R.id.kenBurns);
        newsfeed = (ImageView) v.findViewById(R.id.stream);
        events = (ImageView) v.findViewById(R.id.events);
        nites = (ImageView) v.findViewById(R.id.nites);
        gallery = (ImageView) v.findViewById(R.id.gallery);
        schedule = (ImageView) v.findViewById(R.id.schedule);
        contactus = (ImageView) v.findViewById(R.id.contact);
        title = (TextView) v.findViewById(R.id.nameBar);
        logo = (ImageView) v.findViewById(R.id.logo);

        newsfeed.setOnClickListener(this);
        events.setOnClickListener(this);
        nites.setOnClickListener(this);
        gallery.setOnClickListener(this);
        schedule.setOnClickListener(this);
        contactus.setOnClickListener(this);
        logo.setOnClickListener(this);

        newsfeed.setOnTouchListener(this);
        events.setOnTouchListener(this);
        schedule.setOnTouchListener(this);
        contactus.setOnTouchListener(this);

        //  imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setColorFilter(getResources().getColor(R.color.blue_transparent));


        // handler to change images after certain time
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                // change images randomly
                Random ran = new Random();
                int i = ran.nextInt(photos.length);

                // to avoid out of memory errors
                if (isInFront)
                    imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), photos[i]));
                Drawable oriDrawable = imageView.getDrawable();

                // set callback to null
                oriDrawable.setCallback(null);
                System.gc();

                i++;
                if (i > photos.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 7000); // for interval...
            }
        };
        handler.postDelayed(runnable, 7000); // for initial delay..

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stream:
                Intent i4 = new Intent(getActivity(), HighActivity.class);
                startActivity(i4);
                break;
            case R.id.events:
                Intent i = new Intent(getActivity(), EventsActivity.class);
                startActivity(i);
                break;
            case R.id.schedule:
                final Bundle extras = new Bundle();
                Intent i1 = new Intent(getActivity(), ImpActivity.class);
                extras.putInt("position", 2);
                i1.putExtras(extras);
                startActivity(i1);
                break;
            case R.id.contact:
                Intent i8 = new Intent(getActivity(), ContactActivity.class);
                startActivity(i8);
                break;
            case R.id.logo:
                Intent i2 = new Intent(getActivity(), AboutActivity.class);
                startActivity(i2);
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        isInFront = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isInFront = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN)
            switch (v.getId()) {
                case R.id.stream:
                    title.setText("HighLights");
                    break;
                case R.id.events:
                    title.setText("Events");
                    break;
                case R.id.contact:
                    title.setText("Contact");
                    break;
                case R.id.schedule:
                    title.setText("Schedule");
                    break;
            }
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            title.setText("Culrav 2015");
        }
        return false;
    }
}
