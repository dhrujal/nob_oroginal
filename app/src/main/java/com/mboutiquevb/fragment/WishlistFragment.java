package com.mboutiquevb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mboutiquevb.R;
import com.mboutiquevb.databinding.FragmentWishlistBinding;
import com.mboutiquevb.viewmodel.FragmentWishListViewModel;

public class WishlistFragment extends Fragment {
    FragmentWishlistBinding fragmentWishlistBinding;
    FragmentWishListViewModel fragmentWishListViewModel;

    public WishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentWishlistBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_wishlist, container, false);
        fragmentWishListViewModel = new FragmentWishListViewModel(fragmentWishlistBinding, getActivity());
        fragmentWishlistBinding.setHvm(fragmentWishListViewModel);
        return fragmentWishlistBinding.getRoot();

    }
}