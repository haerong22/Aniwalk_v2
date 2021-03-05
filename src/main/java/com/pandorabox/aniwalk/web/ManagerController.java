package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.network.request.manager.ManagerJoinReq;
import com.pandorabox.aniwalk.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/manager")
    public ResponseEntity<?> save(@RequestBody @Valid ManagerJoinReq managerJoinReq, BindingResult bindingResult) {
        return ResponseEntity.ok().body(CommonResponse.created(managerService.save(managerJoinReq)));
    }

    @GetMapping("/manager")
    public ResponseEntity<?> getManagers() {
        return ResponseEntity.ok().body(CommonResponse.ok(managerService.findAll()));
    }

}
