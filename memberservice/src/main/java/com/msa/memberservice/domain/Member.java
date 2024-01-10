package com.msa.memberservice.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Slf4j
@Entity
public class Member {

    protected Member() {}

    public Member(String email, String name, String password, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.joinDate = LocalDateTime.now();
    }

    @GeneratedValue
    @Id
    private Long id;

    private String email;

    @Column( name = "member_name")
    private String name;

    private String password;

    private LocalDateTime joinDate;

    private String phoneNumber;

    public void makePasswordEncrypted(String encryptedPassword) {
        this.password = encryptedPassword;
    }

}
