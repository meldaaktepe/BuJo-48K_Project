package com.example.bujo_48k_projecjt.ui.settings;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;
import com.example.bujo_48k_projecjt.ui.settings.task_type_recycler.TaskTypeRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.settings.task_type_recycler.TaskTypeRecyclerViewModel;

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
        BindTaskTypeRecyclerView(view);

        taskTypeRecyclerViewModel.fetchData();
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
}