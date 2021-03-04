package com.pandorabox.aniwalk.domain.network.response.walker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.domain.entity.enumtype.ApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalkerListResp {

    private String name;
    private String phone;
    private String email;

    private String location1;
    private String location2;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyDate;
    private ApplyStatus applyStatus;

    public static WalkerListResp of(Walker walker) {
        return WalkerListResp.builder()
                .name(walker.getName())
                .phone(walker.getPhone())
                .email(walker.getEmail())
                .location1(walker.getLocation1())
                .location2(walker.getLocation2())
                .applyDate(walker.getApplyDate())
                .applyStatus(walker.getApplyStatus())
                .build();
    }
}
