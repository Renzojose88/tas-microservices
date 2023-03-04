package com.app.taskmicroservice.controller;

import com.app.taskmicroservice.entity.Task;
import com.app.taskmicroservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
