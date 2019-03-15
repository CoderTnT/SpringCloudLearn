package com.cooper.common.dto;

import java.io.Serializable;

/**
 * @author liaoshaojie
 * @creatdate 2019/3/11
 * @describe
 */
public class RespDTO<T> implements Serializable {

    public int code = 0;
    public String error = "";
    public T data;

    public static RespDTO onSuc(Object data) {
        RespDTO resp = new RespDTO();
        resp.data = data;
        return resp;
    }

    @Override
    public String toString() {
        return "RespDTO{" +
                "code=" + code +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}
