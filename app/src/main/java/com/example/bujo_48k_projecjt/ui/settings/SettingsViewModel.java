package com.example.bujo_48k_projecjt.ui.settings;

import android.view.View;

import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

import static com.example.bujo_48k_projecjt.ui.common.Action.BasicAction.ON_FLOATING_ACTION_BUTTON_CLICK;

public class SettingsViewModel extends BaseViewModel<TaskType, BasicAction>
{
    public void OnFloatingActionButtonClicked(View view)
    {
        setAction(null, ON_FLOATING_ACTION_BUTTON_CLICK);
    }
}