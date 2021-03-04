package com.pandorabox.aniwalk.service;

import com.pandorabox.aniwalk.domain.entity.Walker;
import com.pandorabox.aniwalk.domain.network.request.SearchReq;
import com.pandorabox.aniwalk.domain.network.request.walker.WalkerJoinReq;
import com.pandorabox.aniwalk.domain.network.response.walker.WalkerListResp;
import com.pandorabox.aniwalk.repository.WalkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalkerService {

    private final WalkerRepository walkerRepository;

    @Transactional
    public String save(WalkerJoinReq walkerJoinReq) {
        Walker save = walkerRepository.save(Walker.of(walkerJoinReq));
        return save.getName();
    }

    public Page<WalkerListResp> getWalkerList(SearchReq searchReq) {
        Page<Walker> result = walkerRepository.findByNameContains(
                searchReq.getSearch(),
                PageRequest.of(searchReq.getPage() - 1, 5, Sort.by("applyDate").descending())
        );

        return new PageImpl<>(
                result.stream().map(WalkerListResp::of).collect(Collectors.toList()),
                result.getPageable(),
                result.getTotalElements()
        );
    }
}
