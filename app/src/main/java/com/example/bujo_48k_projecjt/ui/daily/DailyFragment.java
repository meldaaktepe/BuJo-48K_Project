package com.example.bujo_48k_projecjt.ui.daily;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.tasks.Task;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;
import com.example.bujo_48k_projecjt.ui.daily.daily_recycler.DailyRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.daily.daily_recycler.DailyRecyclerViewModel;
import com.example.bujo_48k_projecjt.ui.task_editor.TaskEditorActivity;

public class DailyFragment extends BaseFragment
{
    private DailyViewModel dailyViewModel;

    private DailyRecyclerViewModel dailyRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_daily;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        dailyViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);
        mViewDataBinding.setVariable(BR.viewModel, dailyViewModel);

        dailyViewModel.observeAction(this, taskBasicActionAction ->
        {
            if (taskBasicActionAction == null) return;

            switch (taskBasicActionAction.getActionType())
            {
                case ON_FLOATING_ACTION_BUTTON_CLICK:
                    StartTaskEditor(taskBasicActionAction.getModel());
                    break;
            }
        });

        BindDailyRecyclerView(view);
        dailyRecyclerViewModel.fetchData();

        dailyRecyclerViewModel.observeAction(this, taskWithTypeBasicActionAction ->
        {
            if (taskWithTypeBasicActionAction == null) return;

            switch (taskWithTypeBasicActionAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    StartTaskEditor(taskWithTypeBasicActionAction.getModel());
                    break;
            }
        });
    }

    private void BindDailyRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.daily_recycler);

        dailyRecyclerViewModel = ViewModelProviders.of(this).get(DailyRecyclerViewModel.class);

        DailyRecyclerViewAdapter adapter = new DailyRecyclerViewAdapter(
                dailyRecyclerViewModel,
                this
        );

        dailyRecyclerViewModel.observeAction(this, chatAction ->
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

    private void StartTaskEditor(Task task)
    {
        startActivity(
                TaskEditorActivity.CreateIntent(getContext(), task)
        );
    }
}