package com.example.bru.taskmaster.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bru.taskmaster.R;
import com.example.bru.taskmaster.activities.MainActivity;
import com.example.bru.taskmaster.activities.TaskDetails;
import com.example.bru.taskmaster.models.Tasks;

import java.util.List;

public class TaskListRecViewAdapter extends RecyclerView.Adapter<TaskListRecViewAdapter.TaskListViewHolder> {
    List<Tasks> tasks;
    Context callingActivity;

    public TaskListRecViewAdapter(List<Tasks> _tasks, Context _callingActivity) {
        this.tasks = _tasks;
        this.callingActivity = _callingActivity;
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task_list, parent, false);
        return new TaskListViewHolder(taskFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TextView fragmentTaskList = holder.itemView.findViewById(R.id.TaskListFrag);
        String taskTitle = tasks.get(position).getTitle();
        String taskBody = tasks.get(position).getBody();
        String taskState = tasks.get(position).getState().toString();
        fragmentTaskList.setText("-" + taskTitle);

        View taskView = holder.itemView;
        taskView.setOnClickListener(v -> {
            Intent goToTaskDetail = new Intent(callingActivity, TaskDetails.class);
            goToTaskDetail.putExtra(MainActivity.TASK_TITLE, taskTitle);
            goToTaskDetail.putExtra(MainActivity.TASK_BODY, taskBody);
            goToTaskDetail.putExtra(MainActivity.TASK_STATE, taskState);
            callingActivity.startActivity(goToTaskDetail);
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class TaskListViewHolder extends RecyclerView.ViewHolder{
        public TaskListViewHolder(View fragmentTaskView){
            super(fragmentTaskView);
        }
    }
}
