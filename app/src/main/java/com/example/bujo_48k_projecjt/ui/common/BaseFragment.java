package com.example.bujo_48k_projecjt.ui.common;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment
{
    protected ViewDataBinding mViewDataBinding;

    static private final String TAG = "BaseFragment";

    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        mViewDataBinding = DataBindingUtil.inflate(
                inflater,
                getLayoutId(),
                container,
                false
        );

        Log.d(TAG, "Created -> " + getResources().getResourceName(getLayoutId()));

        return mViewDataBinding.getRoot();
    }

    @Override
    public abstract void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);
}
