package com.example.bujo_48k_projecjt.ui.common;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.Action.Action;

public abstract class BaseAndroidViewModel<Model extends BaseModel, ActionType> extends AndroidViewModel
{
    static private final String TAG = "BaseViewModel";

    private final MutableLiveData<Action<Model, ActionType>> mCurrentAction = new MutableLiveData<>();

    public void setAction(Action<Model, ActionType> action)
    {
        mCurrentAction.setValue(action);
    }

    public void observeAction(final LifecycleOwner lifecycleOwner, final Observer<Action<Model, ActionType>> observer)
    {
        mCurrentAction.observe(lifecycleOwner, observer);
    }

    public BaseAndroidViewModel(@NonNull Application application)
    {
        super(application);

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());
    }
}
