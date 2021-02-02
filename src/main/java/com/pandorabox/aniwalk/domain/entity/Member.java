package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.entity.enumtype.RoleType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String kakaoId;
    private int point;
    private String phone;

    @Column(length = 1000)
    private String profileImg;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "member")
    List<Dog> dogList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    List<Walking> walkingList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime joinDate;

}
