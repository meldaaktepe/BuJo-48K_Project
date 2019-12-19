package com.example.bujo_48k_projecjt.ui.yearly;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;

public class YearlyFragment extends BaseFragment
{
    private YearlyViewModel yearlyViewModel;

    private YearlyRecyclerViewModel yearlyRecyclerViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yearly;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        yearlyViewModel = ViewModelProviders.of(this).get(YearlyViewModel.class);

        BindyearlyRecyclerView(view);

        yearlyRecyclerViewModel.fetchData();
    }

    private void BindyearlyRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.yearly_recyler);

        yearlyRecyclerViewModel = ViewModelProviders.of(this).get(YearlyRecyclerViewModel.class);

        YearlyRecyclerViewAdapter adapter = new YearlyRecyclerViewAdapter(
                yearlyRecyclerViewModel,
                this
        );

        yearlyRecyclerViewModel.observeAction(this, chatAction ->
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