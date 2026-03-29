package com.dev.service;

import com.dev.model.Task;
import com.dev.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository; 
    
    
    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    } 

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(newTask.getTitle());
        task.setStatus(newTask.getStatus());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
} 