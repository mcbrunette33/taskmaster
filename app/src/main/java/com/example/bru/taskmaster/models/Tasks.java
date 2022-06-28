package com.example.bru.taskmaster.models;

public class Tasks {

    String title;
    String body;
    String state;

    public Tasks() {
    }

    public Tasks(String title) {
        this.title = title;
    }

    public Tasks(String _title, String _body, String _state) {
        this.title = _title;
        this.body = _body;
        this.state = _state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
