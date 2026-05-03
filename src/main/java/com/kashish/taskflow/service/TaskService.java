package com.kashish.taskflow.service;

import com.kashish.taskflow.entity.Task;
import com.kashish.taskflow.entity.User;
import com.kashish.taskflow.repository.TaskRepository;
import com.kashish.taskflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    // GET TASKS
    public List<Task> getTasksByEmail(String email) {
        return taskRepository.findByUserEmail(email);
    }

    // CREATE TASK
    public Task createTask(Task task, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setUser(user);
        return taskRepository.save(task);
    }

    // DELETE TASK
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}