package com.venus.tspro.service.impl;

import com.venus.tspro.dao.SysUserDao;
import com.venus.tspro.entity.SysUser;
import com.venus.tspro.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserDao sysUserDao;

    @Override
    public SysUser querySysUser(SysUser sysUser) {
        return sysUserDao.querySysUser(sysUser);
    }
}
