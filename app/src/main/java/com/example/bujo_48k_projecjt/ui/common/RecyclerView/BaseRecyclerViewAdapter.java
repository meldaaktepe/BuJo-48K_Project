package com.example.bujo_48k_projecjt.ui.common.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<Model extends BaseModel, ActionType extends Enum> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder>
{
    static private final String TAG = "BaseRecyclerViewAdapter";

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewDataBinding mBinding;

        protected ViewHolder(View view, ViewDataBinding binding)
        {
            super(view);

            mBinding = binding;
        }
    }

    protected final List<Model> mData = new ArrayList<>();
    protected final BaseAndroidViewModel<Model, ActionType> mViewModel;

    public BaseRecyclerViewAdapter(
            BaseRecyclerViewModel<Model, ActionType> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        this(baseRecyclerViewModel.getLiveData(), baseRecyclerViewModel, lifecycleOwner);
    }

    public BaseRecyclerViewAdapter(
            MutableLiveData<List<Model>> observableData,
            BaseAndroidViewModel<Model, ActionType> viewModel,
            LifecycleOwner lifecycleOwner)
    {
        super();

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());

        observableData.observe(lifecycleOwner, this::setData);

        mViewModel = viewModel;

        setHasStableIds(true);
    }

    protected abstract int getItemLayout(int viewType);

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getItemLayout(viewType),
                parent,
                false
        );

        return new ViewHolder(binding.getRoot(), binding);
    }

    protected abstract void setViewHolderBindings(ViewDataBinding binding, int itemViewType, Model model);

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewAdapter.ViewHolder holder, int position)
    {
        setViewHolderBindings(holder.mBinding, holder.getItemViewType(), mData.get(position));
    }

    @Override
    public long getItemId(int position)
    {
        return mData.get(position).recyclerItemId();
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public void setData(final List<Model> newData)
    {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback()
        {
            @Override
            public int getOldListSize()
            {
                return mData.size();
            }

            @Override
            public int getNewListSize()
            {
                return newData.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition)
            {
                return mData.get(oldItemPosition).equals(newData.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition)
            {
                return mData.get(oldItemPosition).getContent().equals(newData.get(newItemPosition).getContent());
            }
        });

        mData.clear();
        mData.addAll(newData);

        diffResult.dispatchUpdatesTo(this);
    }
}