package com.study.springboot202210kangseok.aop;

import com.study.springboot202210kangseok.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210kangseok.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut() {

    }

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;

        for (Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if (bindingResult != null) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });

            throw new CustomValidException(errorMap);
        }

        //메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed(); // proceed 비즈니스 로직 // 내가 지정한 메소드
        // 메소드 호출 후 처리
        return returnValue;
    }


}
