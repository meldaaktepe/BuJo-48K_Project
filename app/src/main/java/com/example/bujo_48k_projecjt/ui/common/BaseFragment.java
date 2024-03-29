package com.example.bujo_48k_projecjt.ui.common;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

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

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName()
                + " from layout -> " + getResources().getResourceName(getLayoutId())
        );

        return mViewDataBinding.getRoot();
    }

    @Override
    public abstract void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);
}
