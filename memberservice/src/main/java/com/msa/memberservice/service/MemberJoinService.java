package com.msa.memberservice.service;

import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.DuplicateMemberException;
import com.msa.memberservice.service.port.MemberJoinPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberJoinService {

    private final MemberJoinPort memberJoinPort;
    private final MemberTypeConverter typeConverter;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long joinMemberAccount ( MemberDto memberDto ) throws DuplicateMemberException {

        Member newMember = typeConverter.toMember(memberDto);

        checkIsDuplicateMember(newMember.getPhoneNumber());
        /*
        * 실제라면 프론트 단에서 비밀번호를 암호화 하는 것이 맞는 것 같다.
        * 비일번호 암호화 SHA512
        * */
        String encryptedPassword = passwordEncoder.encode(newMember.getPassword());
        newMember.makePasswordEncrypted(encryptedPassword);

        return memberJoinPort.joinMember(newMember);
    }

    private void checkIsDuplicateMember(String phoneNumber) throws DuplicateMemberException {
        memberJoinPort.isExistingMember(phoneNumber);
    }


}
