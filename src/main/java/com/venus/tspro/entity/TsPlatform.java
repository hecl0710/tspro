package com.venus.tspro.entity;

import lombok.Data;

/**
 * 税源地企业实体类
 */
@Data
public class TsPlatform {

    /**
     *     税源地企业编码
     */
    private String companyId;
    /**
     * 税源地企业名称
     */
    private String companyName;
    /**
     * 状态，1，正常，0，异常
     */
    private String status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 最后更新操作人
     */
    private String optUser;
}
