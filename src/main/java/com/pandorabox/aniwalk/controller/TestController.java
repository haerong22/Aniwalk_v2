package com.pandorabox.aniwalk.controller;

import com.pandorabox.aniwalk.domain.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public CommonResponse<String> test() {
        
        return new CommonResponse<>(HttpStatus.OK.value(), "테스트");
    }
}
