package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.example.bru.taskmaster.R;
import com.example.bru.taskmaster.adapter.TaskListRecViewAdapter;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //home page use this to set routing to other pages
    //style home page as you want
    SharedPreferences preferences;
    public static final String TASK_TITLE = "Task Title";
    public static final String TASK_BODY = "Task Body";
    public static final String TASK_STATE = "Task State";
    public static final String TAG = "mainactivity";


    List<Task> tasks = null;
    TaskListRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        tasks = new ArrayList<>();
        Amplify.API.query(
                ModelQuery.list(Task.class),
                success ->{
                    Log.i(TAG, "task success");
                    tasks.clear();
                    for(Task task : success.getData()){
                        tasks.add(task);
                    }
                    /*runOnUiThread(()->{
                        adapter.notifyDataSetChanged();
                    });*/
                },
                failure -> Log.i(TAG, "task not succeeded")
        );
        adapter = new TaskListRecViewAdapter(tasks, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tasks = new ArrayList<>();
        Amplify.API.query(
                ModelQuery.list(Task.class),
                success ->{
                    Log.i(TAG, "task success");
                    tasks.clear();
                    for(Task task : success.getData()){
                        tasks.add(task);
                    }
                    runOnUiThread(()->{
                        adapter.notifyDataSetChanged();
                    });
                },
                failure -> Log.i(TAG, "task not succeeded")
        );
        adapter = new TaskListRecViewAdapter(tasks, this);
        recyclerView.setAdapter(adapter);
    }
}