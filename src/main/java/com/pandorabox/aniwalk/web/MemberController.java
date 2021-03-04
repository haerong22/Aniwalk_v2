package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.entity.Member;
import com.pandorabox.aniwalk.domain.network.request.member.MemberJoinReq;
import com.pandorabox.aniwalk.domain.network.request.member.MemberSearchReq;
import com.pandorabox.aniwalk.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<?> findAll(MemberSearchReq memberSearchReq) {
        return ResponseEntity.ok().body(memberService.getMember(memberSearchReq));
    }

    @PostMapping("/member")
    public ResponseEntity<?> save(@RequestBody @Valid MemberJoinReq memberJoinReq, BindingResult bindingResult) {
        return ResponseEntity.ok().body(CommonResponse.created(memberService.save(memberJoinReq)));
    }

}
