package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.entity.enumtype.MissionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class WalkingMission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionType content;

    @Column(length = 2000)
    private String image;

    @Column(length = 1000)
    private String performLocation;

    @CreationTimestamp
    private LocalDateTime performTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walking_id")
    private Walking walking;

}
