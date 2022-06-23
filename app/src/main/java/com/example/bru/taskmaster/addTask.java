package com.example.bru.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class addTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTasks = addTask.this.findViewById(R.id.addTasks);
        addTasks.setOnClickListener(v ->{
            TextView submitText = addTask.this.findViewById(R.id.submitText);
            submitText.setText("submitted");
        });
    }
}