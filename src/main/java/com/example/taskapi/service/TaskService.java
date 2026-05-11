package com.example.taskapi.service;

import com.example.taskapi.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        task.setId((long) (tasks.size() + 1));
        tasks.add(task);
        return task;
    }
}