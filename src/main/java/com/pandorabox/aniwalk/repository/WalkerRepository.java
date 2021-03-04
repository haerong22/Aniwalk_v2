package com.pandorabox.aniwalk.repository;

import com.pandorabox.aniwalk.domain.entity.Walker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {

    Page<Walker> findByNameContains(String name, Pageable pageable);
}
