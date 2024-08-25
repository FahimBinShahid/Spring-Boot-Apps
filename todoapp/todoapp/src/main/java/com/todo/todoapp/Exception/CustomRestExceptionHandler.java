package com.todo.todoapp.Exception;
import com.todo.todoapp.Exception.Model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiError> handleNoSuchElementException(NoSuchElementException ex) {

        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());

        return new ResponseEntity<>(new ApiError(HttpStatus.valueOf(400),"Failed", errors), HttpStatus.BAD_REQUEST);
    }
}