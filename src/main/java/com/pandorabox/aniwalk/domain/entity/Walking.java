package com.pandorabox.aniwalk.domain.entity;

import javax.persistence.*;

@Entity
public class Walking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walking_id")
    private Long id;

    
}
