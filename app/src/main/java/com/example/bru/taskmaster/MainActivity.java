package com.example.bru.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //home page use this to set routing to other pages
    //style home page as you want

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

        Button userDetailButton = MainActivity.this.findViewById(R.id.userDetailButton);
        userDetailButton.setOnClickListener(v ->{
            Intent userDetailIntent = new Intent(MainActivity.this, userDetail.class);
            startActivity(userDetailIntent);
        });
    }
}