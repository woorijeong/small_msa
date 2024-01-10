package com.msa.memberservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class RequestMember implements Serializable  {
    protected RequestMember() {
    }

    @Email
    @NotNull( message = "Email can not be empty" )
    private String email;
    @NotNull( message = "Name can not be empty" )
    private String name;
    @NotNull( message = "Pwd can not be empty" )
    @Size( min = 8, message = "Pwd has to be over 8 letter" )
    private String password;

    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$"
            , message = "phoneNumber has to be between 10 and 11 number")
    private String phoneNumber;
}
