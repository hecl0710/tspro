package com.venus.tspro.entity;

import lombok.Data;

@Data
public class BillInfo {
    private String billId;
    private String billCode;
    private String custId;
    private String custName;
    private String taskId;
    private String taskName;
    private String taskAmount;
    private String billStatus;
    private String billAmount;
    private String deliveryStatus;
    private String deliveryCode;
    private String createTime;
    private String updateTime;
    private String optUser;

}
