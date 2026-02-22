package com.unipds.unipds;

import com.unipds.unipds.dto.ErrorDTO;
import com.unipds.unipds.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(NotFoundException ex){

        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }
}
