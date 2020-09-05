package com.venus.tspro.global;

import lombok.Data;

@Data
public class ResponseData<T> extends BaseResponse{
    T data;
    public ResponseData(String code, String msg, T data){
        super(code,msg);
        this.data = data;
    }
}
