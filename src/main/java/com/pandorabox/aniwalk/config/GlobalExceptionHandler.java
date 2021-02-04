package com.pandorabox.aniwalk.config;

import com.pandorabox.aniwalk.domain.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> globalException(Exception e) {
        return new CommonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
