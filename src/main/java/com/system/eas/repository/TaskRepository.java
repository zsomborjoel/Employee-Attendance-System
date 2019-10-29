package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.eas.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}