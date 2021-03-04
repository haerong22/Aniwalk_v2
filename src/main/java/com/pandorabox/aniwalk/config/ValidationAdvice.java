package com.pandorabox.aniwalk.config;

import com.pandorabox.aniwalk.domain.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class ValidationAdvice {

    @Around("execution(* com.pandorabox.aniwalk.web..*.*(..))")
    public Object validationCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String method =proceedingJoinPoint.getSignature().getName();

        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        Map<String, String> errorMap = new HashMap<>();
        Arrays.stream(args)
                .filter(v -> v instanceof BindingResult)
                .filter(v -> ((BindingResult) v).hasErrors())
                .forEach(v -> ((BindingResult) v).getFieldErrors()
                        .forEach(error -> {
                            errorMap.put(error.getField(), error.getDefaultMessage());
                            String msg = type + "." + method + "() => 필드 : " + error.getField() + ", 메시지 : " + error.getDefaultMessage();
                            log.warn(msg);
                        }));

        return errorMap.isEmpty() ? proceedingJoinPoint.proceed() : ResponseEntity.badRequest().body(CommonResponse.badRequest(errorMap));
    }
}

