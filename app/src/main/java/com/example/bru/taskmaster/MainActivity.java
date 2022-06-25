package com.example.bru.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //home page use this to set routing to other pages
    //style home page as you want
    SharedPreferences preferences;
    public static final String TASKTITLE = "taskTitle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTaskButton = MainActivity.this.findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v ->{
            Intent addTaskIntent = new Intent(MainActivity.this, addTask.class);
            //intent is routing in () are where it is from to where it is going
            startActivity(addTaskIntent);
            // starts the activity of the intent(routing) (activity = view)
        });

        Button allTasksButton = MainActivity.this.findViewById(R.id.allTasks);
        allTasksButton.setOnClickListener(v ->{
            Intent allTasksIntent = new Intent(MainActivity.this, allTasks.class);
            startActivity(allTasksIntent);
        });

        ImageButton userDetailButton = MainActivity.this.findViewById(R.id.userDetailButton);
        userDetailButton.setOnClickListener(v ->{
            Intent userDetailIntent = new Intent(MainActivity.this, userDetail.class);
            startActivity(userDetailIntent);
        });
        Button taskDetailsButton = MainActivity.this.findViewById(R.id.taskDetailsButton);
        taskDetailsButton.setOnClickListener(v ->{
            Intent taskDetailsIntent = new Intent(MainActivity.this, taskDetails.class);
            startActivity(taskDetailsIntent);
        });

        TextView taskOne = findViewById(R.id.taskOne);
        taskOne.setOnClickListener(v -> {
            Intent taskOneIntent = new Intent(MainActivity.this, taskDetails.class);
            String taskString = taskOne.getText().toString();
            taskOneIntent.putExtra(TASKTITLE, taskString);
            startActivity(taskOneIntent);
        });
    }
}