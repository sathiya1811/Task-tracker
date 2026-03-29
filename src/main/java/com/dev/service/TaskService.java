package com.dev.service;

import com.dev.model.Task;
import java.util.List;

public interface TaskService { 
	
	List<Task> getTasksByStatus(String status);  

    Task addTask(Task task);

    List<Task> getAllTasks();

    Task updateTask(Long id, Task task); 
    
    void deleteTask(Long id); 
} 