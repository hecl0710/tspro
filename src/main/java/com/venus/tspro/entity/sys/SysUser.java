package com.venus.tspro.entity.sys;

import lombok.Data;

import java.util.List;

@Data
public class SysUser {
    private String userId;
    private String userName;
    private String password;
    private String status;
    private String optUser;
    private List<SysRole> roles;
    private List<SysPermission> permissions;
}
