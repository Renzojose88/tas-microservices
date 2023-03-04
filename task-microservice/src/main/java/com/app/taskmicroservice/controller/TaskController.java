package com.app.taskmicroservice.controller;

import com.app.taskmicroservice.entity.Task;
import com.app.taskmicroservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task/v1")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task taskresponse = taskService.addTask(task);
        return new ResponseEntity<>(taskresponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<Task>> getAllTask(){
        List<Task> lstTask = taskService.getTaskAll();
        if(lstTask.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lstTask,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable("id") long idTask){
        taskService.deleteTask(idTask);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id){
        Optional<Task> task = taskService.getTaskById(id);
        return new ResponseEntity<>(task.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task taskBody){
        Task taskUpdate = taskService.updateTask(id,taskBody);
        return new ResponseEntity<>(taskUpdate, HttpStatus.NO_CONTENT);
    }

}
