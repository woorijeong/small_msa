package com.msa.memberservice.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import org.springframework.stereotype.Component;

@Component
public class MemberTypeConverter {
    public MemberDto toMemberDto ( Member member ) {
        JsonMapper mapper = new JsonMapper();
        return mapper.convertValue(member, MemberDto.class);
    }

    public Member toMember ( MemberDto memberDto ) {
        Member newMember = new Member(memberDto.getEmail(), memberDto.getName()
                , memberDto.getPassword(), memberDto.getPhoneNumber());
        return newMember;
    }
}
