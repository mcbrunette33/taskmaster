package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.bru.taskmaster.R;
import com.example.bru.taskmaster.models.StateEnum;
import com.example.bru.taskmaster.models.Tasks;

public class AddTask extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        setUpSpinner();
/*        setUpAddButton(taskMasterDatabase);*/
    }
    public void setUpSpinner(){
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                StateEnum.values()
        ));
    }
    public void setUpAddButton(){
        Button addTasks = AddTask.this.findViewById(R.id.addTasks);
        Spinner spinner = findViewById(R.id.spinner);
        addTasks.setOnClickListener(v ->{
            String TitleInput = ((EditText)findViewById(R.id.TitleInput)).getText().toString();
            String BodyInput = ((EditText)findViewById(R.id.BodyInput)).getText().toString();
            StateEnum stateEnum = StateEnum.fromString(spinner.getSelectedItem().toString());
            Tasks newTasks = new Tasks(TitleInput, BodyInput, stateEnum);
            Toast.makeText(AddTask.this, "task added", Toast.LENGTH_SHORT).show();
        });
    }
}