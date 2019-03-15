package com.cooper.common.exception;

/**
 * @author liaoshaojie
 * @creatdate 2019/3/11
 * @describe 通用错误码
 */
public enum ErrorCode {
    OK(0,""),
    FAIL(-1,"操作失败"),
    RPC_ERROR(-2,"远程调度失败"),
    USER_NOT_FOUND(1000, "用户不存在"),
    USER_PASSWORD_ERROR(1001, "用户密码错误"),
    GET_TOKEN_FAIL(1002, "获取token失败"),
    TOKEN_IS_NOT_MATCH_USER(1003,
            "请使用自己的token进行接口请求"),
    BLOG_IS_NOT_EXIST(2001,"该博客不存在")
    ;

    private int code;
    private String messgage;

    ErrorCode(int code, String messgage) {
        this.code = code;
        this.messgage = messgage;
    }

    public int getCode() {
        return code;
    }

    public String getMessgage() {
        return messgage;
    }


    public static ErrorCode codeOf(int code) {
        for (ErrorCode state : values()) {
            if (state.getCode() == code) {
                return state;
            }
        }
        return null;
    }
}
