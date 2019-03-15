package com.cooper.common.exception;

/**
 * @author liaoshaojie
 * @creatdate 2019/3/11
 * @describe
 */
public class CommonException extends RuntimeException {

    private ErrorCode errorCode;


    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessgage());
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public int getCode() {
        return errorCode.getCode();
    }

    public String getMsg() {
        return errorCode.getMessgage();
    }
}
