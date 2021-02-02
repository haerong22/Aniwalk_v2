package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Certificate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long id;

    @Column(length = 1000)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walker_id")
    private Walker walker;
}
