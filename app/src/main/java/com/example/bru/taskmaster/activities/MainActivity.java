package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/*import com.example.bru.taskmaster.Database.TaskMasterDatabase;*/
import com.example.bru.taskmaster.R;
import com.example.bru.taskmaster.adapter.TaskListRecViewAdapter;
/*import com.example.bru.taskmaster.models.Tasks;*/

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //home page use this to set routing to other pages
    //style home page as you want
    SharedPreferences preferences;
    public static final String TASK_TITLE = "Task Title";
    public static final String TASK_BODY = "Task Body";
    public static final String TASK_STATE = "Task State";
/*
    public static final String DATABASE_NAME = "taskslist";
*/
    List<Tasks> tasks = null;
    TaskListRecViewAdapter adapter;
    /*TaskMasterDatabase taskMasterDatabase;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* taskMasterDatabase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskMasterDatabase.class,
                        DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();*/
       /* tasks = taskMasterDatabase.taskDao().findAll();*/

        Button addTaskButton = MainActivity.this.findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v ->{
            Intent addTaskIntent = new Intent(MainActivity.this, AddTask.class);
            //intent is routing in () are where it is from to where it is going
            startActivity(addTaskIntent);
            // starts the activity of the intent(routing) (activity = view)
        });

        Button allTasksButton = MainActivity.this.findViewById(R.id.allTasks);
        allTasksButton.setOnClickListener(v ->{
            Intent allTasksIntent = new Intent(MainActivity.this, AllTasks.class);
            startActivity(allTasksIntent);
        });

        ImageButton userDetailButton = MainActivity.this.findViewById(R.id.userDetailButton);
        userDetailButton.setOnClickListener(v ->{
            Intent userDetailIntent = new Intent(MainActivity.this, UserDetail.class);
            startActivity(userDetailIntent);
        });
        Button taskDetailsButton = MainActivity.this.findViewById(R.id.taskDetailsButton);
        taskDetailsButton.setOnClickListener(v ->{
            Intent taskDetailsIntent = new Intent(MainActivity.this, TaskDetails.class);
            startActivity(taskDetailsIntent);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TaskListRecViewAdapter(tasks, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tasks.clear();
    /*    tasks.addAll(taskMasterDatabase.taskDao().findAll());*/
        adapter.notifyDataSetChanged();
    }
}