package com.mboutiquevb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mboutiquevb.R;
import com.mboutiquevb.databinding.FragmentCategoryBinding;
import com.mboutiquevb.viewmodel.FragmentCategoryViewModel;


public class CategoryFragment extends Fragment {
    FragmentCategoryBinding fragmentCategoryBinding;
    FragmentCategoryViewModel fragmentCategoryViewModel;


    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCategoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);
        fragmentCategoryViewModel = new FragmentCategoryViewModel(fragmentCategoryBinding, getActivity());
        fragmentCategoryBinding.setHvm(fragmentCategoryViewModel);
        return fragmentCategoryBinding.getRoot();
    }
}