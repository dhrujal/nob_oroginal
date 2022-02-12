package com.mboutiquevb.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mboutiquevb.databinding.FragmentCategoryBinding;

public class FragmentCategoryViewModel {
    FragmentCategoryBinding fragmentCategoryBinding;
    Context context;

    public FragmentCategoryViewModel(FragmentCategoryBinding fragmentCategoryBinding, Context context) {
        this.fragmentCategoryBinding = fragmentCategoryBinding;
        this.context = context;
        onInit();
    }

    public void onInit() {

        // mywebview.loadUrl("https://waffletownrest.com/entrada-2-app/");

        String url = "https://mboutiquevb.com/shop-2/".trim();

        fragmentCategoryBinding.webView.getSettings().setLoadsImagesAutomatically(true);
        fragmentCategoryBinding.webView.getSettings().setJavaScriptEnabled(true);
        fragmentCategoryBinding.webView.getSettings().setSupportMultipleWindows(true);
        fragmentCategoryBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        fragmentCategoryBinding.webView.getSettings().setLoadWithOverviewMode(true);
        fragmentCategoryBinding.webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragmentCategoryBinding.webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        fragmentCategoryBinding.webView.loadUrl(url);
        fragmentCategoryBinding.webView.setWebViewClient(new WebViewClient() {
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
                fragmentCategoryBinding.progressBar1.setVisibility(View.GONE);
            }
        });

    }
}
