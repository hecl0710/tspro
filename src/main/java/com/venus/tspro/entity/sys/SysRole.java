package com.venus.tspro.entity.sys;

import lombok.Data;

import java.util.List;

@Data
public class SysRole {
    private String roleId;
    private String roleName;
    private String status;
    private String optUser;
    private List<String> permissions;
    private String createTime;
    private String updateTime;
}
