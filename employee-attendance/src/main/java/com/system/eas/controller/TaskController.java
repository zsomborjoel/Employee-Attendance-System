package com.system.eas.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.system.eas.exception.ResourceNotFoundException;
import com.system.eas.model.Task;
import com.system.eas.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/employees/{employee_id}/task")
    public void addTask(@PathVariable(value = "employee_id") Long employeeId, @Valid @RequestBody Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping("/tasks/{task_id}")
    public void deleteTask(@PathVariable(value = "task_id") Long taskId) throws ResourceNotFoundException {
        taskService.deleteTask(taskId);
    }

    @GetMapping("/tasks/{task_id}")
    public Task getTaskById(@PathVariable(value = "task_id") Long taskId) throws ResourceNotFoundException {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasks/{task_date}")
    public List<Task> listAllTaskByDate(@PathVariable(value = "task_date") LocalDate date) {
        return taskService.listAllTaskByDate(date);
    }

    @GetMapping("/employees/{employee_id}/tasks")
    public List<Task> listAllTaskByEmployeeId(Long employeeId) {
        return taskService.listAllTaskByEmployeeId(employeeId);
    }

}