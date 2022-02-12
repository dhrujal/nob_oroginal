package com.mboutiquevb.viewmodel;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.mboutiquevb.R;
import com.mboutiquevb.databinding.ActivityHomeBinding;
import com.mboutiquevb.fragment.CartFragment;
import com.mboutiquevb.fragment.CategoryFragment;
import com.mboutiquevb.fragment.HomeFragment;
import com.mboutiquevb.fragment.WishlistFragment;
import com.mboutiquevb.utils.ActivityUtils;


public class HomeViewModel {
    Context context;
    ActivityHomeBinding activityHomeBinding;


    public HomeViewModel(Context context, ActivityHomeBinding activityHomeBinding) {
        this.context = context;
        this.activityHomeBinding = activityHomeBinding;
//        setDrawer();
        onInit();
    }

//    public void onViewClick(View view) {
//        closeDrawer();
//        Fragment fragment = null;
//        switch (view.getId()) {
//
//        }
//        if (fragment != null) {
//            FragmentTransaction transaction = ActivityUtils.getActivity(context).getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.containerHome, fragment);
//            transaction.addToBackStack(null);
//            try {
//                transaction.commit();
//            } catch (Exception e) {
//                Log.e("exception", e.toString());
//            }
//        }
//    }

//    private void closeDrawer() {
//        if (activityHomeBinding.drawerLayout.isDrawerOpen(Gravity.START)) {
//            activityHomeBinding.drawerLayout.closeDrawer(Gravity.START);
//        }
//    }
//
//    public void setDrawer() {
//        String[] drawerList;
//
//        drawerList = context.getResources().getStringArray(R.array.drawer_array);
//        TypedArray drawerIcons = context.getResources().obtainTypedArray(R.array.drawer_icons);
//        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(context, drawerList, drawerIcons, new OnListClickListener() {
//            @Override
//            public void onViewClick(View view, int pos) {
//                drawerAction(view, pos);
//            }
//        });
//        activityHomeBinding.rcvDrawerMenu.setLayoutManager(ActivityUtils.getLayout(context, 1));
//        activityHomeBinding.rcvDrawerMenu.setAdapter(drawerListAdapter);
//    }
//
//    public void drawerAction(View view, int pos) {
//        closeDrawer();
//        Fragment fragment = null;
//        switch (pos) {
//            case 0:
//                ActivityUtils.startActivityWithFinishClear(context, HomeActivity.class);
//                break;
//            case 1:
//                fragment = new PostFragment();
//                break;
//            case 2:
//                fragment = new SearchFragment();
//                break;
//            case 3:
//                fragment = ProfileFragment.newInstance();
//                break;
//            case 4:
//                fragment = new MetrimonyFragment();
//                break;
//            case 5:
//                fragment = new ConveyorListFragment();
//                break;
//            case 6:
//                fragment = new AboutUsFragment();
//                break;
//            case 7:
//                fragment = new ContactUsFragment();
//                break;
//            case 8:
//                fragment = new FeedbackFragment();
//                break;
//            case 9:
//                Session.getInstance(context).logOut();
//                ActivityUtils.startActivityWithFinish(context, LoginActivity.class);
//                break;
//        }
//        if (fragment != null) {
//            FragmentTransaction transaction = ActivityUtils.getActivity(context).getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.containerHome, fragment);
//            transaction.addToBackStack(null);
//            try {
//                transaction.commit();
//            } catch (Exception e) {
//                Log.e("exception", e.toString());
//            }
//        }
//    }

    //    public void setData() {
//        if (Session.getInstance(context).isUserLogin()) {
//            ImageUtils.showImageFromUrl(context, Session.getInstance(context).getLoginData().getUser().getUserPhoto(), activityHomeBinding.profileImage);
//            activityHomeBinding.txtUserName.setText(Session.getInstance(context).getLoginData().getUser().getFullName());
//        }
//    }
//
    private void onInit() {
        //getAllUser();
        // getuser();


        Fragment fragment = null;
        fragment = new HomeFragment();
        if (fragment != null) {
            FragmentTransaction transaction = ActivityUtils.getActivity(context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.containerHome, fragment);
            transaction.addToBackStack(null);
            try {
                transaction.commit();
            } catch (Exception e) {
                Log.e("exception", e.toString());
            }
        }
        activityHomeBinding.tabLayoutHome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(context, R.color.purple_500);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                switchScreen(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(context, R.color.gray);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(context, R.color.purple_500);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                switchScreen(tab.getPosition());
            }
        });
        switchScreen(0);
        setDefaultColor();
        activityHomeBinding.tabLayoutHome.getTabAt(0).select();
    }
//
//
//    public void getAllUser() {
//        Call<AllUserResponseModel> data = RestClient.getInstance(context).getApiInterface().getAllUser();
//        data.enqueue(new RetrofitCallback<AllUserResponseModel>(context, Utility.showProgressDialog(context)) {
//
//            @Override
//            public void onSuccess(AllUserResponseModel allUserResponseModel) {
//                if (allUserResponseModel.getSuccess()) {
//                    AllUserResponseModel allUserResponseModel1 = allUserResponseModel;
//                    List<AllUserResponseModel.User> userList = allUserResponseModel.getUsers();
//                    activityHomeBinding.member.setText(String.valueOf(userList.size()));
//                    ArrayList<String> male = new ArrayList<String>();
//                    ArrayList<String> female = new ArrayList<String>();
//
//                    for (int i = 0; i < userList.size(); i++) {
//                        if (userList.get(i).getGender().equals("0")) {
//                            male.add(userList.get(i).getFullName());
//                        } else {
//                            female.add(userList.get(i).getFullName());
//                        }
//                    }
//                    activityHomeBinding.male.setText(String.valueOf(male.size()));
//                    activityHomeBinding.female.setText(String.valueOf(female.size()));
//                }
//            }
//
//            @Override
//            public void onError(AllUserResponseModel allUserResponseModel) {
//
//            }
//
//        });
    //  }

    private void switchScreen(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CategoryFragment();
                break;
            case 2:
                fragment = new WishlistFragment();
                break;
            case 3:
                fragment = new CartFragment();
                break;
            default:
                break;
        }
        if (fragment != null) {
            FragmentTransaction transaction = ActivityUtils.getActivity(context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.containerHome, fragment);
            transaction.addToBackStack(null);
            try {
                transaction.commit();
            } catch (Exception e) {
                Log.e("exception", e.toString());
            }
        }

    }

    private void setDefaultColor() {
        int tabIconColor = ContextCompat.getColor(context, R.color.gray);
        for (int i = 1; i < 4; i++) {
            activityHomeBinding.tabLayoutHome.getTabAt(i).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        }
    }
}
