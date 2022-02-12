package com.mboutiquevb.utils;

import static android.content.Context.WIFI_SERVICE;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
    public static CustomProgress showProgressDialog(Context context) {
        CustomProgress customProgress = new CustomProgress();
        customProgress.showProgress(context);
        return customProgress;
    }

    public static void showSnackMessage(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public static String getDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");
        return simpleDateFormat.format(date);
    }

    public static Date getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }


    public static String getEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static void setEditTextError(String error, EditText editText) {
        editText.setError("" + error);
        editText.requestFocus();
    }

    public static void setEditTextError(String error, TextView textView) {
        textView.setError("" + error);
        textView.requestFocus();
    }

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static int getDialogWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ActivityUtils.getActivity(context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.widthPixels * 0.9);
    }

    public static int getDialogHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ActivityUtils.getActivity(context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.heightPixels * 0.8);
    }

    public static String getDeviceId(Context context) {
        return android.provider.Settings.System.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
    }

    public static String getIPAddress(Context context) {
        WifiManager wm = (WifiManager) context.getSystemService(WIFI_SERVICE);
        return Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
    }


    public static String getDeviceName() {
        return android.os.Build.MODEL;
    }


}
