package com.system.eas.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.system.eas.model.Task;

@Repository
public interface TaskRepository {
    
    void addTask(Task task);

    void deleteTask(Long taskId);

    Optional<Task> getTaskById(Long taskId);

    List<Task> listAllTaskByDate(String date);

}