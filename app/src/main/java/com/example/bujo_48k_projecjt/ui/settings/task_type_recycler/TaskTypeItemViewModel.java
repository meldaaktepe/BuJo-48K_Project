package com.example.bujo_48k_projecjt.ui.settings.task_type_recycler;

import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerItemViewModel;

public class TaskTypeItemViewModel extends BaseRecyclerItemViewModel<TaskType, BasicAction>
{
    public TaskTypeItemViewModel(BaseAndroidViewModel<TaskType, BasicAction> viewModel, TaskType model)
    {
        super(viewModel, model);
    }
}