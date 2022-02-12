package com.mboutiquevb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mboutiquevb.R;
import com.mboutiquevb.databinding.FragmentHomeBinding;
import com.mboutiquevb.viewmodel.FragmentHomeViewModel;


public class HomeFragment extends Fragment {
    FragmentHomeBinding fragmentHomeBinding;
    FragmentHomeViewModel fragmentHomeViewmodel;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        fragmentHomeViewmodel = new FragmentHomeViewModel(fragmentHomeBinding, getActivity());
        fragmentHomeBinding.setHvm(fragmentHomeViewmodel);
        return fragmentHomeBinding.getRoot();
    }
}
