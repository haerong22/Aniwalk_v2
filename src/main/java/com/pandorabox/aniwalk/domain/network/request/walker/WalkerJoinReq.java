package com.pandorabox.aniwalk.domain.network.request.walker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pandorabox.aniwalk.domain.entity.enumtype.EventAgree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalkerJoinReq {

    @NotNull
    private EventAgree eventAgree;

    @NotBlank(message = "이름은 필수 항목 입니다.")
    private String name;

    @NotBlank(message = "휴대폰 번호는 필수 항목 입니다.")
    private String phone;

    @NotNull
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate birth;

    @NotBlank(message = "거주지 주소는 필수 항목 입니다.")
    private String address;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일 주소 필수 항목 입니다.")
    private String email;

    @NotBlank(message = "자기소개는 필수 항목 입니다.")
    private String intro;

    @NotBlank(message = "활동지역은 필수 항목 입니다.")
    private String location1;
}
