package com.example.bujo_48k_projecjt.ui.yearly;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YearlyViewModel extends ViewModel
{

    private MutableLiveData<String> mText;

    public YearlyViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Yearly fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}