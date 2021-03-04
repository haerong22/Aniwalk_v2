package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.network.request.manager.ManagerJoinReq;
import com.pandorabox.aniwalk.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/manager")
    public CommonResponse<?> save(@RequestBody @Valid ManagerJoinReq managerJoinReq, BindingResult bindingResult) {
        managerService.save(managerJoinReq);
        return new CommonResponse<>(HttpStatus.OK.value(), "ok");
    }

}
