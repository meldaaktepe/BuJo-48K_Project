package com.example.bujo_48k_projecjt.ui.common;

import com.example.bujo_48k_projecjt.models.tasks.Task;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerItemViewModel;

public class TaskWithTypeItemBaseViewModel extends BaseRecyclerItemViewModel<TaskWithType, BasicAction>
{
    public TaskWithTypeItemBaseViewModel(BaseAndroidViewModel<TaskWithType, BasicAction> viewModel, TaskWithType model)
    {
        super(viewModel, model);
    }

    public TaskWithType getTask()
    {
        return mModel;
    }

    public void setTask(Task task)
    {
        this.mModel = (TaskWithType) task;
    }

    public TaskType getTaskType()
    {
        return mModel.taskType;
    }

    public void setTaskType(TaskType taskType)
    {
        mModel.taskType = taskType;
    }
}

