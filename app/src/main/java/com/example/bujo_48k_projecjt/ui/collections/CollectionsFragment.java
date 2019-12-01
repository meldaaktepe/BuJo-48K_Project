package com.example.bujo_48k_projecjt.ui.collections;

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

public class CollectionsFragment extends Fragment
{
    private CollectionsViewModel collectionsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        collectionsViewModel = ViewModelProviders.of(this).get(CollectionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_collections, container, false);
        final TextView textView = root.findViewById(R.id.text_collections);
        collectionsViewModel.getText().observe(this, new Observer<String>()
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