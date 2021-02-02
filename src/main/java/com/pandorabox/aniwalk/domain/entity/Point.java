package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Point {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    private int account;
    private Long memberId;
    private Long walkerId;
    private Long walkingId;

    @CreationTimestamp
    private LocalDateTime registryDate;
}
