package com.example.bujo_48k_projecjt.ui.daily.daily_recycler;

import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;
import com.example.bujo_48k_projecjt.ui.common.TaskWithTypeItemBaseViewModel;

public class DailyTaskWithTypeItemViewModel extends TaskWithTypeItemBaseViewModel
{
    public DailyTaskWithTypeItemViewModel(BaseAndroidViewModel<TaskWithType, BasicAction> viewModel, TaskWithType model)
    {
        super(viewModel, model);
    }
}
