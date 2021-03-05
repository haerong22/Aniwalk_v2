package com.pandorabox.aniwalk.service;

import com.pandorabox.aniwalk.domain.entity.Manager;
import com.pandorabox.aniwalk.domain.network.request.manager.ManagerJoinReq;
import com.pandorabox.aniwalk.domain.network.response.manager.ManagerListResp;
import com.pandorabox.aniwalk.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Transactional
    public String save(ManagerJoinReq managerJoinReq) {
        Manager save = managerRepository.save(new Manager(managerJoinReq));
        return save.getNickname();
    }

    public List<ManagerListResp> findAll() {
        return managerRepository.findAll().stream()
                .map(ManagerListResp::of).collect(Collectors.toList());
    }
}
