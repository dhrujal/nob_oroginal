package com.mboutiquevb.viewmodel;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mboutiquevb.databinding.FragmentHomeBinding;
import com.onesignal.OneSignal;

public class FragmentHomeViewModel {
    private static final String ONESIGNAL_APP_ID = "1aecd410-b147-47ba-9df8-ee4801d22a29";
    FragmentHomeBinding fragmentHomeBinding;
    Context context;


    public FragmentHomeViewModel(FragmentHomeBinding fragmentHomeBinding, Context context) {
        this.fragmentHomeBinding = fragmentHomeBinding;
        this.context = context;
        onInit();

    }

    public void onInit() {


        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(context);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        //  OneSignal.setNotificationOpenedHandler(new NotificationHandler(mContext));

        // Use One Signal User ID
        String token = OneSignal.getDeviceState().getUserId();
        Log.e("device Token", "" + OneSignal.getDeviceState().getUserId());

        // mywebview.loadUrl("https://waffletownrest.com/entrada-2-app/");

        String url = "https://mboutiquevb.com/".trim();

        fragmentHomeBinding.webView.getSettings().setLoadsImagesAutomatically(true);
        fragmentHomeBinding.webView.getSettings().setJavaScriptEnabled(true);
        fragmentHomeBinding.webView.getSettings().setSupportMultipleWindows(true);
        fragmentHomeBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        fragmentHomeBinding.webView.getSettings().setLoadWithOverviewMode(true);
        fragmentHomeBinding.webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragmentHomeBinding.webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        fragmentHomeBinding.webView.loadUrl(url);
        fragmentHomeBinding.webView.setWebViewClient(new WebViewClient() {


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                fragmentHomeBinding.progressBar1.setVisibility(View.GONE);
            }
        });

    }
}
