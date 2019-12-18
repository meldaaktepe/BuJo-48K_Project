package com.example.bujo_48k_projecjt.ui.common;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.Action.Action;

public abstract class BaseViewModel<Model extends BaseModel, ActionType extends Enum> extends ViewModel
{
    static private final String TAG = "BaseViewModel";

    public BaseViewModel()
    {
        super();

        mAction.observeForever(this::onActionSet);

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();

        mAction.removeObserver(this::onActionSet);
    }

    /*  All other components should interact over this Action  */
    private final MutableLiveData<Action<Model, ActionType>> mAction = new MutableLiveData<>();

    public void setAction(Model model, ActionType actionType)
    {
        mAction.postValue(new Action<>(model, actionType));
    }

    protected void onActionSet(Action<Model, ActionType> action)
    {
        Log.d(TAG, "New Action Set => " + action.getActionType().toString());
    }

    public void observeAction(
            final LifecycleOwner lifecycleOwner,
            final Observer<Action<Model, ActionType>> observer)
    {
        mAction.observe(lifecycleOwner, observer);
    }
}
