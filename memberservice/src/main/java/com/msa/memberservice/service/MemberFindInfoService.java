package com.msa.memberservice.service;

import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.NoFoundMemberInfoException;
import com.msa.memberservice.service.port.MemberFindPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberFindInfoService {

    private final MemberFindPort memberFindPort;
    private final MemberTypeConverter typeConverter;

    @Transactional( readOnly = true )
    public MemberDto findMemberInfo(Long memberId ) throws NoFoundMemberInfoException{
        Member foundMember = memberFindPort.findMember(memberId);
        return typeConverter.toMemberDto(foundMember);
    }
}
