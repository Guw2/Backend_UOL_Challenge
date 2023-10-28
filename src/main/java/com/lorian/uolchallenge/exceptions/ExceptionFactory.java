package com.lorian.uolchallenge.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionFactory {
    
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
