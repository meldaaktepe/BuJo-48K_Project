package com.example.bujo_48k_projecjt.ui.common;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.bujo_48k_projecjt.R;
import com.google.android.material.snackbar.Snackbar;

public abstract class BaseActivity extends AppCompatActivity
{
    protected ViewDataBinding mViewDataBinding;

    static private final String TAG = "BaseActivity";

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName()
                + ", with layout -> " + getResources().getResourceName(getLayoutId())
        );
    }

    public void showToast(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showSnackbar(int stringId)
    {
        Snackbar.make(findViewById(R.id.coordinator), stringId, Snackbar.LENGTH_SHORT).show();
    }
}
