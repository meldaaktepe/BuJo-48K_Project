package com.example.bujo_48k_projecjt.models.tasks;

import android.content.Context;
import android.graphics.Color;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Database(version = 2, entities = {Task.class, TaskType.class}, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class TaskDatabase extends RoomDatabase
{
    static private TaskDatabase instance = null;

    static public TaskDatabase GetInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, TaskDatabase.class, "Task Database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

            instance.PopulateInitialData();
        }

        return instance;
    }

    private void PopulateInitialData()
    {
        TaskTypeDAO taskTypeDAO = GetTaskTypeDAO();

        if (taskTypeDAO.HasAny()) return;

        taskTypeDAO.Insert(
                new TaskType("Hobby", 1, "✨", Color.GREEN),
                new TaskType("Study", 2, "📚", Color.BLUE),
                new TaskType("Important", 3, "‼", Color.RED)
        );

        ArrayList<Task> tasks = new ArrayList<>();

        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            tasks.addAll(Arrays.asList(
                    new Task(
                            "CS310 Midterm1", "Midterm at LO65 from 9am",
                            dateFormat.parse("06/04/2019")
                    ),
                    new Task(
                            "Room meeting", "Meet Mr. Mbape before things get worse",
                            dateFormat.parse("07/04/2019")
                    ),
                    new Task(
                            "CS310 Midterm1 Objection", "Room LO65 from 10am ",
                            dateFormat.parse("06/05/2019")
                    ),
                    new Task(
                            "CS308 Project presentation", "4th sprint user-inteface design",
                            dateFormat.parse("09/04/2019")
                    ),
                    new Task(
                            "Judiy's Funeral", "buy flowers",
                            dateFormat.parse("31/03/2019")
                    ),
                    new Task(
                            "Avengers release", "Invite roommates to watch it",
                            dateFormat.parse("02/04/2019")
                    ),
                    new Task(
                            "Job application", "Ware the black suit",
                            dateFormat.parse("05/05/2019")
                    ),
                    new Task(
                            "Google's interview", "Focus on software engineering nothing else matters",
                            dateFormat.parse("06/04/2019")
                    ),
                    new Task(
                            "Summer school starts", "Nothing special",
                            dateFormat.parse("06/04/2019")
                    ),
                    new Task(
                            "MS application deadline", "now or never",
                            dateFormat.parse("08/05/2019")
                    ),
                    new Task(
                            "Make plane reservation", "Most preferably Turkish Airlines",
                            dateFormat.parse("29/03/2019")
                    ),
                    new Task(
                            "Trip to Africa", "Dont miss your plane",
                            dateFormat.parse("06/04/2019")
                    ),
                    new Task(
                            "See the dentist", "Midterm at LO65 from 9am",
                            dateFormat.parse("06/05/2019")
                    )
            ));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        TaskDAO taskDAO = GetTaskDAO();

        List<TaskType> taskTypes = taskTypeDAO.GetAll();

        Random rand = new Random();
        for (Task task : tasks)
        {
            TaskType randomTaskType = taskTypes.get(rand.nextInt(taskTypes.size()));
            taskDAO.InsertTaskWithType(randomTaskType, task);
        }
    }

    public abstract TaskDAO GetTaskDAO();

    public abstract TaskTypeDAO GetTaskTypeDAO();
}
