package com.msa.memberservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class MemberDto implements Serializable {

    protected MemberDto() {}

    @Null
    private Long id;
    private String email;
    private String name;
    @Null
    private String password;
    private String phoneNumber;
    @Null
    private LocalDateTime joinDate;



}
