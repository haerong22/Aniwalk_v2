package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.entity.enumtype.RecruitStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Walking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walking_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walker_id")
    private Walker walker;

    @OneToMany(mappedBy = "walking")
    private List<WalkingMission> walkingMission;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(length = 1000)
    private String recruitNotices;

    @Column(length = 1000)
    private String location;

    private int walkingPoint;

    @Column(length = 1000)
    private String mapCaptureImg;

    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus;

    @Lob
    private String walkingPath;

    @CreationTimestamp
    private LocalDateTime recruitDate;

    private LocalDateTime walkingDate;
    private LocalDateTime walkingStartTime;
    private LocalDateTime walkingEndTime;
    private LocalDateTime realWalkingStartTime;
    private LocalDateTime realWalkingEndTime;
}
