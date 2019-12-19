package com.example.bujo_48k_projecjt.ui.monthly;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;
import com.example.bujo_48k_projecjt.ui.monthly.monthly_recycler.MonthlyRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.monthly.monthly_recycler.MonthlyRecyclerViewModel;

public class MonthlyFragment extends BaseFragment
{
    private MonthlyViewModel monthlyViewModel;
    private MonthlyRecyclerViewModel monthlyRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_monthly;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);

        BindMonthlyRecyclerView(view);
        monthlyRecyclerViewModel.fetchData();
    }

    private void BindMonthlyRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.monthly_recycler);

        monthlyRecyclerViewModel = ViewModelProviders.of(this).get(MonthlyRecyclerViewModel.class);

        MonthlyRecyclerViewAdapter adapter = new MonthlyRecyclerViewAdapter(
                monthlyRecyclerViewModel,
                this
        );

        monthlyRecyclerViewModel.observeAction(this, chatAction ->
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