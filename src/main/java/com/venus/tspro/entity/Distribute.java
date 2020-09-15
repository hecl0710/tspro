package com.venus.tspro.entity;

import com.venus.tspro.global.BaseEntity;
import lombok.Data;

/**
 * 结算实体类
 */
@Data
public class Distribute extends BaseEntity {

    /**
     * 企业编号
     */
    private String custId;
    /**
     * 个人编号
     */
    private String empId;
    /**
     * 税源编号
     */
    private String tsId;
    /**
     * 支付渠道编码
     */
    private String channelId;
    /**
     * 结算账户
     */
    private String accountNo;
    /**
     * 结算账户名称
     */
    private String accountName;
    /**
     * 结算金额
     */
    private String amount;
    /**
     * 结算日期(yyyymmdd)
     */
    private String settDate;
    /**
     * 结算状态，1，已结算，2，待结算，3，结算失败。
     */
    private String status;
    /**
     * 结算发起时间
     */
    private String creatTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 姓名
     */
    private String empName;

    /**
     * 证件类型
     */
    private String documentType;
    /**
     * 证件号码
     */
    private String identifyId;
    /**
     * 手机号
     */
    private String phone;
}
