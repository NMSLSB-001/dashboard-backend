package com.example.dashboardbackend.result;

import lombok.Getter;

@Getter
public class UserResult {
    private Integer code;
    private String message;
    private Object obj;

    private UserResult(Integer code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public static UserResult nohandler() {
        return new UserResult(UserResultCode.NOHANDLER.getCode(), UserResultCode.NOHANDLER.getMessage(),null);
    }
    public static UserResult success(Object data) {
        return new UserResult(UserResultCode.SUCCESS.getCode(), UserResultCode.SUCCESS.getMessage(),data);
    }
    public static UserResult failed() {
        return new UserResult(UserResultCode.FAILED.getCode(), UserResultCode.FAILED.getMessage(),null);
    }
    public static UserResult failed(String message) {
        return new UserResult(UserResultCode.FAILED.getCode(),message,null);
    }
    public static UserResult notoken() {
        return new UserResult(UserResultCode.NOTOKEN.getCode(), UserResultCode.NOTOKEN.getMessage(),null);
    }
    public static UserResult nopremiss() {
        return new UserResult(UserResultCode.NOPERMISS.getCode(), UserResultCode.NOPERMISS.getMessage(),null);
    }
}
