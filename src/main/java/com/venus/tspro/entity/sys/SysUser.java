package com.venus.tspro.entity.sys;

import lombok.Data;

@Data
public class SysUser {
    private String userId;
    private String userName;
    private String password;
    private String status;
    private String[] role;
}
