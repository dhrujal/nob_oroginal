package com.mboutiquevb.utils;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mboutiquevb.R;
import com.mboutiquevb.activity.HomeActivity;


public class ActivityUtils {
    public static final String PARCEL_DATA = "PARCEL_DATA";

    public static void startActivity(Context context, Class activityClass) {
        context.startActivity(new Intent(context, activityClass));
        startAnimation(context);
    }


    //

    //
    public static void startActivityWithFinish(Context context, Class activityClass) {
        context.startActivity(new Intent(context, activityClass));
        getActivity(context).finish();
        startAnimation(context);
    }

    public static void startActivityWithFinishClear(Context context, Class activityClass) {
        Intent intent = new Intent(context, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        getActivity(context).finish();
        startAnimation(context);
    }

    public static AppCompatActivity getActivity(Context context) {
        return ((AppCompatActivity) context);
    }


    public static AppCompatActivity getHomeActivity(Context context) {
        return ((AppCompatActivity) context);
    }

    public static void openDrawer(Context context) {
        ((HomeActivity) context).openDrawer();
    }

    public static RecyclerView.LayoutManager getLayout(Context context, int i) {
        return new LinearLayoutManager(context, i, false);
    }

    public static RecyclerView.LayoutManager getHorizontalLayout(Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true);
    }

    public static RecyclerView.LayoutManager getGridLayout(Context context, int count) {
        return new GridLayoutManager(context, count);
    }

    public static void startAnimation(Context context) {
        ActivityUtils.getActivity(context).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public static void finishAnimation(Context context) {
        ActivityUtils.getActivity(context).overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

}
