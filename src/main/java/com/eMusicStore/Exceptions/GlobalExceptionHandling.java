package com.eMusicStore.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandling {
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @ExceptionHandler
    public ResponseEntity<ProductResponseEntity> handleProductNotFound(ProductNotFound ex) {
        ProductResponseEntity entity = new ProductResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND.value(), timestamp);
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductResponseEntity> handleProductNotFound(IllegalArgumentException ex) {
        ProductResponseEntity entity = new ProductResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), timestamp);
        return new ResponseEntity<>(entity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProductResponseEntity> handleGlobalProductNotFound(Exception ex) {
        ProductResponseEntity entity = new ProductResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), timestamp);
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
