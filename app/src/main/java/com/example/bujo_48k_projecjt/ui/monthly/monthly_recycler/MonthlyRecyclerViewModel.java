package com.example.bujo_48k_projecjt.ui.monthly.monthly_recycler;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.bujo_48k_projecjt.models.tasks.TaskDAO;
import com.example.bujo_48k_projecjt.models.tasks.TaskDatabase;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class MonthlyRecyclerViewModel extends BaseRecyclerViewModel<TaskWithType, BasicAction>
{
    private TaskDAO taskDAO;

    public MonthlyRecyclerViewModel(@NonNull Application application)
    {
        super(application);

        taskDAO = TaskDatabase.GetInstance(application).GetTaskDAO();
    }

    @Override
    public void fetchData()
    {
        mData.setValue(taskDAO.GetAllWithTypes());
    }
}
