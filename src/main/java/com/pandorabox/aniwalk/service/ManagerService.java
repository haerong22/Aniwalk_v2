package com.pandorabox.aniwalk.service;

import com.pandorabox.aniwalk.domain.entity.Manager;
import com.pandorabox.aniwalk.domain.network.request.ManagerReq;
import com.pandorabox.aniwalk.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Transactional
    public void save(ManagerReq managerReq) {
        managerRepository.save(new Manager(managerReq));
    }
}
