package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.network.request.member.MemberJoinReq;
import com.pandorabox.aniwalk.domain.network.request.SearchReq;
import com.pandorabox.aniwalk.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<?> findMember(SearchReq searchReq) {
        return ResponseEntity.ok().body(CommonResponse.ok(memberService.getMemberList(searchReq)));
    }

    @PostMapping("/member")
    public ResponseEntity<?> save(@RequestBody @Valid MemberJoinReq memberJoinReq, BindingResult bindingResult) {
        return ResponseEntity.ok().body(CommonResponse.created(memberService.save(memberJoinReq)));
    }

}
