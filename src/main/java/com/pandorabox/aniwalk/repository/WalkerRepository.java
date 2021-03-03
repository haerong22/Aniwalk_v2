package com.pandorabox.aniwalk.repository;

import com.pandorabox.aniwalk.domain.entity.Walker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {
}
