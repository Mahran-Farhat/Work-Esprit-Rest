package com.funsoft.cabinet.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // dans le cas ou l'exception déclanchée est de type ResourceNotFound
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> resource_not_found(ResourceNotFound e){
        //
        return  null;
    }
}
