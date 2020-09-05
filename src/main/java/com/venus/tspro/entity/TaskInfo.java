package com.venus.tspro.entity;

import com.venus.tspro.global.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInfo extends BaseEntity {
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
    private String updateTme;
}
