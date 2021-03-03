package com.pandorabox.aniwalk.domain.network.response.member;

import com.pandorabox.aniwalk.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberListResp {

    private String kakaoId;
    private String nickname;
    private String phone;

    public static MemberListResp of(Member member) {
        return MemberListResp.builder()
                .kakaoId(member.getKakaoId())
                .nickname(member.getNickname())
                .phone(member.getPhone())
                .build();
    }
}
