package com.venus.tspro.global;

import com.venus.tspro.enums.ResponseEnum;

public class ResponseBuilder {
    public static BaseResponse buildSuccessResponse(){
        return new BaseResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg());
    }
    public static <T> ResponseData<T> buildSuccessResponse(T data){
        return new ResponseData(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), data);
    }
    public static BaseResponse buildFailResponse(String code, String msg){
        return new BaseResponse(code,msg);
    }
}
