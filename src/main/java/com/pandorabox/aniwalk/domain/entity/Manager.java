package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.domain.network.request.manager.ManagerReq;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Manager {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @Column(unique = true)
    private String nickname;
    private String password;

    public Manager(ManagerReq managerReq){
        nickname = managerReq.getNickname();
        password = managerReq.getPassword();
    }
}
