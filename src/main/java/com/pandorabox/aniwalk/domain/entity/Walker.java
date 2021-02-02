package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.entity.enumtype.ActiveStatus;
import com.pandorabox.aniwalk.domain.entity.enumtype.ApplyStatus;
import com.pandorabox.aniwalk.domain.entity.enumtype.EventAgree;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Walker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walker_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;
    private String password;

    @Column(nullable = false)
    private String phone;
    private LocalDateTime birth;
    private String email;
    private String address;

    @Column(length = 1000)
    private String profileImg1;
    @Column(length = 1000)
    private String profileImg2;
    @Column(length = 1000)
    private String profileImg3;

    private String location1;
    private String location2;

    @Column(length = 3000)
    private String intro;
    private int point;

    @OneToMany(mappedBy = "walker")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "walker")
    private List<Walking> walkingList;

    private LocalDateTime activeStartDate;
    private LocalDateTime applyDate;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
    @Enumerated(EnumType.STRING)
    private EventAgree eventAgree;
    @Enumerated(EnumType.STRING)
    private ApplyStatus applyStatus;

}
