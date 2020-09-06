package com.venus.tspro.entity;

import lombok.Data;

/**
 * 税源地实体类
 */
@Data
public class TaxSource {
    private String tsId;
    private String tsName;
    private String tsAgreement;
    private String perVAT;
    private String perCMT;
    private String perEST;
    private String perPIT;
    private String perVatRemain;
    private String perVatRefund;
    private String perPitRemain;
    private String perPitRefund;
    private String pitAvoidAmount;
    private String status;
    private String createTime;
    private String updateTime;
    private String optUser;
}
