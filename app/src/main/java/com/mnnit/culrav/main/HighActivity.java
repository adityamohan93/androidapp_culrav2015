package com.mnnit.culrav.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mnnit.culrav.custom.AboutCustomListAdapter;
import com.mnnit.culrav.home.R;
import com.nirhart.parallaxscroll.views.ParallaxListView;

public class HighActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("HighLights");
        tb.setTitleTextColor(Color.WHITE);
        final String[] name = {"Kavya Sandhya", "Campus Princess", "Gno Talks", "Treasure Hunt"};
        int[] photo = {R.drawable.kavyash, R.drawable.princess, R.drawable.gnotalks, R.drawable.treasure};
        ParallaxListView listView = (ParallaxListView) findViewById(R.id.aboutlist);
        AboutCustomListAdapter adapter = new AboutCustomListAdapter(LayoutInflater.from(this), photo, name);
        listView.setAdapter(adapter);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_about_dtu);
        final TextView tv = (TextView) dialog.findViewById(R.id.aboutdetails);
        final Bundle extras = new Bundle();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(HighActivity.this, ImpActivity.class);
                        extras.putInt("position", 0);
                        i.putExtras(extras);
                        startActivity(i);
                        break;
                    case 1:
                        dialog.setTitle("Campus Princess");
                        tv.setText(Html.fromHtml("<center><b>CAMPUS PRINCESS AUDITIONS</b><br/> The Road To Miss Diva Universe.</center> <br/> <p>This Culrav experience glamour at its zenith.</p> <p>With a vision to establish an interface with the student community, Campus Princess institutes a talent platform scheduled during the Culrav 2015.</p><p>Campus Princess is a breeding ground for scouting young talent which helps them realizing their dream of becoming a beauty queen.</p> <p><b>Highlights : </b><p> <ul style=\"list-style-type:circle\"> <li><p>1. Win a direct entry to the <b>Final Round of Miss Diva Universe 2015 Auditions</b> in Mumbai.</p></li> <li><p>2. Get a chance to be a part of the <b>Exclusive Miss India Organization Grooming School</b> and get trained by the best names in the Fashion and Glamour Industry.</p></li> <li><p>3. Get featured on <b><a href=\"http://www.missindia.in/\" target=\"_blank\">www.missindia.in</a></b></p><li> </ul> </p> <p>Check out : <a href=\"https://www.facebook.com/campusprincess\"><b>Campus Princess on FB</b></a></p> <p>So this Culrav, here's a chance to walk along the Road to Miss Diva Universe with former Miss India as one of the judges.</p> </div> </div> <div class=\"mb_content\"> <h2>Eligibility</h2> <div class=\"mb_content_inner\"> <ul style=\"list-style-type:circle\"> <li><p>1. <b>Profile</b> : The applicant needs to be a student of a recognized educational institution.</p></li> <li><p>2. <b>Nationality</b> : Indian Passport Holder .</p></li> <li><p>3. <b>Age</b> : 18-27.</p></li> <li><p>4. <b>Relationship Status</b> : Single/Unmarried.</p></li> <li><p>5. <b>Dress Code</b> : Black cocktail dress and stilettos.</p></li> <li><p>6. <b>Height</b> : 5'5 and above (Without heels).</p></li> </ul> </div> </div> <div class=\"mb_content\"> <h2></h2> <p>Do you want to be the next Lara Dutta or Sushmita Sen? This is your chance of a lifetime to be the next Miss Diva Universe.</p> <br/> <br/><center><h3><a href=\".//index.php\" target=\"_blank\" style=\"text-decoration:none; font-family:Arial, Helvetica, sans-serif; color:#939\" ></a></h3></center> </div> <div class=\"mb_content\"> <h2>Selfie Contest</h2> <div class=\"mb_content_inner\"> <p>Before walking down the ramp on the D-day, let's just take a Selfie.</p> <p>Any girl who fits the Eligibility Criteria under Campus Princess Auditions can participate in this Selfie Contest and win exciting gift hampers and get clicked with Miss Asia Pacific World India 2014 Anukriti Gusain.</p> <p>Mail us your selfie to <b>spandan.culrav@gmail.com</b> with your name and contact no and subject as \"Selfie Contest\". Your Selfie will be uploaded on <a href=\"https://www.facebook.com/mnnit.culrav\" target=\"_blank\">Culrav's FB Page </a>and the winner will be decided on the basis of number of likes and opinion of the Miss Asia Pacific World India 2014.</p> </div> </div><h2>Contact</h2> <div class=\"mb_content_inner\"> <ul> <li>Darshita Ojha <br/>darshita.ojha@gmail.com<br/><br/></li> <li>Navneet Shah : 9198729698<br/> nav.sagittarius@gmail.com<br/><br/></li> <li>Rupal Jain <br/>jrupal.18@gmail.com<br/><br/></li> <li>Diptanshu Singh : 7607319363 <br/> diptanshu2003@gmail.com<br/><br/></li> <li>Malvika Pandey <br/> malvika.hp@gmail.com<br/><br/></li> <li>Ajay Rai : 7309499232 <br/> ajay.rai815393@gmail.com<br/><br/></li> <li>Himeshwar Sharma : 7897196063<br/> hsharma28071992@gmail.com<br/><br/></li> <li>Jai Prakash Meena : 7388312559<br/> jai16.meena@gmail.com<br/><br/></li> <li>Sushant Gupta : 9455171314<br/> sushant0625@gmail.com<br/><br/></li> <li>Ankita Mishra <br/>ankitamishra1694@gmail.com<br/><br/></li> </ul> </div> </div> "));
                        dialog.show();
                        break;
                    case 2:
                        Intent i1 = new Intent(HighActivity.this, ImpActivity.class);
                        extras.putInt("position", 1);
                        i1.putExtras(extras);
                        startActivity(i1);
                        break;
                    case 3:
                        Intent i2 = new Intent(HighActivity.this, WebActivity.class);
                        extras.putString("web", "http://culrav.in/hunt");
                        extras.putString("name", name[3]);
                        i2.putExtras(extras);
                        startActivity(i2);
                        break;
                    case 4:
                        Intent i3 = new Intent(HighActivity.this, WebActivity.class);
                        extras.putString("web", "http://culrav.in/stream");
                        extras.putString("name", name[4]);
                        i3.putExtras(extras);
                        startActivity(i3);
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high, menu);
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
}
