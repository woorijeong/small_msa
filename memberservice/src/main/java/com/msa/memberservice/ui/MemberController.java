package com.msa.memberservice.ui;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.msa.memberservice.domain.Member;
import com.msa.memberservice.dto.MemberDto;
import com.msa.memberservice.exception.DuplicateMemberException;
import com.msa.memberservice.exception.NoFoundMemberInfoException;
import com.msa.memberservice.service.MemberFindInfoService;
import com.msa.memberservice.service.MemberJoinService;
import com.msa.memberservice.service.MemberOrderInfoLoadService;
import com.msa.memberservice.vo.RequestMember;
import com.msa.memberservice.vo.ResponseMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    
    /*
    * db사용 서비스
    * */
    private final MemberFindInfoService findInfoService;
    private final MemberJoinService joinService;
    /*
    * Restful API사용 서비스
    * */
    private final MemberOrderInfoLoadService orderInfoLoadService;

    @GetMapping("/members/info/{memberId}")
    public ResponseEntity<Object> findMemberInfo(Long memberId) {
        try{
            JsonMapper mapper = new JsonMapper();
            MemberDto foundMemberInfoDto = findInfoService.findMemberInfo(memberId);
            ResponseMember foundMemberInfo = mapper.convertValue(foundMemberInfoDto, ResponseMember.class);

            return ResponseEntity.status(200).body(foundMemberInfo);

        }catch( NoFoundMemberInfoException e ) {
            return ResponseEntity.status(400).body("존재하지 않는 사용자 정보입니다.");
        }
    }

    @GetMapping("/members/info/orders/{id}")
    public ResponseEntity<List<Object>> findMemberOrderList() {


        return null;
    }

    @PostMapping ("/members/info")
    public ResponseEntity<Object> findMemberInfo( final RequestMember joinInfo ) {
        try{
            JsonMapper mapper = new JsonMapper();
            MemberDto joinInfoDto = mapper.convertValue(joinInfo, MemberDto.class);
            Long joinedMemberId = joinService.joinMemberAccount(joinInfoDto);

            return ResponseEntity.status(201).body(joinedMemberId);

        }catch( DuplicateMemberException e ) {
            return ResponseEntity.status(400).body("중복된 사용자 정보입니다.");
        }
    }


}
