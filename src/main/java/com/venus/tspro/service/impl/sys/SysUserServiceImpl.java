package com.venus.tspro.service.impl.sys;

import com.venus.tspro.dao.sys.SysUserDao;
import com.venus.tspro.entity.sys.SysUser;
import com.venus.tspro.service.sys.SysUserService;
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
