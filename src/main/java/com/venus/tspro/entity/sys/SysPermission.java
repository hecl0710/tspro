package com.venus.tspro.entity.sys;

import lombok.Data;

@Data
public class SysPermission {
    private String permissionId;
    private String permissionName;
    private String status;
    private String url;
    private String optUser;
    private String createTime;
    private String updateTime;
}
