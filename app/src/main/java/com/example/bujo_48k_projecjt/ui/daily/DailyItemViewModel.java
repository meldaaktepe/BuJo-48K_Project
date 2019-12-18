package com.example.bujo_48k_projecjt.ui.daily;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;
import com.example.bujo_48k_projecjt.ui.common.itemBaseViewModel;

public class DailyItemViewModel extends itemBaseViewModel
{
    private Task task;

    public DailyItemViewModel(Task task)
    {
        super(task);
        this.task = task;
    }

    public Task getTask()
    {
        return task;
    }

    public void setTask(Task task)
    {
        this.task = task;
    }
}
