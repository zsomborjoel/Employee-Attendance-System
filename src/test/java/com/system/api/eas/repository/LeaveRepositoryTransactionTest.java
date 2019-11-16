package com.system.api.eas.repository;

import static org.junit.Assert.assertNotNull;

import com.system.eas.Application;
import com.system.eas.model.Leave;
import com.system.eas.model.Task;
import com.system.eas.repository.LeaveRepository;
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
public class LeaveRepositoryTransactionTest {
    @Autowired
    private LeaveRepository leaveRepository;

    @Test
    public void testLeaveRepository() {
        assertNotNull(leaveRepository);
    }

    @Test
    public void testSaveLeave() {
        Leave leave = new Leave();
        leave.setLeaveDetail("TestLeave");
        leaveRepository.save(leave);
    }
 
    @Test
    public void testDeleteLeave() {
        Leave leave = new Leave();
        leave.setLeaveDetail("TestLeave");
        leaveRepository.save(leave);
        leaveRepository.delete(leave);
    }

    @Test
    public void testFindAllLeaves() {
        assertNotNull(leaveRepository.findAll());
    }

    @Test
    public void testDeleteByTaskId() {
        Leave leave = new Leave();
        leave.setLeaveDetail("TestLeave");
        leaveRepository.save(leave);
        leaveRepository.deleteById(leave.getLeaveId());
    }
}