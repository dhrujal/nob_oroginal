package com.mboutiquevb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mboutiquevb.R;
import com.mboutiquevb.databinding.FragmentCartBinding;
import com.mboutiquevb.viewmodel.FragmentCartViewModel;


public class CartFragment extends Fragment {
    FragmentCartBinding fragmentCartBinding;
    FragmentCartViewModel fragmentCartViewModel;


    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        fragmentCartViewModel = new FragmentCartViewModel(fragmentCartBinding, getActivity());
        fragmentCartBinding.setHvm(fragmentCartViewModel);
        return fragmentCartBinding.getRoot();
    }
}