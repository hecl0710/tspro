package com.venus.tspro.entity;

import lombok.Data;

/**
 * 客户信息实体类
 *
 */
@Data
public class CustomerInfo {

    /**
     * 客户编码
     */
    private String custId;

    /**
     * 公司业务
     */
    private String companyBusiness;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 营业执照编码
     */
    private String businessLicence;
    /**
     * 所属行业
     */
    private String mcc;
    /**
     * 法人身份证
     */
    private String legalId;
    /**
     * 法人姓名
     */
    private String legalName;
    /**
     * 打款账户
     */
    private String accountNo;
    /**
     * 账户名称
     */
    private String accountName;
    /**
     * 开户行
     */
    private String accountBank;
    /**
     * 联系手机号
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 状态，1，正常，0，关闭
     */
    private String status;
    /**
     * 合同存放路径
     */
    private String agreement;
    /**
     *  服务费率
     */
    private String serviceFee;
    /**
     *   创建时间
     */
    private String createTime;
    /**
     *  更新时间
     */
    private String updateTime;
    /**
     *  最后更新操作人
     */
    private String optUser;
}
