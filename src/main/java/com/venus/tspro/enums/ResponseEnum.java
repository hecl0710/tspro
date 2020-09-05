package com.venus.tspro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS("0000","SUCCESS"),
    UNKNOWN_ERROR("9999","未知异常");
    private String code;
    private String msg;

}
