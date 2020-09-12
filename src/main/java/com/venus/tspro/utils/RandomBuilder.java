package com.venus.tspro.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomBuilder {
    public static final String buildRandomStr(int len){
        return RandomStringUtils.randomNumeric(len);
    }
}
