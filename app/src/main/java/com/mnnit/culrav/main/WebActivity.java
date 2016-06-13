package com.mnnit.culrav.main;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mnnit.culrav.home.R;

public class WebActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Bundle extra = getIntent().getExtras();
        String position = extra.getString("web");
        String name = extra.getString("name");
        WebView mWebview = (WebView) findViewById(R.id.webView);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final ActionBarActivity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        mWebview.loadUrl(position);

    }


}
