package com.example.bujo_48k_projecjt.ui.settings;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.Action;
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
        binding.setVariable(BR.viewModel, new TaskTypeItemViewModel(model));

//        binding.getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mViewModel.setAction(new Action<>(model, BasicAction.RECYCLER_ITEM_CLICK));
//            }
//        });
    }

    @Override
    protected int getItemViewId()
    {
        return R.layout.task_type_item;
    }
}
