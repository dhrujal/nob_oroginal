package com.mboutique;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.onesignal.OneSignal;


public class WebViewActivity extends AppCompatActivity {
    WebView mywebview;
    private static final String ONESIGNAL_APP_ID = "1aecd410-b147-47ba-9df8-ee4801d22a29";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        Window window = WebViewActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(WebViewActivity.this, R.color.black));
        }
        mywebview = (WebView) findViewById(R.id.webView);
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
      //  OneSignal.setNotificationOpenedHandler(new NotificationHandler(mContext));

        // Use One Signal User ID
        String token = OneSignal.getDeviceState().getUserId();
        Log.e("device Token", "" + OneSignal.getDeviceState().getUserId());

        // mywebview.loadUrl("https://waffletownrest.com/entrada-2-app/");

        String url = "https://mboutiquevb.com/".trim();

        mywebview.getSettings().setLoadsImagesAutomatically(true);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setSupportMultipleWindows(true);
        mywebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mywebview.loadUrl(url);
        mywebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mywebview.isFocused() && mywebview.canGoBack()) {
            mywebview.goBack();
        } else {
            super.onBackPressed();
        }
    }

}