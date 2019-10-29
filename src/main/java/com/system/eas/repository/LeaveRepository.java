package com.system.eas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.eas.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {

}