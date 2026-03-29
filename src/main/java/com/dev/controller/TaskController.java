package com.dev.controller;

import com.dev.model.Task;
import com.dev.repository.TaskRepository;
import com.dev.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController { 
	
	@Autowired
	private TaskService taskService;  

    @Autowired
    private TaskRepository taskRepository;  
    
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }
    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }  
    @GetMapping("/add")
    public String addSampleTask() {
        Task task = new Task();
        task.setTitle("First Task");
        task.setStatus("PENDING");
        taskService.addTask(task);
        return "Task added";
    } 

    @PostMapping
    public Task addTask(@RequestBody Task task) { 
        return taskService.addTask(task);
    }
    
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    } 
    
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    } 
}   
 