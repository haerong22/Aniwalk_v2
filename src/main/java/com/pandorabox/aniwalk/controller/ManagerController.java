package com.pandorabox.aniwalk.controller;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.network.request.ManagerReq;
import com.pandorabox.aniwalk.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping ("/manager")
    public CommonResponse<?> save(@RequestBody @Valid ManagerReq managerReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors()
                    .forEach((error)-> errorMap.put(error.getField(), error.getDefaultMessage()));
            return new CommonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMap);
        }
        managerService.save(managerReq);
        return new CommonResponse<>(HttpStatus.OK.value(), "ok");
    }
}
