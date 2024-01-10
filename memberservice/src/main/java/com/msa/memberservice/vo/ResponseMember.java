package com.msa.memberservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class ResponseMember implements Serializable {

    protected ResponseMember() {
    }

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private LocalDateTime joinDate;
}
