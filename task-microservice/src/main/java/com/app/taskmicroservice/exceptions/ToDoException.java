package com.app.taskmicroservice.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Data
public class ToDoException extends RuntimeException{
    private  String message;

    private HttpStatus httpStatus;

    public ToDoException(String message,HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;

    }
}
