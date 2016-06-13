package com.mnnit.culrav.home;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mnnit.culrav.fragments.HomeFragment;
import com.mnnit.culrav.fragments.MapsFragment;
import com.mnnit.culrav.util.Config;
import com.mnnit.culrav.util.FontsOverride;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mLiearLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        if (isGooglePlaySericesInstalled())
//            GCMIntentService.registerAtGCM(this);
        FontsOverride.setDefaultFont(getApplicationContext(), "MONOSPACE",
                "fonts/font.otf");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)

                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);

        mTitle = mDrawerTitle = getTitle();

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mLiearLayout = (LinearLayout) findViewById(R.id.drawer_view);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons
                .getResourceId(0, -1)));

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons
                .getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons
                .getResourceId(2, -1)));

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
                .getResourceId(3, -1)));
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons
//                .getResourceId(4, -1)));

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons
                .getResourceId(5, -1)));

        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                null, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);

                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);

                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {

            displayView(0);
        }


    }

    public boolean isGooglePlaySericesInstalled() {
        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(
                    "com.google.android.gsf", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                final int position, long id) {
            mDrawerLayout.closeDrawer(mLiearLayout);
            switch (position) {
                case 1:
                    openWebsite();
                    break;
                case 2:
                    openFb();
                    break;
                case 4:
                    showAbout();
                    break;
                default:
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            displayView(position);
                        }
                    }, 300);
                    break;
            }
        }
    }

    private void showAbout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View layoutView = inflater.inflate(R.layout.dialog_about, null);
        builder.setView(layoutView);
        final AlertDialog dialog = builder.create();
        dialog.show();

        TextView vivek = (TextView) layoutView
                .findViewById(R.id.dialog_person_vivek);
        vivek.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Uri number = Uri.parse("tel:7379398886");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        TextView vishal = (TextView) layoutView
                .findViewById(R.id.dialog_person_vishal);
        vishal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Uri number = Uri.parse("tel:8765081883");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

    }

    private void openWebsite() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(Config.WEB_PAGE));
        startActivity(Intent.createChooser(intent, "Load with"));
    }

    private void openFb() {
        final String urlFb = "fb://page/" + Config.FB_PAGE_CULARV_ID;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlFb));

        // If Facebook application is installed, use that else launch a browser
        final PackageManager packageManager = getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() == 0) {
            intent.setData(Uri.parse(Config.FB_PAGE_CULRAV));
            startActivity(Intent.createChooser(intent, "Load with"));
        } else {
            startActivity(intent);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    private void displayView(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 3:
                fragment = new MapsFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
        } else {

            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}