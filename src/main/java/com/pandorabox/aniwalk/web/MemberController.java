package com.pandorabox.aniwalk.web;

import com.pandorabox.aniwalk.domain.CommonResponse;
import com.pandorabox.aniwalk.domain.entity.Member;
import com.pandorabox.aniwalk.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public CommonResponse<?> findAll(@RequestParam(defaultValue = "1") Integer page) {
        return new CommonResponse<>(HttpStatus.OK.value(), memberService.getMember(page));
    }

    @PostMapping("/member")
    public CommonResponse<?> save(Member member) {
        return new CommonResponse<>(HttpStatus.CREATED.value(), memberService.save(member));
    }

}
