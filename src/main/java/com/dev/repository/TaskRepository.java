package com.dev.repository;

import com.dev.model.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> { 
	
	   List<Task> findByStatus(String status);  
	
} 