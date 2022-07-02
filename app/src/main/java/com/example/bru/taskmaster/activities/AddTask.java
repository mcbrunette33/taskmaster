package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.StateEnum;
import com.amplifyframework.datastore.generated.model.Task;

import com.example.bru.taskmaster.R;



public class AddTask extends AppCompatActivity {


    public static final String TAG = "AddTask";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        setUpSpinner();
        setUpAddButton();
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
            Task newTask = Task.builder()
                            .title(TitleInput)
                            .body(BodyInput)
                            .state((StateEnum) spinner.getSelectedItem())
                                    .build();
            Amplify.API.mutate(
                    ModelMutation.create(newTask),
                    successResponse ->{
                        Log.i(TAG, "added new task");
                    },
                    failureResponse -> Log.i(TAG, "task not added" + failureResponse)
            );
            Toast.makeText(AddTask.this, "task added", Toast.LENGTH_SHORT).show();
        });
    }
}