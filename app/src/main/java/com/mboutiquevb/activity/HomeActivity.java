package com.mboutiquevb.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.mboutiquevb.R;
import com.mboutiquevb.databinding.ActivityHomeBinding;
import com.mboutiquevb.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    public static final int REQUEST_PERMISSION_ALL = 1;
    private static final int PERMISSION_REQUEST_CODE = 200;
    HomeViewModel homeViewModel;
    ActivityHomeBinding activityHomeBinding;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = HomeActivity.this;
        Window window = HomeActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.black));
        }
        activityHomeBinding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
        homeViewModel = new HomeViewModel(mContext, activityHomeBinding);
        activityHomeBinding.setVm(homeViewModel);


    }

    public void openDrawer() {
        if (activityHomeBinding.drawerLayout.isDrawerOpen(Gravity.START)) {
            activityHomeBinding.drawerLayout.closeDrawer(Gravity.START);
        } else {
            activityHomeBinding.drawerLayout.openDrawer(Gravity.START);
            // homeViewModel.setData();
        }
    }


    @Override
    public void onBackPressed() {
        int fragments = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments == 1) {
            finish();
        } else {
            if (getFragmentManager().getBackStackEntryCount() > 1) {
                getFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

}