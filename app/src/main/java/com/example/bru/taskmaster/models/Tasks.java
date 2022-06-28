package com.example.bru.taskmaster.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Tasks {
    @PrimaryKey(autoGenerate = true)
    long id;
    String title;
    String body;
    StateEnum state;

    public Tasks(String title, String body, StateEnum state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
