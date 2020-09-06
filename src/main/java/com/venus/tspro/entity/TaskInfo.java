package com.venus.tspro.entity;

import com.venus.tspro.global.BaseEntity;
import lombok.Data;

/**
 *  任务信息实体类
 */
@Data
public class TaskInfo extends BaseEntity{
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 客户编号
     */
    private String custId;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务详情
     */
    private String taskDetail;

    /**
     * 人员技能
     */
    private String staffSkills;
    /**
     * 发送状态，1，发放完成，2，待发放，3，部分发放失败，4，已取消。
     */
    private String status;
    /**
     * 发放金额
     */
    private String amount;
    /**
     * 总税费
     */
    private String taxFee;
    /**
     * 服务费
     */
    private String fee;
    /**
     * 开票状态，1，开票完成，2，待开票。
     */
    private String billStatus;
    /**
     * 发票寄送状态，1，已寄送，2，待寄送。
     */
    private String deliveryStatus;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 客户名称
     */
    private String custName;
    /**
     * 公司业务
     */
    private String companyBusiness;
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 税源地企业名称
     */
    private String companyName;
}
