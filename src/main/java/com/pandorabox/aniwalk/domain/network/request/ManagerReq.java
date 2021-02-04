package com.pandorabox.aniwalk.domain.network.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerReq {

    @Length(max = 20, message = "최대 길이를 초과하였습니다.")
    @NotBlank(message = "관리자 닉네임을 입력하세요.")
    private String nickname;

    @NotBlank(message = "관리자 비밀번호를 입력하세요.")
    private String password;
}
