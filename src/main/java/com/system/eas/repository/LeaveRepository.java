package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.eas.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    
}