package com.pandorabox.aniwalk.repository;

import com.pandorabox.aniwalk.domain.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByNicknameAndPassword(String nickname, String password);
    Optional<Manager> findByNickname(String nickname);
}
