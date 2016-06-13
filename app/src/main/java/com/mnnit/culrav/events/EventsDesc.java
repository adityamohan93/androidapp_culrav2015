package com.mnnit.culrav.events;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mnnit.culrav.getInfo.GetDocu;
import com.mnnit.culrav.home.R;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class EventsDesc extends FragmentActivity implements MaterialTabListener {

    private String[] tabsItems = {"Events", "Contact"};
    GetDocu util;
    private ViewPager pager;
    CollectionPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_desc);
        Bundle extra = getIntent().getExtras();
        String eventName = extra.getString("name");
        util = new GetDocu(this, eventName);
        String[] subEvents = util.getSubEvents();
        String[] contactName = util.getcontactName();
        String[] eventDesr = util.getEventDesc();
        String[] phone = util.getPhone();
        String[] email = util.getEmail();
        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle(eventName);
        tb.setTitleTextColor(Color.WHITE);
        // init view pager
       Log.e("here", eventName/*+subEvents.length + " " + contactName.length + " " + phone.length + " " + email.length + " " + eventDesr.length*/);
        pagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager(), subEvents, contactName, phone, email, eventDesr,eventName);
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });

        // insert all tabs from pagerAdapter data
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setText(pagerAdapter.getPageTitle(i))
                            .setTabListener(this)
            );
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_events_desc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
