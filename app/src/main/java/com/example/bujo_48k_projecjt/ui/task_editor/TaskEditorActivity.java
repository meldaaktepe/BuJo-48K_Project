package com.example.bujo_48k_projecjt.ui.task_editor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.tasks.Task;
import com.example.bujo_48k_projecjt.models.tasks.TaskDatabase;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.models.tasks.TaskTypeDAO;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseActivity;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;
import com.example.bujo_48k_projecjt.ui.task_type_picker.TaskTypePickerActivity;
import com.example.bujo_48k_projecjt.ui.task_type_recycler.TaskTypeItemViewModel;
import com.example.bujo_48k_projecjt.ui.task_type_recycler.TaskTypeRecyclerViewModel;

public class TaskEditorActivity extends BaseActivity
{
    TaskEditorViewModel taskEditorViewModel;

    ViewDataBinding taskTypeViewDataBinding;
    TaskTypeItemViewModel taskTypeItemViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_task_editor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setTitle("Task Editor");
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        taskEditorViewModel = ViewModelProviders.of(this).get(TaskEditorViewModel.class);
        mViewDataBinding.setVariable(com.example.bujo_48k_projecjt.BR.viewModel, taskEditorViewModel);

        long taskTypeId = getIntent().getLongExtra(taskIdKey, -1);
        if (taskTypeId == -1)
        {
            //  Editor is opened to create a new Task object
            taskEditorViewModel.CreateEmpty();
        } else
        {
            //  Editor is opened to edit a specific Task object
            taskEditorViewModel.FetchData(taskTypeId);
        }

        taskEditorViewModel.observeAction(this, taskBasicActionAction ->
        {
            if (taskBasicActionAction == null) return;

            switch (taskBasicActionAction.getActionType())
            {
                case SAVE_BUTTON_CLICKED:
                case DELETE_BUTTON_CLICKED:
                    finish();
                    break;
            }
        });

        BaseAndroidViewModel<TaskType, BasicAction> vm = ViewModelProviders.of(this).get(TaskTypeRecyclerViewModel.class);
        taskTypeItemViewModel = new TaskTypeItemViewModel(vm, taskEditorViewModel.mData.getValue().taskType);
        mViewDataBinding.setVariable(BR.taskTypeViewModel, taskTypeItemViewModel);
        vm.observeAction(this, taskTypeBasicActionAction ->
        {
            if (taskTypeBasicActionAction == null) return;

            switch (taskTypeBasicActionAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    // Start intent
                    Intent intent = TaskTypePickerActivity.CreateIntent(this);
                    startActivityForResult(intent, 5);
                    break;
            }
        });
    }

    private static final String taskIdKey = "taskTypeId";

    public static Intent CreateIntent(Context context, Task task)
    {
        Intent intent = new Intent(context, TaskEditorActivity.class);
        intent.putExtra(taskIdKey, task != null ? task.id : null);
        return intent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 5 && resultCode == Activity.RESULT_OK)
        {
            long taskTypeId = data.getLongExtra("taskTypeId", 0);
            TaskTypeDAO taskTypeDAO = TaskDatabase.GetInstance(this).GetTaskTypeDAO();
            TaskWithType taskWithType = taskEditorViewModel.mData.getValue();
            taskWithType.taskType = taskTypeDAO.Get(taskTypeId);
            taskEditorViewModel.mData.setValue(taskWithType);
            taskTypeItemViewModel.setModel(taskWithType.taskType);
            mViewDataBinding.setVariable(BR.taskTypeViewModel, taskTypeItemViewModel);
        }
    }
}
