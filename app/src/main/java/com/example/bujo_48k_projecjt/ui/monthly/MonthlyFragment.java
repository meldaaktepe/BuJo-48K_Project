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

public class MonthlyFragment extends BaseFragment
{
    private MonthlyViewModel monthlyViewModel;
    private MontlyRecyclerViewModel montlyRecyclerViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_monthly;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        monthlyViewModel = ViewModelProviders.of(this).get(MonthlyViewModel.class);

        BindmonthlyRecyclerView(view);

        montlyRecyclerViewModel.fetchData();

    }

    private void BindmonthlyRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.monthly_recyler);

        montlyRecyclerViewModel = ViewModelProviders.of(this).get(MontlyRecyclerViewModel.class);

        MonthlyRecyclerViewAdapter adapter = new MonthlyRecyclerViewAdapter(
                montlyRecyclerViewModel,
                this
        );

        montlyRecyclerViewModel.observeAction(this, chatAction ->
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