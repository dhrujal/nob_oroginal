
package com.btforher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.onesignal.OneSignal;


public class WebViewActivity extends AppCompatActivity {
WebView mywebview;
    private static final String ONESIGNAL_APP_ID = "53293859-98c5-404a-8a7f-8274846edcfb";

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

        String url = "https://btforher.com/".trim();

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