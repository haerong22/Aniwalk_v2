package com.pandorabox.aniwalk.domain.network.request.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinReq {

    @NotBlank(message = "닉네임은 필수 항목입니다.")
    private String nickname;

    @NotBlank(message = "카카오아이디는 필수 항목입니다.")
    private String kakaoId;

    @NotBlank(message = "휴대폰 번호는 필수 항목입니다.")
    private String phone;

    @NotBlank(message = "프로필은 필수 항목입니다.")
    private String profileImg;

}
