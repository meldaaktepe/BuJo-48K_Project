package com.example.bujo_48k_projecjt.ui.settings;

import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

public class TaskTypeItemViewModel extends BaseViewModel<TaskType, BasicAction>
{
    private TaskType taskType;

    public TaskTypeItemViewModel(TaskType model)
    {
        taskType = model;
    }

    public TaskType getTaskType()
    {
        return taskType;
    }

    public void setTaskType(TaskType taskType)
    {
        this.taskType = taskType;
    }
}
