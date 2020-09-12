package com.venus.tspro.entity;

import lombok.Data;

/**
 * 税源企业实体类
 */
@Data
public class TaxCompany {
    private String companyId;
    private String companyName;
    private String businessLicence;
    private String legalName;
    private String legalId;
    private String status;
    private String createTime;
    private String updateTime;
    private String optUser;
}
