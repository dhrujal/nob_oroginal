package com.mboutiquevb.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;

import com.mboutiquevb.R;


public class CustomProgress {

    public static CustomProgress customProgress = null;
    private Dialog mDialog;

    public void showProgress(Context context) {
        mDialog = new Dialog(context);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_custom_progress);
        ImageView imageView = mDialog.findViewById(R.id.imgLoader);
        ImageUtils.showGIFImageFromLocale(context, R.drawable.loader3, imageView);
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    public boolean isShowing() {
        return mDialog.isShowing();
    }
}