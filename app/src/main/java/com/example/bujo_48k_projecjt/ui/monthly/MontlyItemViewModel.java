package com.example.bujo_48k_projecjt.ui.monthly;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.itemBaseViewModel;

public class MontlyItemViewModel extends itemBaseViewModel
{
    private Task task;

    public MontlyItemViewModel(Task task) {
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
