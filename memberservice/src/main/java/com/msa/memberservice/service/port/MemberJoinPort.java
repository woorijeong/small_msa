package com.msa.memberservice.service.port;

import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.DuplicateMemberException;

public interface MemberJoinPort {

    public Long joinMember( Member member );
    public void isExistingMember ( String phoneNumber ) throws DuplicateMemberException;
}
