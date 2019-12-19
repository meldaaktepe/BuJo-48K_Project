package com.example.bujo_48k_projecjt.ui.yearly;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;


public class YearlyRecyclerViewAdapter extends BaseRecyclerViewAdapter<Task, BasicAction>
{
    public YearlyRecyclerViewAdapter(BaseRecyclerViewModel<Task, BasicAction> baseRecyclerViewModel, LifecycleOwner lifecycleOwner) {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected int getItemLayout(int viewType) {
        return R.layout.yearly_item;
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, int itemViewType, Task model) {
        binding.setVariable(BR.viewModel, new YearlyItemViewModel(model));
    }

}
