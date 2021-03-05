package com.pandorabox.aniwalk.domain.entity;

import com.pandorabox.aniwalk.Utils.PasswordUtils;
import com.pandorabox.aniwalk.domain.network.request.manager.ManagerJoinReq;
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

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public Manager(ManagerJoinReq managerJoinReq){
        nickname = managerJoinReq.getNickname();
        password = PasswordUtils.encryptPassword(managerJoinReq.getPassword());
    }
}
