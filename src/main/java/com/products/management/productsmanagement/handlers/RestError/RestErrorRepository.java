package com.products.management.productsmanagement.handlers.RestError;

import java.util.Locale;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestErrorRepository {

    @ExceptionHandler(HandlerError.class)
    public ResponseEntity<Object> handleApplicationException(HandlerError e) {
        return ResponseEntity.status(e.getCustomError().getCode()).body(e.getCustomError());
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handle(Exception e, Locale locale) {
        return ResponseEntity.status(400)
                .body(new CustomError(400, e.getMessage(), "this is the cause that the user will see"));
    }
}