package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Manager {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    private String nickname;
    private String password;
}
