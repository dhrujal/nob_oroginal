package com.mboutiquevb.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtils {
    public static void showImageFromUrl(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void showImageFromLocale(Context context, int url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void showGIFImageFromLocale(Context context, int url, ImageView imageView) {
        Glide.with(context).asGif().load(url).into(imageView);
    }
}
