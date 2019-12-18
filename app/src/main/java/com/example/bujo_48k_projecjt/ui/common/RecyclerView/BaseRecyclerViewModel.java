package com.example.bujo_48k_projecjt.ui.common.RecyclerView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

import java.util.List;

public abstract class BaseRecyclerViewModel<Model extends BaseModel, ActionType> extends BaseAndroidViewModel<Model, ActionType>
{
    static private final String TAG = "BaseRecyclerViewModel";

    protected MutableLiveData<List<Model>> mData = new MutableLiveData<>();

    public MutableLiveData<List<Model>> getLiveData()
    {
        return mData;
    }

    public abstract void fetchData();

    public BaseRecyclerViewModel(@NonNull Application application)
    {
        super(application);

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());
    }


}
