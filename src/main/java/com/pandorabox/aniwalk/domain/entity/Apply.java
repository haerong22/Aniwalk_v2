package com.pandorabox.aniwalk.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Apply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walking_id")
    private Walking walking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "walker_id")
    private Walker walker;

    @CreationTimestamp
    private LocalDateTime applyDate;
}
