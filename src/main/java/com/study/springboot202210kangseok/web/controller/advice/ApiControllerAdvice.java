package com.study.springboot202210kangseok.web.controller.advice;

import com.study.springboot202210kangseok.web.dto.CMRespDto;
import com.study.springboot202210kangseok.web.exception.CustomTestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 예외가 발생할 때 예외처리.
public class ApiControllerAdvice {

    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testException(CustomTestException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }
}
