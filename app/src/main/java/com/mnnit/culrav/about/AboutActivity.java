package com.mnnit.culrav.about;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mnnit.culrav.custom.AboutCustomListAdapter;
import com.mnnit.culrav.home.R;
import com.mnnit.culrav.util.Config;
import com.nirhart.parallaxscroll.views.ParallaxListView;

import java.util.List;

public class AboutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("About");
        tb.setTitleTextColor(Color.WHITE);
        String[] name = {"About Culrav", "Team Culrav", "MNNIT Workspace"};
        final String[] about = {"Culrav (Hindi: कलरव) is the cultural festival of Motilal Nehru National Institute of Technology, Allahabad. It is a 5 days long annual festival celebrated at national level in early week of April. Culrav gives a platform to the students of MNNIT and those all over India to participate in events which are diverse and exciting. It is one of the biggest inter college cultural festival of North India. Hemendu Sinha (1989 Batch) coined this name in 1987 and since then it has been continuing.", "Faculty Coordinators\n\tProf. P.Chakrabarti\n\tMr. Asim Mukherjee\n\tDr. Shivesh Sharma\nFestival Secretaries\n\tRajat Mishra\n\tParth Agarwal\n\tMayank Mital\n\tNavya Agarwal\n\tPallavi Mishra\n\tPinky Khedar"};
        int[] photo = {R.drawable.culrav, R.drawable.team, R.drawable.workspace};
        ParallaxListView listView = (ParallaxListView) findViewById(R.id.aboutlist);
        AboutCustomListAdapter adapter = new AboutCustomListAdapter(LayoutInflater.from(this), photo, name);
        listView.setAdapter(adapter);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_about_dtu);
        final TextView tv = (TextView) dialog.findViewById(R.id.aboutdetails);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        dialog.setTitle("About Culrav");
                        tv.setText(about[0]);
                        dialog.show();
                        break;
                    case 1:
                        dialog.setTitle("About Team");
                        tv.setText(about[1]);
                        dialog.show();
                        break;
                    case 2:
                        openFb();
                        break;
                }
            }
        });
    }

    private void openFb() {
        final String urlFb = "https://www.facebook.com/workspace.mnnit?fref=ts";
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }


}
