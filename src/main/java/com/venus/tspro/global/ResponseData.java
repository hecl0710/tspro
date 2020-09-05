package com.venus.tspro.global;

import lombok.Data;

@Data
public class ResponseData<T> {
    String code;
    String msg;
    T data;
    public ResponseData(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponseData(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
