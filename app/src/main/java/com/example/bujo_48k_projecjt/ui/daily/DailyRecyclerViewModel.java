package com.example.bujo_48k_projecjt.ui.daily;

import com.example.bujo_48k_projecjt.models.Task;
import com.example.bujo_48k_projecjt.models.TaskType;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DailyRecyclerViewModel extends BaseRecyclerViewModel<Task, BasicAction>
{
    private Date d;
    private Task event;

    @Override
    public void fetchData()
    {
        try
        {
            TaskType tastType = new TaskType(5, "hi", 05);
            ArrayList<Task> eventList = new ArrayList<>();
            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019");
            event = new Task("CS310 Midterm1", "Midterm at LO65 from 9am", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("07/04/2019");
            event = new Task("Room meeting", "Meet Mr. Mbape before things get worse", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2019");
            event = new Task("CS310 Midterm1 Objection", "Room LO65 from 10am ", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("09/04/2019");
            event = new Task("CS308 Project presentation", "4th sprint user-inteface design", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("31/03/2019");
            event = new Task("Judiy's Funeral", "buy flowers", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("02/04/2019");
            event = new Task("Avengers release", "Invite roommates to watch it", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2019");
            event = new Task("Job application", "Ware the black suit", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019");
            event = new Task("Google's interview", "Focus on software engineering nothing else matters", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019");
            event = new Task("Summer school starts", "Nothing special", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("08/05/2019");
            event = new Task("MS application deadline", "now or never", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("29/03/2019");
            event = new Task("Make plane reservation", "Most preferably Turkish Airlines", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019");
            event = new Task("Trip to Africa", "Dont miss your plane", d, tastType);
            eventList.add(event);

            d = new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2019");
            event = new Task("See the dentist", "Midterm at LO65 from 9am", d, tastType);
            eventList.add(event);

            mData.setValue(eventList);

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
