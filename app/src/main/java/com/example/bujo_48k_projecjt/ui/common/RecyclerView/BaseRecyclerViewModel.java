package com.example.bujo_48k_projecjt.ui.common.RecyclerView;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

import java.util.ArrayList;

public abstract class BaseRecyclerViewModel<Model extends BaseModel, ActionType> extends BaseViewModel<Model, ActionType>
{
    static private final String TAG = "BaseRecyclerViewModel";

    protected MutableLiveData<ArrayList<Model>> mData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Model>> getLiveData()
    {
        return mData;
    }

    public abstract void fetchData();

    public BaseRecyclerViewModel()
    {
        super();

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());
    }
}
