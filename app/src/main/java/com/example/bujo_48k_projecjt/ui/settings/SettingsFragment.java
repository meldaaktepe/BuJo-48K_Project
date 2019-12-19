package com.example.bujo_48k_projecjt.ui.settings;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;
import com.example.bujo_48k_projecjt.ui.settings.task_type_recycler.TaskTypeRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.settings.task_type_recycler.TaskTypeRecyclerViewModel;
import com.example.bujo_48k_projecjt.ui.task_type_editor.TaskTypeEditorActivity;

public class SettingsFragment extends BaseFragment
{
    private SettingsViewModel settingsViewModel;

    private TaskTypeRecyclerViewModel taskTypeRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_settings;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        mViewDataBinding.setVariable(BR.viewModel, settingsViewModel);

        settingsViewModel.observeAction(this, taskTypeBasicActionAction ->
        {
            if (taskTypeBasicActionAction == null) return;

            switch (taskTypeBasicActionAction.getActionType())
            {
                case ON_FLOATING_ACTION_BUTTON_CLICK:
                    StartTaskTypeEditor(taskTypeBasicActionAction.getModel());
                    break;
            }
        });

        BindTaskTypeRecyclerView(view);
        taskTypeRecyclerViewModel.fetchData();

        taskTypeRecyclerViewModel.observeAction(this, taskTypeBasicActionAction ->
        {
            if (taskTypeBasicActionAction == null) return;

            switch (taskTypeBasicActionAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    StartTaskTypeEditor(taskTypeBasicActionAction.getModel());
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void StartTaskTypeEditor(TaskType taskType)
    {
        startActivity(
                TaskTypeEditorActivity.CreateIntent(getContext(), taskType)
        );
    }
}