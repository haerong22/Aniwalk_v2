package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Dog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dog_id")
    private Long id;
    private String name;
    private String type;
    private String size;

    @Column(length = 1000)
    private String info;
    private LocalDateTime birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "dog")
    private List<DogImg> dogImgList;

}
