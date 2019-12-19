package com.example.bujo_48k_projecjt.ui.settings.task_type_recycler;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.bujo_48k_projecjt.models.tasks.TaskDatabase;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.models.tasks.TaskTypeDAO;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class TaskTypeRecyclerViewModel extends BaseRecyclerViewModel<TaskType, BasicAction>
{
    TaskTypeDAO taskTypeDAO;

    public TaskTypeRecyclerViewModel(@NonNull Application application)
    {
        super(application);

        taskTypeDAO = TaskDatabase.GetInstance(application).GetTaskTypeDAO();
    }

    @Override
    public void fetchData()
    {
        mData.setValue(taskTypeDAO.GetAll());
    }
}
