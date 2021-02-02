package com.pandorabox.aniwalk.domain.entity;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String kakaoId;
    private int point;
    private String phone;
    private String profileImg;
}
