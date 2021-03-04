package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.domain.network.request.SearchReq;
import com.pandorabox.aniwalk.domain.network.request.walker.WalkerJoinReq;
import com.pandorabox.aniwalk.service.WalkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WalkerController {

    private final WalkerService walkerService;

    @GetMapping("/walker")
    public ResponseEntity<?> findWalker(SearchReq searchReq) {
        return ResponseEntity.ok().body(CommonResponse.ok(walkerService.getWalkerList(searchReq)));
    }

    @PostMapping("/walker")
    public ResponseEntity<?> joinWalker(@RequestBody @Valid WalkerJoinReq walkerJoinReq, BindingResult bindingResult) {
        return ResponseEntity.ok().body(CommonResponse.created(walkerService.save(walkerJoinReq)));
    }
}
