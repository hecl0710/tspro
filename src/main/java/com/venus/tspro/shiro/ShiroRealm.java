package com.venus.tspro.shiro;

import com.venus.tspro.entity.sys.SysPermission;
import com.venus.tspro.entity.sys.SysUser;
import com.venus.tspro.service.sys.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Slf4j
public class ShiroRealm {
//public class ShiroRealm extends AuthorizingRealm {

//    @Resource
//    SysUserService sysUserService;
//    SysUser sysUser = new SysUser();
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        sysUser.setUserName((String) principalCollection.getPrimaryPrincipal());
//        sysUser = sysUserService.querySysUser(sysUser);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for(SysPermission sysPermission : sysUser.getPermissions())
//            simpleAuthorizationInfo.addStringPermission(sysPermission.getPermissionId());
//        return simpleAuthorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        sysUser.setUserName(token.getUsername());
//        sysUser = sysUserService.querySysUser(sysUser);
//        if(sysUser!=null)
//            return new SimpleAuthenticationInfo(token.getUsername(),sysUser.getPassword(),getName());
//        throw new UnknownAccountException();
//    }
}
