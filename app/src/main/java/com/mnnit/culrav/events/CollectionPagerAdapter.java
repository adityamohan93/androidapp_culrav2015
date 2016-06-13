package com.mnnit.culrav.events;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

    String[] subEvents;
    String[] contactName;
    String[] eventDesc;
    String[] phone;
    String[] email;
    String event;

    public CollectionPagerAdapter(FragmentManager fm, String[] subEvents, String[] contact, String[] phone, String[] email, String[] eventDesr, String en) {
        super(fm);
        this.subEvents = subEvents;
        this.contactName = contact;
        this.eventDesc = eventDesr;
        this.phone = phone;
        this.email = email;
        event = en;
    }


    public Fragment getItem(int num) {
        return new Fragments(subEvents, contactName, phone, email, eventDesc, num, event);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Events";
        }
        return "Contacts";
    }
}

