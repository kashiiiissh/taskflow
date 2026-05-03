package com.kashish.taskflow.entity;

import com.kashish.taskflow.enums.Priority;
import com.kashish.taskflow.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Builder.Default
    @Enumerated(EnumType.STRING)
     private TaskStatus status = TaskStatus.TODO;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    private LocalDateTime dueDate;

    // Many tasks belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}