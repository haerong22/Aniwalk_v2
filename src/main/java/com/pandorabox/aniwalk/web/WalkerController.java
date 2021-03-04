package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.domain.network.request.walker.WalkerJoinReq;
import com.pandorabox.aniwalk.service.WalkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WalkerController {

    private final WalkerService walkerService;

    @PostMapping("/walker")
    public ResponseEntity<?> joinWalker(@RequestBody @Valid WalkerJoinReq walkerJoinReq, BindingResult bindingResult) {
        return ResponseEntity.ok().body(CommonResponse.created(walkerService.save(walkerJoinReq)));
    }
}
