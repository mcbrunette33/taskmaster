package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bru.taskmaster.R;
import com.example.bru.taskmaster.activities.MainActivity;

public class TaskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent calledIntent = getIntent();
        String taskTitle = calledIntent.getStringExtra(MainActivity.TASK_TITLE);
        String taskBody = calledIntent.getStringExtra(MainActivity.TASK_BODY);
        String taskState = calledIntent.getStringExtra(MainActivity.TASK_STATE);
        TextView taskDetailHeader = findViewById(R.id.taskDetailHeader);
        TextView taskDetailBody = findViewById(R.id.taskDetailBody);
        TextView taskDetailState = findViewById(R.id.TaskDetailState);
        taskDetailHeader.setText(taskTitle);
        taskDetailBody.setText(taskBody);
        taskDetailState.setText(taskState);
    }
}