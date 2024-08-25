package com.todo.todoapp.Exception.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private HttpStatus code;
    private String message;
    private List<String> errors;

}