package com.example.bujo_48k_projecjt.ui.common.RecyclerView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

import java.util.List;

public abstract class BaseRecyclerViewModel<Model extends BaseModel, ActionType extends Enum> extends BaseAndroidViewModel<Model, ActionType>
{
    static private final String TAG = "BaseRecyclerViewModel";

    public BaseRecyclerViewModel(@NonNull Application application)
    {
        super(application);

        mData.observeForever(this::onDataFetched);
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();
        mData.removeObserver(this::onDataFetched);
    }

    /*  RecyclerView's data  */
    protected final MutableLiveData<List<Model>> mData = new MutableLiveData<>();

    public abstract void fetchData();

    protected void onDataFetched(List<Model> newModels)
    {
        Log.d(TAG, "onDataFetched");
    }

    MutableLiveData<List<Model>> getLiveData()
    {
        return mData;
    }

    public void observeLiveData(LifecycleOwner lifecycleOwner, Observer<List<Model>> observer)
    {
        mData.observe(lifecycleOwner, observer);
    }
}
