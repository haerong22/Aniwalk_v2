package com.pandorabox.aniwalk.service;

import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.repository.WalkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalkerService {

    private final WalkerRepository walkerRepository;

    @Transactional
    public void save(Walker walker) {
        walkerRepository.save(walker);
    }
}
