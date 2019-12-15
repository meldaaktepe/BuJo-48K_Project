package com.example.bujo_48k_projecjt.ui.common;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity extends AppCompatActivity
{
    protected ViewDataBinding mViewDataBinding;

    static private final String TAG = "BaseActivity";

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName()
                + ", with layout -> " + getResources().getResourceName(getLayoutId())
        );
    }
}
