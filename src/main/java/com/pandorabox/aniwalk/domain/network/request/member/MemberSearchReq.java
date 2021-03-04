package com.pandorabox.aniwalk.domain.network.request.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberSearchReq {

    private int page = 1;

    private String search = "";
}
