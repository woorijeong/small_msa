package com.msa.memberservice.service;

import com.msa.memberservice.service.port.MemberOrderInfoFindPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberOrderInfoLoadService {

    private final MemberOrderInfoFindPort memberOrderInfoFindPort;

    /*
    * order domain의 data가 필요하므로 DB 직접조회가 아닌 feing client 사용
    * msa, Restful API
    * 서비스가 참조하는 구현체는 domain 처럼, MemberOrderInfoFindPort 구현
    * */
}
