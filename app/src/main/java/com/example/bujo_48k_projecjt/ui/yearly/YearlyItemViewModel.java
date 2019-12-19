package com.example.bujo_48k_projecjt.ui.yearly;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.itemBaseViewModel;

public class YearlyItemViewModel  extends itemBaseViewModel
{
    private Task task;

    public YearlyItemViewModel(Task task) {
        super(task);
        this.task = task;
    }

    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public void setTask(Task task) {
        this.task = task;
    }
}
