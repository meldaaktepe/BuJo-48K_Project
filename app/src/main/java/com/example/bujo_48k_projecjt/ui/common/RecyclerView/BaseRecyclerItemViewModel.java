package com.example.bujo_48k_projecjt.ui.common.RecyclerView;


import androidx.lifecycle.ViewModel;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

public class BaseRecyclerItemViewModel<Model extends BaseModel, ActionType extends Enum> extends ViewModel
{
    protected final BaseAndroidViewModel<Model, ActionType> mViewModel;
    protected Model mModel;

    public BaseRecyclerItemViewModel(BaseAndroidViewModel<Model, ActionType> viewModel, Model model)
    {
        mViewModel = viewModel;
        mModel = model;
    }

    public Model getModel()
    {
        return mModel;
    }

    public void setModel(Model model)
    {
        mModel = model;
    }
}
