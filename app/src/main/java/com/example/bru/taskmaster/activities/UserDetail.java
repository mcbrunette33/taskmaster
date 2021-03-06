package com.example.bru.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bru.taskmaster.R;

public class UserDetail extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v ->{
            SharedPreferences.Editor userNameEditor = preferences.edit();
            EditText userName = findViewById(R.id.userName);
            String userNameString = userName.getText().toString();
            userNameEditor.putString(USERNAME, userNameString);
            Toast.makeText(UserDetail.this, "New Username", Toast.LENGTH_SHORT).show();

        });

    }

}