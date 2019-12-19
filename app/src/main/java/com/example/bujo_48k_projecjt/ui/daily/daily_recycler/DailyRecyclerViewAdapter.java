package com.example.bujo_48k_projecjt.ui.daily.daily_recycler;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class DailyRecyclerViewAdapter extends BaseRecyclerViewAdapter<TaskWithType, BasicAction>
{
    public DailyRecyclerViewAdapter(
            BaseRecyclerViewModel<TaskWithType, BasicAction> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, int itemViewType, TaskWithType model)
    {
        binding.setVariable(BR.viewModel, new DailyItemViewModel(model));
    }

    @Override
    protected int getItemLayout(int viewType)
    {
        return R.layout.task_with_type_item;
    }
}
