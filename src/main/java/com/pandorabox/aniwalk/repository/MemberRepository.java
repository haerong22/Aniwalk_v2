package com.pandorabox.aniwalk.repository;

import com.pandorabox.aniwalk.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findByNicknameContains(String search, Pageable pageable);
}
