package com.venus.tspro.global;

import com.alibaba.fastjson.JSON;
import com.venus.tspro.enums.ResponseEnum;
import com.venus.tspro.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice(basePackages = "com.venus.tspro")
@Slf4j
public class ResponseAdvice  implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("待响应：{}",JSON.toJSONString(o));
        if(o instanceof BaseResponse)
            return o;
        if(Objects.isNull(o))
            return ResponseBuilder.buildSuccessResponse();
        return ResponseBuilder.buildSuccessResponse(o);
    }

    @ExceptionHandler(BizException.class)
    public BaseResponse bizExceptionHandle(BizException bizException){
        log.error("业务处理异常->{}:{}",bizException.getCode(),bizException.getMsg(),bizException);
        return ResponseBuilder.buildFailResponse(bizException.getCode(),bizException.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandle(Exception exception){
        log.error("系统处理异常：", exception);
        return ResponseBuilder.buildFailResponse(ResponseEnum.UNKNOWN_ERROR.getCode(),ResponseEnum.UNKNOWN_ERROR.getMsg());
    }
}
