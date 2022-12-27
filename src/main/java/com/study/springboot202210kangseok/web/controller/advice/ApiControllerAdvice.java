package com.study.springboot202210kangseok.web.controller.advice;

import com.study.springboot202210kangseok.web.dto.CMRespDto;
import com.study.springboot202210kangseok.web.exception.CustomTestException;
import com.study.springboot202210kangseok.web.exception.CustomValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // 예외가 발생할 때 예외처리.
public class ApiControllerAdvice {

    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testException(CustomTestException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e) {
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(e.getConstraintViolations());
        e.getConstraintViolations().forEach(error -> {
            String errorProperty = error.getPropertyPath().toString();
            errorProperty = errorProperty.substring(errorProperty.lastIndexOf(".")+1);
            errorMap.put(errorProperty, error.getMessage());
        });
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), errorMap));
    }

    @ExceptionHandler(CustomValidException.class)
    public ResponseEntity<?> validationError(CustomValidException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(),e.getErrorMap()));
    }
}
