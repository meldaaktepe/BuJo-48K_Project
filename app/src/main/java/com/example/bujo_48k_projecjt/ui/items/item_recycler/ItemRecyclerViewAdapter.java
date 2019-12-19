package com.example.bujo_48k_projecjt.ui.items.item_recycler;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.collections.Item;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class ItemRecyclerViewAdapter extends BaseRecyclerViewAdapter<Item, BasicAction>
{
    public ItemRecyclerViewAdapter(
            BaseRecyclerViewModel<Item, BasicAction> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, int itemViewType, Item model)
    {
        binding.setVariable(BR.viewModel, new ItemItemViewModel(mViewModel, model));
    }

    @Override
    protected int getItemLayout(int viewType)
    {
        return R.layout.item_item;
    }
}
