package com.casa.mongospring.controller.exception;

import com.casa.mongospring.service.exception.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice  {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
        StandardError error = new StandardError();
        error.setStatus(404);
        error.setError("Not Found");
        error.setMessage(e.getMessage());
        error.setPath("/users/user/"+e.getId());
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(404).body(error);
    }
}
