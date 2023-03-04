package com.app.taskmicroservice.service;


import com.app.taskmicroservice.entity.Task;
import com.app.taskmicroservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired //es una dependencia que debe usarse en esta clase
    TaskRepository taskRepository;

    public Task addTask(Task taskRequest){
        taskRequest.setCreateDate(LocalDateTime.now());
        taskRequest.setActive(true);
       Task task = taskRepository.save(taskRequest);
       return task;
    }

    public List<Task> getTaskAll(){
        return taskRepository.findAll();
    }

    public void deleteTask(Long idTask){
        taskRepository.deleteById(idTask);
    }

}
