package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.network.request.member.MemberJoinReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String kakaoId;
    private Integer point;
    private String phone;

    @Column(length = 1000)
    private String profileImg;

    @OneToMany(mappedBy = "member")
    List<Dog> dogList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    List<Walking> walkingList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime joinDate;



    @PrePersist
    private void prePersist() {
        point = point == null ? 0 : point;
    }

    public static Member of(MemberJoinReq memberJoinReq) {
        return Member.builder()
                .nickname(memberJoinReq.getNickname())
                .kakaoId(memberJoinReq.getKakaoId())
                .phone(memberJoinReq.getPhone())
                .profileImg(memberJoinReq.getProfileImg())
                .build();
    }
}
