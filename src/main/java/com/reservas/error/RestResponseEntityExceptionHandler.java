package com.reservas.error;

import com.reservas.error.dto.ErrorOptionalMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NullResponseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorOptionalMessage> nullResponseNotFoundException(NullResponseNotFoundException ex){
        ErrorOptionalMessage errorOptionalMessage = new ErrorOptionalMessage(HttpStatus.NOT_FOUND,ex.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorOptionalMessage);
    }
}
