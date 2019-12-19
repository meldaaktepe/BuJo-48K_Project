package com.example.bujo_48k_projecjt.ui.monthly;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class MonthlyRecyclerViewAdapter extends BaseRecyclerViewAdapter<Task, BasicAction>
{
    public MonthlyRecyclerViewAdapter(BaseRecyclerViewModel<Task, BasicAction> baseRecyclerViewModel,
                                      LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected int getItemLayout(int viewType) {
        return R.layout.monthly_item;
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, int itemViewType, Task model) {

        binding.setVariable(BR.viewModel, new MontlyItemViewModel(model));

    }
}
