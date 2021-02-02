package com.pandorabox.aniwalk.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Dog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private Long id;
    private String name;
    private String type;
    private String size;
    private String info;
    private LocalDateTime birth;
}
