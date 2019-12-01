package com.example.bujo_48k_projecjt.ui.collections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CollectionsViewModel extends ViewModel
{
    private MutableLiveData<String> mText;

    public CollectionsViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Collections fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}