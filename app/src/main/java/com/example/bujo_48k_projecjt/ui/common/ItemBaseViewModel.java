package com.example.bujo_48k_projecjt.ui.common;

import com.example.bujo_48k_projecjt.models.tasks.Task;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;

public class ItemBaseViewModel extends BaseViewModel<TaskWithType, BasicAction>
{
    private TaskWithType taskWithType;

    public ItemBaseViewModel(TaskWithType taskWithType)
    {
        this.taskWithType = taskWithType;
    }

    public TaskWithType getTask()
    {
        return taskWithType;
    }

    public void setTask(Task task)
    {
        this.taskWithType = (TaskWithType) task;
    }

    public TaskType getTaskType()
    {
        return taskWithType.taskType;
    }

    public void setTaskType(TaskType taskType)
    {
        taskWithType.taskType = taskType;
    }
}

