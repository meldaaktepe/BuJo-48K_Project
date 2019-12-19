package com.example.bujo_48k_projecjt.ui.task_type_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.ui.common.BaseActivity;
import com.example.bujo_48k_projecjt.ui.task_type_recycler.TaskTypeRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.task_type_recycler.TaskTypeRecyclerViewModel;

public class TaskTypePickerActivity extends BaseActivity
{
    private TaskTypeRecyclerViewModel taskTypeRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_task_type_picker;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setTitle("Task Type Picker");
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        BindTaskTypeRecyclerView(mViewDataBinding.getRoot());
        taskTypeRecyclerViewModel.fetchData();

        taskTypeRecyclerViewModel.observeAction(this, taskTypeBasicActionAction ->
        {
            if (taskTypeBasicActionAction == null) return;

            switch (taskTypeBasicActionAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    Intent intent = new Intent(this, TaskTypePickerActivity.class);
                    intent.putExtra("taskTypeId", taskTypeBasicActionAction.getModel().id);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                    break;
            }
        });
    }

    private void BindTaskTypeRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.task_type_list);

        taskTypeRecyclerViewModel = ViewModelProviders.of(this).get(TaskTypeRecyclerViewModel.class);

        TaskTypeRecyclerViewAdapter adapter = new TaskTypeRecyclerViewAdapter(
                taskTypeRecyclerViewModel,
                this
        );

        taskTypeRecyclerViewModel.observeAction(this, chatAction ->
        {
            if (chatAction == null) return;

            switch (chatAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    break;
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public static Intent CreateIntent(Context context)
    {
        return new Intent(context, TaskTypePickerActivity.class);
    }
}
