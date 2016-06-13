package com.mnnit.culrav.events;


import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.mnnit.culrav.custom.AlphaForegroundColorSpan;
import com.mnnit.culrav.custom.CustomListAdapter;
import com.mnnit.culrav.home.R;
import com.mnnit.culrav.main.WebActivity;
import com.nirhart.parallaxscroll.views.ParallaxListView;


public class EventsActivity extends ActionBarActivity {

    private int mActionBarTitleColor;
    private int mActionBarHeight;
    private int mHeaderHeight;
    private int mMinHeaderTranslation;
    private ParallaxListView mListView;
    private ImageView mHeaderLogo;
    private View mHeader;
    private KenBurnsView mHeaderPicture;
    private View mPlaceHolderView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();

    private AlphaForegroundColorSpan mAlphaForegroundColorSpan;
    private SpannableString mSpannableString;

    private TypedValue mTypedValue = new TypedValue();
    private boolean isInFront;
    KenBurnsView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
        mMinHeaderTranslation = -mHeaderHeight + getActionBarHeight();
        setContentView(R.layout.activity_splash);
        mListView = (ParallaxListView) findViewById(R.id.listview1);
        mHeader = findViewById(R.id.header1);
        mHeaderPicture = (KenBurnsView) findViewById(R.id.header_picture1);
        mActionBarTitleColor = getResources().getColor(R.color.actionbar_title_color);
        mSpannableString = new SpannableString(getString(R.string.app_name));
        mAlphaForegroundColorSpan = new AlphaForegroundColorSpan(mActionBarTitleColor);
        imageView = (KenBurnsView) findViewById(R.id.header_picture1);

        setupActionBar();
        setupListView();
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

    private void setupListView() {
        int[] photo = {R.drawable.anu, R.drawable.darkroom, R.drawable.literati, R.drawable.loktarang, R.drawable.natyamanch, R.drawable.raazmatazz, R.drawable.rangsaazi, R.drawable.spandan, R.drawable.shristi, R.drawable.treasure};
        final String[] name = {"Anunaad", "Darkroom", "Literati", "Loktarang", "Natyamanch", "Razzmatazz", "RangSaazi", "Spandan", "Srishti", "Informals"};
        String[] decr = {"Music gives a soul to the universe, wings to the mind, flight to the imagination and life to everything.", "Capture some photos, make some video...this Culrav, make some moments immortal in your darkroom.", "Literature is the most agreeable way of ignoring life.", "The genuine roots of culture is folk dance.", "Acting means living, it's all I do and all I'm good at.If I weren't getting paid well, I would still be acting in a small troupe somewhere.", "I keep on dancing....and dancing....and dancing,...until there is only.....The Dance", "Every child is an artist. The problem is how to remain an artist when he grows up.", "Fashion is not something that exists in dresses only. Fashion is in the sky, in the street, fashion has tto do with ideas, the way we live, what is happening.", "A nation is dumb without a national language.", " "};
        Resources r = getResources();
        int[] colr = {r.getColor(R.color.accent_material_dark), r.getColor(R.color.pink_transparent), r.getColor(R.color.green_transparent), r.getColor(R.color.holo_red_light_transparent), r.getColor(R.color.purple_transparent), r.getColor(R.color.red_transparent), r.getColor(R.color.contact_color), r.getColor(R.color.nites_color), r.getColor(R.color.blue_transparent), r.getColor(R.color.holo_red_light)};
        mPlaceHolderView = getLayoutInflater().inflate(R.layout.view_header_placeholder, mListView, false);
        mListView.addHeaderView(mPlaceHolderView);
        CustomListAdapter adapter = new CustomListAdapter(LayoutInflater.from(this), photo, name, decr, colr);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(EventsActivity.this, EventsDesc.class);
                Bundle extras = new Bundle();
                try {
                    switch (position) {
                        case 10:
                            Intent i2 = new Intent(EventsActivity.this, WebActivity.class);
                            extras.putString("web", "http://culrav.in/hunt");
                            extras.putString("name", name[3]);
                            i2.putExtras(extras);
                            startActivity(i2);
                            break;
                        default:
                            extras.putInt("position", position - 1);
                            extras.putString("name", name[position - 1]);
                            i.putExtras(extras);
                            startActivity(i);
                            break;
                    }
                } catch (Exception e) {

                }
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int scrollY = getScrollY();
                //sticky actionbar
                mHeader.setTranslationY(Math.max(-scrollY, mMinHeaderTranslation));
                float ratio = clamp(mHeader.getTranslationY() / mMinHeaderTranslation, 0.0f, 1.0f);
                setTitleAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
            }
        });
    }

    private void setTitleAlpha(float alpha) {
        mAlphaForegroundColorSpan.setAlpha(alpha);
        mSpannableString.setSpan(mAlphaForegroundColorSpan, 0, mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        getActionBar().setTitle(mSpannableString);
    }

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(value, max));
    }

    public int getScrollY() {
        View c = mListView.getChildAt(0);
        if (c == null) {
            return 0;
        }

        int firstVisiblePosition = mListView.getFirstVisiblePosition();
        int top = c.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mPlaceHolderView.getHeight();
        }

        return -top + firstVisiblePosition * c.getHeight() + headerHeight;
    }

    private void setupActionBar() {
        ActionBar actionBar = getActionBar();
    }

    private ImageView getActionBarIconView() {
        return (ImageView) findViewById(android.R.id.home);
    }


    public int getActionBarHeight() {
        if (mActionBarHeight != 0) {
            return mActionBarHeight;
        }
        getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue, true);
        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, getResources().getDisplayMetrics());
        return mActionBarHeight;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_settings:
                // Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                // startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void setTitle(CharSequence title) {

        getSupportActionBar().setTitle(title);
    }

}



