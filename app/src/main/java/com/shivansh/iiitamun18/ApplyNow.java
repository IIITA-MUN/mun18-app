package com.shivansh.iiitamun18;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ApplyNow extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        final String url = i.getStringExtra("LINK");

        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_apply_now);
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();


        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }

        myWebView = findViewById(R.id.webview);
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(url.equals("https://docs.google.com/forms/d/e/1FAIpQLSfHE_mLQEqx5JylrIu9mK6QtRBgPep39UoWKg6xLf1dN6i_AA/viewform?c=0&w=1")) {
                    if (progress == 100)
                        setTitle("Apply as Delegate");
                }
                else{
                    if (progress == 100)
                        setTitle("Apply as Executive Board");
                }
            }
        });
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setJavaScriptEnabled(true);

        myWebView.loadUrl(url);
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }

        //If no history, performs default app behaviour !
        return super.onKeyDown(keyCode, event);
    }

}
