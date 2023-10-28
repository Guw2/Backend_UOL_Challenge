package com.lorian.uolchallenge.exceptions;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lorian.uolchallenge.exceptions.throwable.NoCodinomeLeftException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(NoCodinomeLeftException.class)
    public ResponseEntity<ExceptionFactory> noCodinomeLeft(
        NoCodinomeLeftException e, HttpServletRequest request){
        ExceptionFactory exception = new ExceptionFactory();

        Integer status = HttpStatus.NOT_FOUND.value();
        exception.setTimestamp(LocalDateTime.now());
        exception.setStatus(status);
        exception.setError("Os codinomes estão esgotados.");
        exception.setMessage(e.getMessage());
        exception.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(exception);
    }

}
