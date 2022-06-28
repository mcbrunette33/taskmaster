package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.bru.taskmaster.R;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTasks = AddTask.this.findViewById(R.id.addTasks);
        addTasks.setOnClickListener(v ->{
            TextView submitText = AddTask.this.findViewById(R.id.submitText);
            submitText.setText("submitted");
        });
    }
}