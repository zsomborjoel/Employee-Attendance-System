package com.system.api.eas.repository;

import static org.junit.Assert.assertNotNull;

import com.system.eas.Application;
import com.system.eas.model.Task;
import com.system.eas.repository.TaskRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class TaskRepositoryTransactionTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testTaskRepository() {
        assertNotNull(taskRepository);
    }

    @Test
    public void testSaveTask() {
        Task task = new Task();
        task.setTaskName("TestTask");
        taskRepository.save(task);
    }
 
    @Test
    public void testDeleteTask() {
        Task task = new Task();
        task.setTaskName("TestTask");
        taskRepository.save(task);
        taskRepository.delete(task);
    }

    @Test
    public void testFindAllTasks() {
        assertNotNull(taskRepository.findAll());
    }

    @Test
    public void testDeleteByTaskId() {
        Task task = new Task();
        task.setTaskName("TestTask");
        taskRepository.save(task);
        taskRepository.deleteById(task.getTaskId());
    }
}