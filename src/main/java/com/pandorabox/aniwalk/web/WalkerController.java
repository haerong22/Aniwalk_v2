package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.domain.network.request.walker.WalkerJoinReq;
import com.pandorabox.aniwalk.service.WalkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class WalkerController {

    private final WalkerService walkerService;

    @PostMapping("/api/walker")
    public CommonResponse<?> joinWalker(@RequestBody @Valid WalkerJoinReq walkerJoinReq, BindingResult bindingResult) {
        System.out.println(walkerJoinReq);

        walkerService.save(Walker.of(walkerJoinReq));
        return new CommonResponse<>(HttpStatus.CREATED.value(), "OK");
    }
}
