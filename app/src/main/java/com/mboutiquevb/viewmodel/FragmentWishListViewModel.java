package com.mboutiquevb.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mboutiquevb.databinding.FragmentWishlistBinding;


public class FragmentWishListViewModel {
    FragmentWishlistBinding fragmentWishlistBinding;
    Context context;

    public FragmentWishListViewModel(FragmentWishlistBinding fragmentWishlistBinding, Context context) {
        this.fragmentWishlistBinding = fragmentWishlistBinding;
        this.context = context;
        onInit();
    }

    public void onInit() {

        // mywebview.loadUrl("https://waffletownrest.com/entrada-2-app/");

        String url = "https://mboutiquevb.com/wishlist/".trim();


        fragmentWishlistBinding.webView.getSettings().setLoadsImagesAutomatically(true);
        fragmentWishlistBinding.webView.getSettings().setJavaScriptEnabled(true);
        fragmentWishlistBinding.webView.getSettings().setSupportMultipleWindows(true);
        fragmentWishlistBinding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        fragmentWishlistBinding.webView.getSettings().setLoadWithOverviewMode(true);
        fragmentWishlistBinding.webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragmentWishlistBinding.webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        fragmentWishlistBinding.webView.loadUrl(url);
        fragmentWishlistBinding.webView.setWebViewClient(new WebViewClient() {
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
                fragmentWishlistBinding.progressBar1.setVisibility(View.GONE);
            }
        });

    }
}
