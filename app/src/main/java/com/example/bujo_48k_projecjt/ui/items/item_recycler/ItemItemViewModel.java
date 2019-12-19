package com.example.bujo_48k_projecjt.ui.items.item_recycler;

import android.view.View;

import com.example.bujo_48k_projecjt.models.collections.Item;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerItemViewModel;

public class ItemItemViewModel extends BaseRecyclerItemViewModel<Item, BasicAction>
{
    public ItemItemViewModel(BaseAndroidViewModel<Item, BasicAction> viewModel, Item model)
    {
        super(viewModel, model);
    }

    public void OnClick(View view)
    {
        mViewModel.setAction(mModel, BasicAction.RECYCLER_ITEM_CLICK);
    }
}
