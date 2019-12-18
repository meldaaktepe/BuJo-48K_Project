package com.example.bujo_48k_projecjt.ui.settings.task_type_recycler;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class TaskTypeRecyclerViewAdapter extends BaseRecyclerViewAdapter<TaskType, BasicAction>
{
    public TaskTypeRecyclerViewAdapter(BaseRecyclerViewModel<TaskType, BasicAction> baseRecyclerViewModel, LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, TaskType model)
    {
        binding.setVariable(BR.viewModel, new TaskTypeItemViewModel(mViewModel, model));
    }

    @Override
    protected int getItemViewId()
    {
        return R.layout.task_type_item;
    }
}
