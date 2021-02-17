package com.pandorabox.aniwalk.domain.network.response;

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

}
