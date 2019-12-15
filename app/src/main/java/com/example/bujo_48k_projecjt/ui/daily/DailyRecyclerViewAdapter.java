package com.example.bujo_48k_projecjt.ui.daily;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class DailyRecyclerViewAdapter extends BaseRecyclerViewAdapter<Task, BasicAction>
{
    public DailyRecyclerViewAdapter(
            BaseRecyclerViewModel<Task, BasicAction> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, Task model)
    {
        binding.setVariable(BR.viewModel, new DailyItemViewModel(model));
    }

    @Override
    protected int getItemViewId()
    {
        return R.layout.daily_item;
    }
}
