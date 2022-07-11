package com.example.dashboardbackend.result;

import lombok.Getter;

@Getter
public enum UserResultCode {

    NOHANDLER(404,"Request Address Error"),
    SUCCESS(200,"Request Successful"),
    FAILED(500,"Request Failed"),
    NOTOKEN(401,"Not Login or Login Time Out"),
    NOPERMISS(403,"No Request Permission"),;


    private Integer code;
    private String message;

    UserResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
