package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Lob
    private String content;

    private String score;

    @CreationTimestamp
    private LocalDateTime reviewDate;

    @OneToOne(mappedBy = "review")
    private Walking walking;
}
