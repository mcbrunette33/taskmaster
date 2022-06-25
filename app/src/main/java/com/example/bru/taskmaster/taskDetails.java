package com.example.bru.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class taskDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent calledIntent = getIntent();
        String taskTitle = calledIntent.getStringExtra(MainActivity.TASKTITLE);
        TextView taskDetailHeader = findViewById(R.id.taskDetailHeader);
        taskDetailHeader.setText(taskTitle);
    }
}