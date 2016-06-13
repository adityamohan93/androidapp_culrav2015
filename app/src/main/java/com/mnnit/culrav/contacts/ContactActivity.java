package com.mnnit.culrav.contacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.mnnit.culrav.home.R;
import com.mnnit.culrav.util.ContactDetails;

public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contact);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("Contact");
        tb.setTitleTextColor(Color.WHITE);

        StickyListHeadersListView listView = (StickyListHeadersListView) findViewById(R.id.activity_stickylistheaders_listview);
        listView.setFitsSystemWindows(true);
        ContactDetails cd = new ContactDetails();

        MyListAdapter adapter = new MyListAdapter(this, LayoutInflater.from(this), cd.getName(), cd.getMails(), cd.getPhone());
        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        StickyListHeadersAdapterDecorator stickyListHeadersAdapterDecorator = new StickyListHeadersAdapterDecorator(animationAdapter);
        stickyListHeadersAdapterDecorator.setListViewWrapper(new StickyListHeadersListViewWrapper(listView));

        assert animationAdapter.getViewAnimator() != null;
        animationAdapter.getViewAnimator().setInitialDelayMillis(500);

        assert stickyListHeadersAdapterDecorator.getViewAnimator() != null;
        stickyListHeadersAdapterDecorator.getViewAnimator().setInitialDelayMillis(500);

        listView.setAdapter(stickyListHeadersAdapterDecorator);
    }
}
