package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DogImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_img_id")
    private Long id;

    @Column(length = 1000)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
