package com.msa.memberservice.exception;

public class DuplicateMemberException extends Exception{
    public DuplicateMemberException(String message) {
        super(message);
    }
}
