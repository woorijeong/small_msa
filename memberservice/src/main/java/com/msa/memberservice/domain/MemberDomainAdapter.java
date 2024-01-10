package com.msa.memberservice.domain;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.DuplicateMemberException;
import com.msa.memberservice.exception.NoFoundMemberInfoException;
import com.msa.memberservice.service.port.MemberFindPort;
import com.msa.memberservice.service.port.MemberJoinPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MemberDomainAdapter implements MemberFindPort, MemberJoinPort {

    private final MemberRepository memberRepository;
    @Override
    public Member findMember( Long memberId ) throws NoFoundMemberInfoException {
        Member foundMember = memberRepository.findById(memberId)
                        .orElseThrow(() -> new NoFoundMemberInfoException("해당 사용자는 존재하지 않습니다."));
        return  foundMember;
    }

    @Override
    public Long joinMember( Member member ){
        Member joinedMember = memberRepository.save(member);
        return joinedMember.getId();
    }

    @Override
    public void isExistingMember(String phoneNumber) throws DuplicateMemberException {
        if( memberRepository.findByPhoneNumber(phoneNumber).isPresent() ) {
            throw new DuplicateMemberException("중복 가입된 사용자가 존재합니다.");
        }
    }


}
