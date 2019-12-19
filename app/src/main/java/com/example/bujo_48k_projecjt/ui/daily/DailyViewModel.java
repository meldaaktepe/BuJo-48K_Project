package com.example.bujo_48k_projecjt.ui.daily;

import android.view.View;

import com.example.bujo_48k_projecjt.models.tasks.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

public class DailyViewModel extends BaseViewModel<Task, BasicAction>
{
    public void OnFloatingActionButtonclicked(View view)
    {
        setAction(null, BasicAction.ON_FLOATING_ACTION_BUTTON_CLICK);
    }
}