package com.example.bujo_48k_projecjt.ui.settings.task_type_recycler;

import android.app.Application;
import android.graphics.Color;

import androidx.annotation.NonNull;

import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskTypeRecyclerViewModel extends BaseRecyclerViewModel<TaskType, BasicAction>
{
    public TaskTypeRecyclerViewModel(@NonNull Application application)
    {
        super(application);
    }

    @Override
    public void fetchData()
    {
        mData.setValue(new ArrayList<>(Arrays.asList(
                new TaskType(1, "q", Color.GREEN),
                new TaskType(3, "w", Color.BLUE),
                new TaskType(5, "e", Color.RED)
        )));
    }
}
