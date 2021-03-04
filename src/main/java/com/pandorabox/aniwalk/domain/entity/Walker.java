package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.entity.enumtype.ActiveStatus;
import com.pandorabox.aniwalk.domain.entity.enumtype.ApplyStatus;
import com.pandorabox.aniwalk.domain.entity.enumtype.EventAgree;
import com.pandorabox.aniwalk.domain.network.request.walker.WalkerJoinReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Walker {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walker_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String nickname;
    private String password;

    @Column(nullable = false)
    private String phone;
    private LocalDate birth;
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
    private Integer point;

    @OneToMany(mappedBy = "walker")
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "walker")
    private List<Walking> walkingList;

    private LocalDateTime activeStartDate;

    @CreationTimestamp
    private LocalDateTime applyDate;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;
    @Enumerated(EnumType.STRING)
    private EventAgree eventAgree;
    @Enumerated(EnumType.STRING)
    private ApplyStatus applyStatus;

    @PrePersist
    private void prePersist() {
        point = point == null ? 0 : point;
        eventAgree = eventAgree == null ? EventAgree.AGREE : eventAgree;
        applyStatus = applyStatus == null ? ApplyStatus.WAITING : applyStatus;
    }

    public static Walker of(WalkerJoinReq walkerJoinReq) {
        return Walker.builder()
                .eventAgree(walkerJoinReq.getEventAgree())
                .name(walkerJoinReq.getName())
                .phone(walkerJoinReq.getPhone())
                .birth(walkerJoinReq.getBirth())
                .address(walkerJoinReq.getAddress())
                .email(walkerJoinReq.getEmail())
                .intro(walkerJoinReq.getIntro())
                .location1(walkerJoinReq.getLocation1())
                .build();
    }

}
