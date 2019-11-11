package com.system.eas.service;

import java.time.LocalDate;
import java.util.List;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Task;
import com.system.eas.repository.EmployeeRepository;
import com.system.eas.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id: " + taskId));
        taskRepository.delete(task);
    }    

    public Task getTaskById(Long taskId) throws ResourceNotFoundException {
        return taskRepository.findById(taskId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id: " + taskId));
    }

    public List<Task> listAllTaskByDate(LocalDate date) {
        return taskRepository.findByTaskDate(date);
    }
        
    public List<Task> listAllTaskByEmployeeId(Long employeeId) {
        return taskRepository.findByEmployeeEmployeeId(employeeId);
    }

}