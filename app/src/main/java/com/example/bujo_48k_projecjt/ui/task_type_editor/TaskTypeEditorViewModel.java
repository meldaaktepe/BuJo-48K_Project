package com.example.bujo_48k_projecjt.ui.task_type_editor;

import android.app.Application;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bujo_48k_projecjt.models.tasks.TaskDatabase;
import com.example.bujo_48k_projecjt.models.tasks.TaskType;
import com.example.bujo_48k_projecjt.models.tasks.TaskTypeDAO;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

public class TaskTypeEditorViewModel extends BaseAndroidViewModel<TaskType, BasicAction>
{
    private TaskTypeDAO taskTypeDAO;

    public final MutableLiveData<TaskType> mData = new MutableLiveData<>();

    public TaskTypeEditorViewModel(@NonNull Application application)
    {
        super(application);

        taskTypeDAO = TaskDatabase.GetInstance(application).GetTaskTypeDAO();
    }

    public void FetchData(long id)
    {
        mData.setValue(taskTypeDAO.Get(id));
    }

    public void CreateEmpty()
    {
        mData.setValue(new TaskType("", 0, "", Color.MAGENTA));
    }

    public void OnSave(View view)
    {
        taskTypeDAO.InsertOrUpdate(mData.getValue());
        setAction(mData.getValue(), BasicAction.SAVE_BUTTON_CLICKED);
    }

    public void OnDelete(View view)
    {
        taskTypeDAO.Delete(mData.getValue());
        setAction(mData.getValue(), BasicAction.DELETE_BUTTON_CLICKED);
    }
}
