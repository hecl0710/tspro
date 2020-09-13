package com.venus.tspro.utils;

/**
 * 编码生成器
 */
public class SeqBuilder {

    /**
     * 税源地编码生成
     * @return
     */
    public static String buildTaxSourceId(){
        return "TS"+RandomBuilder.buildRandomStr(6);
    }

    /**
     * 税源企业编码生成
     * @return
     */
    public static String buildTaxCompanyId(){
        return "TC"+RandomBuilder.buildRandomStr(6);
    }
}