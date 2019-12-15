package com.example.bujo_48k_projecjt.ui.daily;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

public class DailyItemViewModel extends BaseViewModel<Task, BasicAction>
{
    private Task task;

    public DailyItemViewModel(Task task)
    {
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
