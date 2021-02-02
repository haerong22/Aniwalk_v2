package com.pandorabox.aniwalk.domain.entity;

import javax.persistence.*;

@Entity
public class DogImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_img_id")
    private Long id;
    private String image;
}
