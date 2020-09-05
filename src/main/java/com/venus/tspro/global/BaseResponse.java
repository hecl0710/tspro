package com.venus.tspro.global;

import lombok.Data;

@Data
public class BaseResponse {
    String code;
    String msg;
    public BaseResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
