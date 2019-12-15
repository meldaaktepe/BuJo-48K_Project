package com.example.bujo_48k_projecjt.ui.settings;

import android.graphics.Color;

import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskTypeRecyclerViewModel extends BaseRecyclerViewModel<TaskType, BasicAction>
{
    @Override
    public void fetchData()
    {
        mData.setValue(new ArrayList<TaskType>(Arrays.asList(
                new TaskType(1, "q", Color.GREEN),
                new TaskType(3, "w", Color.BLUE),
                new TaskType(5, "e", Color.RED)
        )));
    }
}
