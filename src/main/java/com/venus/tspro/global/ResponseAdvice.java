package com.venus.tspro.global;

import com.venus.tspro.enums.ResponseEnum;
import com.venus.tspro.exception.BizException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice(basePackages = "com.venus.tspro")
public class ResponseAdvice  implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(Objects.isNull(o))
            return ResponseBuilder.buildSuccessResponse();
        return ResponseBuilder.buildSuccessResponse(o);
    }

    @ExceptionHandler(BizException.class)
    public ResponseData bizExceptionHandle(BizException bizException){
        return ResponseBuilder.buildFailResponse(bizException.getCode(),bizException.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHanle(Exception exception){
        return ResponseBuilder.buildFailResponse(ResponseEnum.UNKNOWN_ERROR.getCode(),ResponseEnum.UNKNOWN_ERROR.getMsg());
    }
}
