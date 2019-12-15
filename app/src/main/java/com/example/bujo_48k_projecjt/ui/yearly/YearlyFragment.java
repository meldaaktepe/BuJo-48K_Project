package com.example.bujo_48k_projecjt.ui.yearly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bujo_48k_projecjt.R;

public class YearlyFragment extends Fragment
{
    private YearlyViewModel yearlyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        yearlyViewModel = ViewModelProviders.of(this).get(YearlyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_yearly, container, false);
        final TextView textView = root.findViewById(R.id.text_yearly);
        yearlyViewModel.getText().observe(this, new Observer<String>()
        {
            @Override
            public void onChanged(@Nullable String s)
            {
                textView.setText(s);
            }
        });
        return root;
    }
}