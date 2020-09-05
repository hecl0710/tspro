package com.venus.tspro.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BizException extends RuntimeException{
    String code;
    String msg;
}
