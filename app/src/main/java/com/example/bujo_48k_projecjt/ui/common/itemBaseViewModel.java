package com.example.bujo_48k_projecjt.ui.common;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;

public class itemBaseViewModel extends BaseViewModel<Task, BasicAction>
{
    private Task task;

    public itemBaseViewModel(Task task)
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

