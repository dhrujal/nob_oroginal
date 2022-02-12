package com.mboutiquevb.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mboutiquevb.databinding.FragmentCartBinding;


public class FragmentCartViewModel {
    FragmentCartBinding fragmentCartBinding;
    Context context;

    public FragmentCartViewModel(FragmentCartBinding fragmentCartBinding, Context context) {
        this.fragmentCartBinding = fragmentCartBinding;
        this.context = context;
        onInit();
    }

    public void onInit() {

        // mywebview.loadUrl("https://waffletownrest.com/entrada-2-app/");

        String url = "https://mboutiquevb.com/cart-2/".trim();

        fragmentCartBinding.webView.getSettings().setLoadsImagesAutomatically(true);
        fragmentCartBinding.webView.getSettings().setJavaScriptEnabled(true);
        fragmentCartBinding.webView.getSettings().setSupportMultipleWindows(true);
        fragmentCartBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        fragmentCartBinding.webView.getSettings().setLoadWithOverviewMode(true);
        fragmentCartBinding.webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragmentCartBinding.webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        fragmentCartBinding.webView.loadUrl(url);
        fragmentCartBinding.webView.setWebViewClient(new WebViewClient() {
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
                fragmentCartBinding.progressBar1.setVisibility(View.GONE);
            }
        });

    }
}
