package com.msa.memberservice.service.port;

import java.util.List;

public interface MemberOrderInfoFindPort {
    public List<Object> findMemberOrderList(Long memberId);
}
