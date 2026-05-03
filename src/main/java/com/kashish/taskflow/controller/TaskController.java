package com.kashish.taskflow.controller;

import com.kashish.taskflow.entity.Task;
import com.kashish.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // GET TASKS
    @GetMapping
    public List<Task> getTasks(@AuthenticationPrincipal String email) {
        return taskService.getTasksByEmail(email);
    }

    // CREATE TASK
    @PostMapping
    public Task createTask(
            @RequestBody Task task,
            @AuthenticationPrincipal String email
    ) {
        return taskService.createTask(task, email);
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}