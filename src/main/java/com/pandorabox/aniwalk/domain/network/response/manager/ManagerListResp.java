package com.pandorabox.aniwalk.domain.network.response.manager;

import com.pandorabox.aniwalk.domain.entity.Manager;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerListResp {

    private String nickname;
    private LocalDateTime regDate;

    public static ManagerListResp of(Manager manager) {
        return ManagerListResp.builder()
                .nickname(manager.getNickname())
                .regDate(manager.getRegDate())
                .build();
    }
}
