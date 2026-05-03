package com.kashish.taskflow.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UpdateTaskRequest {
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;
}