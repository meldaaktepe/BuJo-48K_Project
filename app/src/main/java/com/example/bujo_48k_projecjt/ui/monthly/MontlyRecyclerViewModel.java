package com.example.bujo_48k_projecjt.ui.monthly;

import android.app.Application;
import android.graphics.Color;

import androidx.annotation.NonNull;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MontlyRecyclerViewModel extends BaseRecyclerViewModel<Task, BasicAction>
{

    public MontlyRecyclerViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void fetchData() {

        try
        {
            TaskType taskType = new TaskType(5, "hi", Color.GREEN);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            ArrayList<Task> eventList = new ArrayList<>(Arrays.asList(
                    new Task(
                            "CS310 Midterm1", "Midterm at LO65 from 9am",
                            dateFormat.parse("06/04/2019"),
                            taskType
                    ),
                    new Task(
                            "Room meeting", "Meet Mr. Mbape before things get worse",
                            dateFormat.parse("07/04/2019"),
                            taskType
                    ),
                    new Task(
                            "CS310 Midterm1 Objection", "Room LO65 from 10am ",
                            dateFormat.parse("06/05/2019"),
                            taskType
                    ),
                    new Task(
                            "CS308 Project presentation", "4th sprint user-inteface design",
                            dateFormat.parse("09/04/2019"),
                            taskType
                    ),
                    new Task(
                            "Summer school starts", "Nothing special",
                            dateFormat.parse("06/04/2019"),
                            taskType
                    ),
                    new Task(
                            "MS application deadline", "now or never",
                            dateFormat.parse("08/05/2019"),
                            taskType
                    ),
                    new Task(
                            "Make plane reservation", "Most preferably Turkish Airlines",
                            dateFormat.parse("29/03/2019"),
                            taskType
                    ),
                    new Task(
                            "Trip to Africa", "Dont miss your plane",
                            dateFormat.parse("06/04/2019"),
                            taskType
                    ),
                    new Task(
                            "See the dentist", "Midterm at LO65 from 9am",
                            dateFormat.parse("06/05/2019"),
                            taskType
                    )
            ));

            mData.setValue(eventList);

        } catch (ParseException e)
        {
            e.printStackTrace();
        }

    }
}
