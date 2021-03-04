package com.pandorabox.aniwalk.service;

import com.pandorabox.aniwalk.domain.entity.Member;
import com.pandorabox.aniwalk.domain.network.request.member.MemberJoinReq;
import com.pandorabox.aniwalk.domain.network.request.member.MemberSearchReq;
import com.pandorabox.aniwalk.domain.network.response.member.MemberListResp;
import com.pandorabox.aniwalk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public Page<MemberListResp> getMember(MemberSearchReq memberSearchReq) {
        Page<Member> result = memberRepository.findByNicknameContains(
                memberSearchReq.getSearch(),
                PageRequest.of(memberSearchReq.getPage() - 1, 5, Sort.by("id").descending())
        );
        return new PageImpl<>(
                result.stream().map(MemberListResp::of).collect(Collectors.toList()),
                result.getPageable(),
                result.getTotalElements()
        );
    }

    @Transactional
    public String save(MemberJoinReq memberJoinReq) {
        Member save = memberRepository.save(Member.of(memberJoinReq));
        return save.getNickname();
    }
}

