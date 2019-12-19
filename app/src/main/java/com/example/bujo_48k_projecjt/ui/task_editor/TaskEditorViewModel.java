package com.example.bujo_48k_projecjt.ui.task_editor;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bujo_48k_projecjt.models.tasks.TaskDAO;
import com.example.bujo_48k_projecjt.models.tasks.TaskDatabase;
import com.example.bujo_48k_projecjt.models.tasks.TaskWithType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;

import java.util.Date;

public class TaskEditorViewModel extends BaseAndroidViewModel<TaskWithType, BasicAction>
{
    public final MutableLiveData<TaskWithType> mData = new MutableLiveData<>();

    private TaskDAO taskDAO;

    public TaskEditorViewModel(@NonNull Application application)
    {
        super(application);

        taskDAO = TaskDatabase.GetInstance(application).GetTaskDAO();
    }

    public void FetchData(long taskTypeId)
    {
        mData.setValue(taskDAO.GetWithType(taskTypeId));
    }

    public void CreateEmpty()
    {
        mData.setValue(new TaskWithType("", "", new Date()));
    }

    public void OnSave(View view)
    {
        taskDAO.InsertOrUpdate(mData.getValue().taskType, mData.getValue());
        setAction(mData.getValue(), BasicAction.SAVE_BUTTON_CLICKED);
    }

    public void OnDelete(View view)
    {
        taskDAO.Delete(mData.getValue());
        setAction(mData.getValue(), BasicAction.DELETE_BUTTON_CLICKED);
    }

    public void OnTaskTypeClicked(View view)
    {
        setAction(null, BasicAction.TASK_TYPE_CLICKED);
    }
}
