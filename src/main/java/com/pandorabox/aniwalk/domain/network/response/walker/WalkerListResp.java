package com.pandorabox.aniwalk.domain.network.response.walker;

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

    private LocalDateTime applyDate;
    private ApplyStatus applyStatus;

}
