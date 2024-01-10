package com.msa.memberservice.service.port;

import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.NoFoundMemberInfoException;

public interface MemberFindPort {

    public Member findMember( Long memberId ) throws NoFoundMemberInfoException;
}
