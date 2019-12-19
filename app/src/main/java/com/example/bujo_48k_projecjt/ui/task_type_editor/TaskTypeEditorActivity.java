package com.example.bujo_48k_projecjt.ui.task_type_editor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProviders;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.ui.common.BaseActivity;

public class TaskTypeEditorActivity extends BaseActivity
{
    private TaskTypeEditorViewModel taskTypeEditorViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_task_type_editor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setTitle("Task Type Editor");
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        taskTypeEditorViewModel = ViewModelProviders.of(this).get(TaskTypeEditorViewModel.class);
        mViewDataBinding.setVariable(BR.viewModel, taskTypeEditorViewModel);

        long taskTypeId = getIntent().getLongExtra(taskTypeIdKey, -1);
        if (taskTypeId == -1)
        {
            //  Editor is opened to create a new TaskType object
            taskTypeEditorViewModel.CreateEmpty();
        } else
        {
            //  Editor is opened to edit a specific TaskType object
            taskTypeEditorViewModel.FetchData(taskTypeId);
        }

        taskTypeEditorViewModel.observeAction(this, taskTypeBasicActionAction ->
        {
            if (taskTypeBasicActionAction == null) return;

            switch (taskTypeBasicActionAction.getActionType())
            {
                case SAVE_BUTTON_CLICKED:
                case DELETE_BUTTON_CLICKED:
                    finish();
                    break;
            }
        });
    }

    private static final String taskTypeIdKey = "taskTypeId";

    public static Intent CreateIntent(Context context, TaskType taskType)
    {
        Intent intent = new Intent(context, TaskTypeEditorActivity.class);
        intent.putExtra(taskTypeIdKey, taskType != null ? taskType.id : null);
        return intent;
    }
}
